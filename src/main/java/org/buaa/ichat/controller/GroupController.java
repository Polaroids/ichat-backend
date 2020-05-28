package org.buaa.ichat.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.buaa.ichat.service.GroupService;
import org.buaa.ichat.tool.RetResponse;
import org.buaa.ichat.tool.RetResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group/")
public class GroupController {

    private final Logger log = LoggerFactory.getLogger(GroupController.class);
    @Autowired
    GroupService groupService;
    @PostMapping({"create"})
    public RetResult<Object> create(String name, String des, String avatar, String[] members){

        if (name == null || name.equals(""))
            return RetResponse.makeErrRsp("群名不可为空");
        Subject subject = SecurityUtils.getSubject();
        Integer userID = new Integer ((String)subject.getPrincipal());
        try {
            groupService.create(userID,name,des,avatar,members);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @PostMapping({"invite"})
    public RetResult<Object> invite(Integer ID,Integer groupID){
        if (ID == null || groupID == null)
            return RetResponse.makeErrRsp("参数不可为空");
        try {
            groupService.invite(getUserID(),groupID,ID);
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
        finally {
            return RetResponse.makeOKRsp();
        }
    }
    @PostMapping({"quit"})
    public RetResult<Object> quit(Integer groupID){
        if(groupID == null)
            return RetResponse.makeErrRsp("groupID不可为空");
        try {
            groupService.quit(getUserID(),groupID);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    private Integer getUserID(){
        Subject subject = SecurityUtils.getSubject();
        return new Integer ((String)subject.getPrincipal());
    }

}
