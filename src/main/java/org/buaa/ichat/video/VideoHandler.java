package org.buaa.ichat.video;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.service.UserService;
import org.kurento.client.EventListener;
import org.kurento.client.IceCandidate;
import org.kurento.client.IceCandidateFoundEvent;
import org.kurento.client.KurentoClient;
import org.kurento.jsonrpc.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/videoCall")
@Component
public class VideoHandler {

    // ConcurrentHashMap: 相当于线程安全的HashMap.
    // 这里存储 useruserID-UserSession
    private static ConcurrentHashMap<String, UserSession> usersByUserID = new ConcurrentHashMap<>();
    // 这里则是 Session.id-UserSession
    private static ConcurrentHashMap<String, UserSession> usersBySessionId = new ConcurrentHashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(VideoHandler.class);
    private static final Gson gson = new GsonBuilder().create(); // Gson: 把 Java 对象转换为 Json 表达式
    // 判断 callee 是否接听
    private boolean isResponse = false;

    private final ConcurrentHashMap<String, CallMediaPipeline> pipelines = new ConcurrentHashMap<>();

    private static VideoHandler videoHandler;
    @Autowired
    private UserService userService;

    @Autowired
    private KurentoClient kurento;

    // 解决 @Autowired 为空指针的问题
    @PostConstruct
    private void init() {
        videoHandler = this;
        videoHandler.userService = this.userService;
        videoHandler.kurento = this.kurento;
    }

    private UserService getUserService() {
        return videoHandler.userService;
    }

    private KurentoClient getKurento() {
        return videoHandler.kurento;
    }

    /*
     * 连接成功建立时调用
     */
    @OnOpen
    public void onOpen(Session session) {
        logger.info(session.getId() + " is connecting");
    }

    /*
     * 关闭连接时调用
     * 需要关闭前面建立的媒体管道以及移出在线用户列表
     */
    @OnClose
    public void onClose(Session session) throws Exception {
        logger.info(session.getId() + " closed.");
        stop(session, "websocket closed");
        removeBySession(session);
    }

    /*
     * 连接出错时调用
     * 修改用户状态
     */
    @OnError
    public void onError(Session session, Throwable error) throws Exception {
        UserSession user = getUserSessionBySession(session);
        if (user != null)
            user.setStateFree();
        stop(session, error.getMessage());
        error.printStackTrace();
    }

    /*
     * 收到消息时调用
     * 根据消息的类别调用不同的方法
     */
    @OnMessage
    public void onMessage(Session session, String message) throws Exception {
        JsonObject jsonMessage = gson.fromJson(message, JsonObject.class);
        UserSession user = getUserSessionBySession(session);
        switch (jsonMessage.get("type").getAsString()) {
            case "ping": // 心跳连接用
                JsonObject pongMessage = new JsonObject();
                pongMessage.addProperty("type", "pong");
                session.getAsyncRemote().sendText(pongMessage.toString());
                break;
            case "login":
                logger.info("receive message: " + message);
                try {
                    login(session, jsonMessage);
                } catch (Throwable t) {
                    ErrorResponse(t, session, "loginResponse");
                }
                break;
            case "call":
                logger.info("receive message: " + message);
                try {
                    call(user, jsonMessage);
                } catch (Throwable t) {
                    ErrorResponse(t, session, "callResponse");
                }
                break;
            case "stopCall":
                logger.info("receive message: " + message);
                callerStopCall(user);
                break;
            case "incomingCallResponse":
                logger.info("receive message: " + message);
                incomingCallResponse(user, jsonMessage);
                break;
            case "onIceCandidate": {
                JsonObject candidate = jsonMessage.get("candidate").getAsJsonObject();
                if (user != null) {
                    IceCandidate cand =
                            new IceCandidate(candidate.get("candidate").getAsString(), candidate.get("sdpMid")
                                    .getAsString(), candidate.get("sdpMLineIndex").getAsInt());
                    user.addCandidate(cand);
                }
                break;
            }
            case "stop": // 正常退出
                logger.info("receive message: " + message);
                stop(session, "normal");
                break;
            default:
                break;
        }
    }

    // 用户上线，加入在线列表
    private void login(Session session, JsonObject jsonObject) throws IOException {
        String userID = jsonObject.get("userID").getAsString();
        UserSession user = new UserSession(session, userID);
        online(user);
        logger.info("userID: " + userID + " is online.");
    }

