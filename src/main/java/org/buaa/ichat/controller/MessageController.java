package org.buaa.ichat.controller;

import org.buaa.ichat.service.MessageService;
import org.buaa.ichat.tool.RetResponse;
import org.buaa.ichat.tool.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/message/"})
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping({"insertmsg"})
    public RetResult<Object> insertmsg(Integer userID, Integer receiverID, String content)
    {
        try
        {
            messageService.insertMSG(userID, content, receiverID);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @PostMapping({"insertgmsg"})
    public RetResult<Object> insertgmsg(Integer userID, Integer groupID, String content)
    {
        try
        {
            messageService.insertGMSG(userID, content, groupID);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @GetMapping(value = "chatlist")
    public RetResult<Object> getChatList()
    {
        try
        {
            return RetResponse.makeOKRsp(messageService.getChatList());
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @GetMapping(value = "history")
    public RetResult<Object> getHistory(Integer type, Integer ID, Integer msgID)
    {
        try
        {
            if(type == 0)
                return RetResponse.makeOKRsp(messageService.getHistoryMSG(ID, msgID));
            else if(type == 1)
                return RetResponse.makeOKRsp(messageService.getHistoryGMSG(ID, msgID));
            else
                return RetResponse.makeErrRsp("参数错误");
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @GetMapping(value = "message")
    public RetResult<Object> getMessageByID(Integer messageID)
    {
        try
        {
            return RetResponse.makeOKRsp(messageService.getMSGByID(messageID));
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @GetMapping(value = "groupmessage")
    public RetResult<Object> getGroupMSGByID(Integer GM_ID)
    {
        try
        {
            return RetResponse.makeOKRsp(messageService.getGMSGByID(GM_ID));
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @PostMapping({"readmsg"})
    public RetResult<Object> updateReadMSG(Integer userID)
    {
        try
        {
            messageService.updateNoSentMSG(userID);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @PostMapping({"readgmsg"})
    public RetResult<Object> updateReadGMSG(Integer groupID)
    {
        try
        {
            messageService.updateNoSentGMSG(groupID);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

}
