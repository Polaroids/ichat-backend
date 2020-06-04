package org.buaa.ichat.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.buaa.ichat.service.UserService;
import org.buaa.ichat.tool.RetResponse;
import org.buaa.ichat.tool.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"/api/user/"})
public class UserController {
    @Autowired
    private UserService userService;
    //@Value("${serviceUrl}")
    //String url;
    @PostMapping({"login"})
    public RetResult<Object> login(String userID, String password){
        if (userID==null||password==null)
            return RetResponse.makeErrRsp("用户名或密码不可为空");
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(userID, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return RetResponse.makeErrRsp("未知账户");
        } catch (IncorrectCredentialsException ice) {
            return RetResponse.makeErrRsp("密码不正确");
        } catch (LockedAccountException lae) {
            return RetResponse.makeErrRsp("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return RetResponse.makeErrRsp("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return RetResponse.makeErrRsp(ae.getMessage());
        }
        if (subject.isAuthenticated()) {
            return RetResponse.makeOKRsp();
        } else {
            token.clear();
            return RetResponse.makeErrRsp("登录失败");
        }
    }

    @PostMapping({"register"})
    public RetResult<Object> register(String userName, String password, String email){
        if (userName==null||userName.equals("")||password==null||password.equals("")||email==null||email.equals(""))
            return RetResponse.makeErrRsp("用户名或密码或email不可为空");
        try {
            return RetResponse.makeOKRsp((userService.register(userName, password, email)));
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @GetMapping(value = "/info")
    public RetResult<Object> person(Integer ID){
        Integer userID = getUserID();
        try {
            if (ID != null)
                userID = ID;
            return RetResponse.makeOKRsp(userService.getInfo(userID));
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @PostMapping({"update"})
    public RetResult<Object> update(String info, String username, String password, String avatar, Integer sex,Integer age){

        try {
            userService.update(getUserID().toString(),info,username,password,avatar,sex,age);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    public Integer getUserID(){
        Subject subject = SecurityUtils.getSubject();
        return new Integer ((String)subject.getPrincipal());
    }
    @PostMapping({"searchUsers"})
    public RetResult<Object> search(String userName,Integer userID){
        try {
            if (userID != null)
                return RetResponse.makeOKRsp(userService.getInfo(userID));
            return RetResponse.makeOKRsp(userService.searchByName(userName));
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
}