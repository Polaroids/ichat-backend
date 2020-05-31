package org.buaa.ichat.video;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.kurento.client.EventListener;
import org.kurento.client.IceCandidate;
import org.kurento.client.IceCandidateFoundEvent;
import org.kurento.client.KurentoClient;
import org.kurento.jsonrpc.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/*
 * CallHandler 类实现TextWebSocketHandler用于处理文本WebSocket请求。
 * 该类的核心是方法handleTextMessage。此方法实现请求的操作，并通过WebSocket返回响应。
 * 换句话说，它实现了先前序列图中描述的信令协议的服务器部分。
 */
public class CallHandler extends TextWebSocketHandler {

  private static final Logger log = LoggerFactory.getLogger(CallHandler.class);
  private static final Gson gson = new GsonBuilder().create(); // Gson: 把 Java 对象转换为 Json 表达式

  private final ConcurrentHashMap<String, org.kurento.tutorial.one2onecall.CallMediaPipeline> pipelines = new ConcurrentHashMap<>();

  @Autowired
  private KurentoClient kurento;

  @Autowired
  private org.kurento.tutorial.one2onecall.UserRegistry registry;

  /*
   * 实现文本WebSocket请求的操作，并通过WebSocket返回响应。换句话说，它实现了先前序列图中描述的信令协议的服务器部分。
   * (与前端交互)
   */
  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    JsonObject jsonMessage = gson.fromJson(message.getPayload(), JsonObject.class);
    org.kurento.tutorial.one2onecall.UserSession user = registry.getBySession(session);

    if (user != null) {
      log.debug("Incoming message from user '{}': {}", user.getName(), jsonMessage);
    } else {
      log.debug("Incoming message from new user: {}", jsonMessage);
    }