    // 检查用户是否在线，没有就返回对方不在线消息，有就向被呼叫用户发送消息
    private void call(UserSession caller, JsonObject jsonMessage) throws IOException {
        String callerID = jsonMessage.get("callerID").getAsString();
        String calleeID = jsonMessage.get("calleeID").getAsString();

        JsonObject response = new JsonObject();
        if (!exists(calleeID)) {
            response.addProperty("type", "callResponse");
            response.addProperty("callResponse", "notOnline");
            caller.sendMessage(response);
            logger.info("videoCall: " + callerID + " call to " + calleeID + ": NotOnline.");
            return;
        }

        UserSession callee = getUserSessionByUserID(calleeID);

        // 判断对方是不是正忙
        if (callee.isBusy()) {
            response.addProperty("type", "callResponse");
            response.addProperty("callResponse", "isBusy");
            caller.sendMessage(response);
            logger.info("videoCall: " + callerID + " call to " + calleeID + ": isBusy.");
            return;
        }

        // 设置呼叫者正忙状态
        caller.setStateBusy();
        callee.setStateBusy();

        caller.setSdpOffer(jsonMessage.getAsJsonPrimitive("sdpOffer").getAsString());
        caller.setCallingTo(calleeID);

        response.addProperty("type", "incomingCall");
        response.addProperty("callerID", callerID);
        User user = null;
        // 发送对方的用户名、头像
        try {
            user = getUserService().getInfo(new Integer(callerID));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.addProperty("username", user.getUsername());
        response.addProperty("avatar", user.getAvatar());

        callee.sendMessage(response);
        callee.setCallingFrom(callerID);
        logger.info("videoCall: " + callerID + " call to " + calleeID);

        // 设置 callee 未接听状态
        callee.setResponse(false);
        // 发起倒计时
        ifNotResponse(callee, caller);
    }

    // 15s 未应答就分别向 caller 和 callee 发送消息
    private void ifNotResponse(UserSession callee, UserSession caller) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("waiting " + callee.getuserID() + " response...");
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(!callee.isResponse()) {
                    logger.info(callee.getuserID() + "not response.");
                    // 向 callee 发消息告知不用等了
                    JsonObject messageForCallee = new JsonObject();
                    messageForCallee.addProperty("type", "incomingCallNotResponse");
                    // 需要取消 callee 的忙线状态
                    callee.setStateFree();
                    // 告知 caller 对方长时间没接听
                    JsonObject messageForCaller = new JsonObject();
                    messageForCaller.addProperty("type", "callResponse");
                    messageForCaller.addProperty("callResponse", "NotResponse");
                    try {
                        callee.sendMessage(messageForCallee);
                        caller.sendMessage(messageForCaller);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // callee 接通前，caller 主动挂掉电话，告诉 callee 对方挂断了
    private void callerStopCall(UserSession caller) {
        caller.setStateFree();
        String calleeID = caller.getCallingTo();
        UserSession callee = getUserSessionByUserID(calleeID);
        JsonObject message = new JsonObject();
        message.addProperty("type", "incomingCallStopped");
        try {
            callee.sendMessage(message);
        } catch (Exception e) {
            logger.debug("send message \"incomingCallStopped\" to callee");
            logger.debug(e.getMessage());
        }
        callee.setStateFree();
        // 告诉计时器不用再等了
        callee.setResponse(true);

    }


    // 被呼叫者向服务器返回应答信息
    private void incomingCallResponse(UserSession callee, JsonObject jsonMessage) throws IOException {
        String callResponse = jsonMessage.get("callResponse").getAsString();
        String callerID = jsonMessage.get("callerID").getAsString();
        UserSession caller = getUserSessionByUserID(callerID);
        String calleeID = caller.getCallingTo();

        // 设置 callee 接听状态
        callee.setResponse(true);

        // 被呼叫者拒绝通话
        if (!"accepted".equals(callResponse)) {
            JsonObject response = new JsonObject();
            response.addProperty("type", "callResponse");
            response.addProperty("callResponse", jsonMessage.get("callResponse").getAsString());
            caller.sendMessage(response);
            caller.setStateFree();
            logger.info("videoCall: " + callerID + " call to " + calleeID + "callee rejected!");
            return;
        }

        // 如果对方接受了呼叫请求，建立媒体管道 p2p 连接双方
        logger.info("videoCall: " + callerID + " call to " + calleeID + "accepted");
        // 创建一个 CallMediaPipeline对象，以封装媒体管道的创建和管理。然后，该对象用于与用户的浏览器协商媒体交换。
        CallMediaPipeline pipeline = null;
        try {
            pipeline = new CallMediaPipeline(getKurento());
            pipelines.put(caller.getSessionId(), pipeline);
            pipelines.put(callee.getSessionId(), pipeline);
            callee.setWebRtcEndpoint(pipeline.getCalleeWebRtcEp());
            pipeline.getCalleeWebRtcEp().addIceCandidateFoundListener(
                    new EventListener<IceCandidateFoundEvent>() {
                        @Override
                        public void onEvent(IceCandidateFoundEvent iceCandidateFoundEvent) {
                            JsonObject response = new JsonObject();
                            response.addProperty("type", "iceCandidate");
                            response.add("candidate", JsonUtils.toJsonObject(iceCandidateFoundEvent.getCandidate()));
                            try {
                                synchronized (callee.getSession()) {
                                    callee.sendMessage(response);
                                }
                            } catch (IOException e) {
                                logger.debug(e.getMessage());
                            }
                        }
                    });
            caller.setWebRtcEndpoint(pipeline.getCallerWebRtcEp());
            pipeline.getCallerWebRtcEp().addIceCandidateFoundListener(
                    new EventListener<IceCandidateFoundEvent>() {
                        @Override
                        public void onEvent(IceCandidateFoundEvent iceCandidateFoundEvent) {
                            JsonObject response = new JsonObject();
                            response.addProperty("type", "iceCandidate");
                            response.add("candidate", JsonUtils.toJsonObject(iceCandidateFoundEvent.getCandidate()));
                            try {
                                synchronized (caller.getSession()) {
                                    caller.sendMessage(response);
                                }
                            } catch (IOException e) {
                                logger.debug(e.getMessage());
                            }
                        }
                    });

            String calleeSdpOffer = jsonMessage.get("sdpOffer").getAsString();
            String calleeSdpAnswer = pipeline.generateSdpAnswerForCallee(calleeSdpOffer);
            JsonObject startCommunication = new JsonObject();
            startCommunication.addProperty("type", "startCommunication");
            startCommunication.addProperty("sdpAnswer", calleeSdpAnswer);

            synchronized (callee) {
                callee.sendMessage(startCommunication);
            }
            // 设置双方状态：calling
            callee.setStateCalling();
            caller.setStateCalling();

            pipeline.getCalleeWebRtcEp().gatherCandidates();

            String callerSdpOffer = getUserSessionByUserID(callerID).getSdpOffer();
            String callerSdpAnswer = pipeline.generateSdpAnswerForCaller(callerSdpOffer);
            JsonObject response = new JsonObject();
            response.addProperty("type", "callResponse");
            response.addProperty("callResponse", "accepted");
            response.addProperty("sdpAnswer", callerSdpAnswer);

            synchronized (caller) {
                caller.sendMessage(response);
            }

            pipeline.getCallerWebRtcEp().gatherCandidates();

        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            if (pipeline != null) {
                pipeline.release();
            }

            pipelines.remove(caller.getSessionId());
            pipelines.remove(callee.getSessionId());

            JsonObject response = new JsonObject();
            response.addProperty("type", "callResponse");
            response.addProperty("callResponse", "exception");
            caller.sendMessage(response);

            caller.setStateFree();
            callee.setStateFree();
        }
    }

    // 停止通话
    private void stop(Session session, String reason) throws IOException {
        String sessionId = session.getId();
        if (pipelines.containsKey(sessionId)) {
            pipelines.get(sessionId).release();
            CallMediaPipeline pipeline = pipelines.remove(sessionId);
            pipeline.release();
        }
        UserSession stopper = getUserSessionBySession(session);
        if (stopper == null) {
            logger.info("stop nothing.");
            return;
        }
        if (stopper.isCalling()) {
            stopper.setStateFree();
            UserSession stoppee =
                    (stopper.getCallingFrom() != null) ? getUserSessionByUserID(stopper.
                            getCallingFrom()) : stopper.getCallingTo() != null ? getUserSessionByUserID(stopper
                            .getCallingTo()) : null;
            logger.info(stopper.getuserID() + " stop.");
            if (stoppee != null) {
                stoppee.setStateFree();
                JsonObject message = new JsonObject();
                message.addProperty("type", "stopCommunication");
                message.addProperty("reason", reason);
                stoppee.sendMessage(message);
                stoppee.clear();
                logger.info(stoppee.getuserID() + " stop.");
            }
            stopper.clear();
        }
    }

    // 消息处理异常时调用，关闭会话并向对方返回错误消息
    private void ErrorResponse(Throwable throwable, Session session, String responseId) throws IOException {
        stop(session, throwable.getMessage());
        logger.error(throwable.getMessage(), throwable);
        JsonObject response = new JsonObject();
        response.addProperty("type", responseId);
        response.addProperty("content", "rejected");
        response.addProperty("error", throwable.getMessage());
        session.getAsyncRemote().sendText(response.toString());
    }

    // 下面是对上面两个 HashMap 的操作方法

    //用户上线，添加到 Map 中
    public void online(UserSession user) throws NullPointerException {
        usersByUserID.put(user.getuserID(), user);
        usersBySessionId.put(user.getSession().getId(), user);
    }

    public UserSession getUserSessionByUserID(String userID) {
        return usersByUserID.get(userID);
    }

    public UserSession getUserSessionBySession(Session session) {
        return usersBySessionId.get(session.getId());
    }

    public boolean exists(String userID) {
        return usersByUserID.keySet().contains(userID);
    }

    public UserSession removeBySession(Session session) {
        final UserSession user = getUserSessionBySession(session);
        if (user != null) {
            usersByUserID.remove(user.getuserID());
            usersBySessionId.remove(session.getId());
        }
        return user;
    }

    public void printOnlineUserID() {
        Iterator iter = usersByUserID.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

}
