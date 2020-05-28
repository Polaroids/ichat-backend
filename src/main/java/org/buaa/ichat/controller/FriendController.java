package org.buaa.ichat.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.buaa.ichat.service.FriendService;
import org.buaa.ichat.tool.RetResponse;
import org.buaa.ichat.tool.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/friend/"})
public class FriendController {
    @Autowired
    FriendService  friendService;

    @PostMapping(value = "add")
    public RetResult<Object> add(Integer ID){
        try {
            Subject subject = SecurityUtils.getSubject();
            Integer userID = new Integer ((String)subject.getPrincipal());
            friendService.add(userID,ID);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @PostMapping(value = "deal")
    public RetResult<Object> deal(Integer relationID,Boolean ans){
        if (ans == null || relationID == null)
            return  RetResponse.makeErrRsp("参数错误");
        try {
            friendService.deal(relationID,ans);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @GetMapping(value = "getFriends")
    public RetResult<Object> getFriends(){
        Subject subject = SecurityUtils.getSubject();
        Integer userID = new Integer ((String)subject.getPrincipal());
        return RetResponse.makeOKRsp( friendService.getFriends(userID));
    }

    @GetMapping(value = "getRelations")
    public RetResult<Object> getRelations(){
        Subject subject = SecurityUtils.getSubject();
        Integer userID = new Integer ((String)subject.getPrincipal());
        return RetResponse.makeOKRsp( friendService.getRelations(userID));
    }

}