    switch (jsonMessage.get("id").getAsString()) {
      case "register":
        try {
          register(session, jsonMessage);
        } catch (Throwable t) {
          handleErrorResponse(t, session, "registerResponse");
        }
        break;
      case "call":
        try {
          call(user, jsonMessage);
        } catch (Throwable t) {
          handleErrorResponse(t, session, "callResponse");
        }
        break;
      case "incomingCallResponse":
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
      case "stop":
        stop(session);
        break;
      default:
        break;
    }
  }

  private void handleErrorResponse(Throwable throwable, WebSocketSession session, String responseId)
      throws IOException {
    stop(session);
    log.error(throwable.getMessage(), throwable);
    JsonObject response = new JsonObject();
    response.addProperty("id", responseId);
    response.addProperty("response", "rejected");
    response.addProperty("message", throwable.getMessage());
    session.sendMessage(new TextMessage(response.toString()));
  }

  private void register(WebSocketSession session, JsonObject jsonMessage) throws IOException {
    String name = jsonMessage.getAsJsonPrimitive("name").getAsString();
    org.kurento.tutorial.one2onecall.UserSession caller = new org.kurento.tutorial.one2onecall.UserSession(session, name);
    String responseMsg = "accepted";
    if (name.isEmpty()) {
      responseMsg = "rejected: empty user name";
    } else if (registry.exists(name)) {
      responseMsg = "rejected: user '" + name + "' already registered";
    } else {
      registry.register(caller);
    }

    JsonObject response = new JsonObject();
    response.addProperty("id", "registerResponse");
    response.addProperty("response", responseMsg);
    caller.sendMessage(response);
  }

  /*
   * 检查对方用户是否存在，如果有，发送incomingCall, 否则拒绝呼叫
   */
  private void call(org.kurento.tutorial.one2onecall.UserSession caller, JsonObject jsonMessage) throws IOException {
    String to = jsonMessage.get("to").getAsString();
    String from = jsonMessage.get("from").getAsString();
    JsonObject response = new JsonObject();

    if(!registry.exists(to)) {
      response.addProperty("id", "callResponse");
      response.addProperty("response", "rejected: user '" + to + "' is not registered");

      caller.sendMessage(response);
    } else if(from.equals(to)) {
      response.addProperty("id", "callResponse");
      response.addProperty("response", "Cannot call to yourself");

      caller.sendMessage(response);
    } else {
      caller.setSdpOffer(jsonMessage.getAsJsonPrimitive("sdpOffer").getAsString());
      caller.setCallingTo(to);

      response.addProperty("id", "incomingCall");
      response.addProperty("from", from);

      org.kurento.tutorial.one2onecall.UserSession callee = registry.getByName(to);
      callee.sendMessage(response);
      callee.setCallingFrom(from);
    }

    /*
    if (registry.exists(to)) {
      caller.setSdpOffer(jsonMessage.getAsJsonPrimitive("sdpOffer").getAsString());
      caller.setCallingTo(to);

      response.addProperty("id", "incomingCall");
      response.addProperty("from", from);

      UserSession callee = registry.getByName(to);
      callee.sendMessage(response);
      callee.setCallingFrom(from);

      System.out.println(response);

    } else {
      response.addProperty("id", "callResponse");
      response.addProperty("response", "rejected: user '" + to + "' is not registered");

      caller.sendMessage(response);
    }
    */
  }

  /*
   * 对方返回呼叫请求处理的信息
   */
  private void incomingCallResponse(final org.kurento.tutorial.one2onecall.UserSession callee, JsonObject jsonMessage)
      throws IOException {
    String callResponse = jsonMessage.get("callResponse").getAsString();
    String from = jsonMessage.get("from").getAsString();
    final org.kurento.tutorial.one2onecall.UserSession calleer = registry.getByName(from);
    String to = calleer.getCallingTo();

    // 如果对方接受了呼叫请求，建立媒体管道 p2p 连接双方
    if ("accept".equals(callResponse)) {
      log.debug("Accepted call from '{}' to '{}'", from, to);

      // 创建一个 CallMediaPipeline对象，以封装媒体管道的创建和管理。然后，该对象用于与用户的浏览器协商媒体交换。
      org.kurento.tutorial.one2onecall.CallMediaPipeline pipeline = null;
      try {
        pipeline = new org.kurento.tutorial.one2onecall.CallMediaPipeline(kurento);
        pipelines.put(calleer.getSessionId(), pipeline);
        pipelines.put(callee.getSessionId(), pipeline);

        callee.setWebRtcEndpoint(pipeline.getCalleeWebRtcEp());
        pipeline.getCalleeWebRtcEp().addIceCandidateFoundListener(
            new EventListener<IceCandidateFoundEvent>() {

              @Override
              public void onEvent(IceCandidateFoundEvent event) {
                JsonObject response = new JsonObject();
                response.addProperty("id", "iceCandidate");
                response.add("candidate", JsonUtils.toJsonObject(event.getCandidate()));
                try {
                  synchronized (callee.getSession()) {
                    callee.getSession().sendMessage(new TextMessage(response.toString()));
                  }
                } catch (IOException e) {
                  log.debug(e.getMessage());
                }
              }
            });

        calleer.setWebRtcEndpoint(pipeline.getCallerWebRtcEp());
        pipeline.getCallerWebRtcEp().addIceCandidateFoundListener(
            new EventListener<IceCandidateFoundEvent>() {

              @Override
              public void onEvent(IceCandidateFoundEvent event) {
                JsonObject response = new JsonObject();
                response.addProperty("id", "iceCandidate");
                response.add("candidate", JsonUtils.toJsonObject(event.getCandidate()));
                try {
                  synchronized (calleer.getSession()) {
                    calleer.getSession().sendMessage(new TextMessage(response.toString()));
                  }
                } catch (IOException e) {
                  log.debug(e.getMessage());
                }
              }
            });

        String calleeSdpOffer = jsonMessage.get("sdpOffer").getAsString();
        String calleeSdpAnswer = pipeline.generateSdpAnswerForCallee(calleeSdpOffer);
        JsonObject startCommunication = new JsonObject();
        startCommunication.addProperty("id", "startCommunication");
        startCommunication.addProperty("sdpAnswer", calleeSdpAnswer);

        synchronized (callee) {
          callee.sendMessage(startCommunication);
        }

        pipeline.getCalleeWebRtcEp().gatherCandidates();

        String callerSdpOffer = registry.getByName(from).getSdpOffer();
        String callerSdpAnswer = pipeline.generateSdpAnswerForCaller(callerSdpOffer);
        JsonObject response = new JsonObject();
        response.addProperty("id", "callResponse");
        response.addProperty("response", "accepted");
        response.addProperty("sdpAnswer", callerSdpAnswer);

        synchronized (calleer) {
          calleer.sendMessage(response);
        }

        pipeline.getCallerWebRtcEp().gatherCandidates();

      } catch (Throwable t) {
        log.error(t.getMessage(), t);

        if (pipeline != null) {
          pipeline.release();
        }

        pipelines.remove(calleer.getSessionId());
        pipelines.remove(callee.getSessionId());

        JsonObject response = new JsonObject();
        response.addProperty("id", "callResponse");
        response.addProperty("response", "rejected");
        calleer.sendMessage(response);

        response = new JsonObject();
        response.addProperty("id", "stopCommunication");
        callee.sendMessage(response);
      }

    } else {
      JsonObject response = new JsonObject();
      response.addProperty("id", "callResponse");
      response.addProperty("response", "rejected");
      calleer.sendMessage(response);
    }
  }

  public void stop(WebSocketSession session) throws IOException {
    String sessionId = session.getId();
    if (pipelines.containsKey(sessionId)) {
      pipelines.get(sessionId).release();
      org.kurento.tutorial.one2onecall.CallMediaPipeline pipeline = pipelines.remove(sessionId);
      pipeline.release();

      // Both users can stop the communication. A 'stopCommunication'
      // message will be sent to the other peer.
      org.kurento.tutorial.one2onecall.UserSession stopperUser = registry.getBySession(session);
      if (stopperUser != null) {
        org.kurento.tutorial.one2onecall.UserSession stoppedUser =
            (stopperUser.getCallingFrom() != null) ? registry.getByName(stopperUser
                .getCallingFrom()) : stopperUser.getCallingTo() != null ? registry
                    .getByName(stopperUser.getCallingTo()) : null;

                    if (stoppedUser != null) {
                      JsonObject message = new JsonObject();
                      message.addProperty("id", "stopCommunication");
                      stoppedUser.sendMessage(message);
                      stoppedUser.clear();
                    }
                    stopperUser.clear();
      }

    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    stop(session);
    registry.removeBySession(session);
  }

}
