package org.buaa.ichat.websocket;

import org.buaa.ichat.entity.GroupMSG;
import org.buaa.ichat.entity.Message;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.service.FriendService;
import org.buaa.ichat.service.GroupService;
import org.buaa.ichat.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/chat/{userID}")
public class WebSocketServer {
    private final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private static final Map<Integer, Session> users = new ConcurrentHashMap<>();

    MessageService messageService;
    GroupService groupService;
    FriendService friendService;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //放入map中的key,用来表示该连接对象
    private Integer userID;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("userID") Integer userID,
                       Session session) throws Exception{
        try {
            this.session = session;
            this.userID = userID;

            users.put(userID, session);

            this.session.getBasicRemote().sendText("连接成功");

        } catch (IOException e) {
            logger.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        users.remove(this.userID);  //从set中删除
        logger.info("用户: " + this.userID + "的连接关闭");
    }

    /**
     * 收到客户端消息后触发的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(Integer receiverID, String message, Integer type) throws Exception {
        logger.info("来自客户端的消息:" + message);

        try {
            //121
            if(type == 0)
            {
                //sent默认0
                Integer msgID = messageService.insertMSG(this.userID, message, receiverID);
                Message msg = messageService.getMSGByID(msgID);

                //receiver online
                if(users.containsKey(receiverID))
                    users.get(receiverID).getBasicRemote().sendText(msg.toString());
                //receiver offline
                //nothing
            }
            //12n
            else if(type == 1)
            {
                Integer gmsgID = messageService.insertGMSG(this.userID, message, receiverID);
                GroupMSG groupMSG = messageService.getGMSGByID(gmsgID);

                List<User> members = groupService.getMembers(receiverID);

                for(User user: members)
                {
                    //member online
                    if(users.containsKey(user.getUserID()))
                        users.get(user.getUserID()).getBasicRemote().sendText(groupMSG.toString());
                    //member offline
                    //nothing
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误 session: "+session);
        error.printStackTrace();
    }
}