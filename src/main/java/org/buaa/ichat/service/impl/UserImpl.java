package org.buaa.ichat.service.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.mapper.UserMapper;
import org.buaa.ichat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    public void update(String ID,String info, String username, String password, String avatar, Integer sex, Integer age) throws Exception {
        User.UpdateBuilder updateBuilder = User.UpdateBuild();
        updateBuilder
                .set(
                    User.Build()
                        .username(username)
                        .password(password)
                        .info(info)
                        .age(age)
                        .avatar(avatar)
                        .sex(sex)
                            .build())
                .where(User.ConditionBuild().UserIDList(new Integer(ID)).build());
        userMapper.update(updateBuilder.build());
    }

    @Override
    public List<User> searchByName(String userName) throws Exception {
        if (userName==null || userName.equals(""))
            throw new Exception("用户名不可为空");
        return userMapper.queryUser(User.QueryBuild().fuzzyUsername(userName).build());
    }



}
