package org.buaa.ichat.websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.buaa.ichat.entity.GroupMSG;
import org.buaa.ichat.entity.Message;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.service.GroupService;
import org.buaa.ichat.service.MessageService;
import org.buaa.ichat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WSServer {
    private static final Logger logger = LoggerFactory.getLogger(WSServer.class);

    private static final Map<Integer, Session> users = new ConcurrentHashMap<>();

    private Integer ID;
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static WSServer wsServer;
    @Autowired
    private MessageService messageService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;

    private static final Gson gson = new GsonBuilder().create();

    // 解决 @Autowired 为空指针的问题
    @PostConstruct
    private void init() {
        wsServer = this;
        wsServer.messageService = this.messageService;
        wsServer.groupService = this.groupService;
        wsServer.userService = this.userService;
    }

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){

        logger.info(session.getId() + " is connecting wss");

        this.ID = -1;
        this.session = session;
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){

        logger.info(ID + "logout");

        users.remove(ID);
        logger.info(ID + "连接关闭");
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("来自"+ session.getId() + "的消息:" + message);

        JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
        Integer type = jsonObject.get("type").getAsInt();

        switch(type)
        {
            //121
            case 0:
                try
                {
                    if(this.ID < 0)
                        throw new Exception("wss login first pls");
                    Integer userID = jsonObject.get("ID").getAsInt();
                    String msg = jsonObject.get("message").getAsString();

                    logger.info(this.ID + ": \"" + msg + "\" to user:" + userID);

                    Integer msgID = getMessageService().insertMSG(this.ID, msg, userID);
                    Message message1 = getMessageService().getMSGByID(msgID);

                    logger.info("database insert msg over");

                    if(users.containsKey(userID))
                        users.get(userID).getBasicRemote().sendText(messageToJsonObject(message1).toString());
                    break;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            //12n
            case 1:
                try
                {
                    if(this.ID < 0)
                        throw new Exception("wss login first pls");
                    Integer groupID = jsonObject.get("ID").getAsInt();
                    String msg = jsonObject.get("message").getAsString();

                    logger.info(this.ID + ": \"" + msg + "\" to group:" + groupID);

                    Integer msgID = getMessageService().insertGMSG(this.ID, msg, groupID);
                    GroupMSG groupMSG = getMessageService().getGMSGByID(msgID);
                    List<User> members = getGroupService().getMembers(groupID);

                    logger.info("database insert gmsg over");

                    for(User member:members)
                    {
                        if(users.containsKey(member.getUserID()))
                            users.get(member.getUserID()).getBasicRemote().sendText(groupMSGToJsonObject(groupMSG).toString());
                    }
                    break;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            //login
            case 2:
                try
                {
                    if(this.ID > 0)
                        throw new Exception("you have login");
                    Integer ID = jsonObject.get("ID").getAsInt();
                    this.ID = ID;

                    logger.info(ID + " login wss");

                    users.put(ID, this.session);
                    break;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            //pingpong
            case 123:
                try
                {
                    JsonObject pongRet = new JsonObject();
                    pongRet.addProperty("type", 321);
                    session.getBasicRemote().sendText(pongRet.toString());
                    break;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        logger.error("发生错误");
        error.printStackTrace();
    }

    public MessageService getMessageService()
    {
        return wsServer.messageService;
    }

    public GroupService getGroupService()
    {
        return wsServer.groupService;
    }

    public UserService getUserService()
    {
        return wsServer.userService;
    }

    public JsonObject messageToJsonObject(Message message)
    {
        try
        {
            User sender = getUserService().getInfo(message.getSenderID());

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", 0);
            jsonObject.addProperty("messageID", message.getMessageID());
            jsonObject.addProperty("content", message.getContent());
            jsonObject.addProperty("sentTime", message.getSentTime());
            jsonObject.addProperty("senderID", sender.getUserID());
            jsonObject.addProperty("senderName", sender.getUsername());
            jsonObject.addProperty("avatar", sender.getAvatar());
            jsonObject.addProperty("senderName", sender.getUsername());

            return jsonObject;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new JsonObject();
    }

    public JsonObject groupMSGToJsonObject(GroupMSG groupMSG)
    {
        try
        {
            User sender = getUserService().getInfo(groupMSG.getSenderID());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", 1);
            jsonObject.addProperty("GM_ID", groupMSG.getGM_ID());
            jsonObject.addProperty("content", groupMSG.getContent());
            jsonObject.addProperty("sentTime", groupMSG.getTime());
            jsonObject.addProperty("senderID", sender.getUserID());
            jsonObject.addProperty("senderName", sender.getUsername());
            jsonObject.addProperty("avatar", sender.getAvatar());
            jsonObject.addProperty("senderName", sender.getUsername());
            jsonObject.addProperty("groupID", getMessageService().getGroupIDByGMSG(groupMSG.getGM_ID()));

            return jsonObject;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new JsonObject();
    }

}