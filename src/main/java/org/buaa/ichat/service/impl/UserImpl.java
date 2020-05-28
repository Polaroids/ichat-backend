package org.buaa.ichat.service.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.mapper.UserMapper;
import org.buaa.ichat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean login(Integer userID, String password) throws AuthenticationException {
        if (userID==null||password==null||password.equals(""))
            throw new AuthenticationException("用户名或密码不可为空");
        User con = User.QueryBuild().UserID(userID).password(password);
        if (userMapper.queryUserLimit1(con) == null)
            throw new AuthenticationException("用户名或密码错误");
        return true;
    }

    @Override
    public Integer register(String username, String password, String email) throws Exception {
        User u = new User();
        u.setUsername(username);
        if (userMapper.queryUserLimit1(User.QueryBuild().email(email)) != null)
            throw new Exception("email已被注册");
        u.setPassword(password);
        u.setEmail(email);
        u.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userMapper.insertUser(u);
        return u.getUserID();
    }

    @Override
    public User getInfo(Integer userID) throws Exception {
        User con = User.QueryBuild().UserID(userID).build();
        User ans =  userMapper.queryUserLimit1(con);
        if (ans == null)
            throw new Exception("不存在的用户");
        return ans;
    }
}
