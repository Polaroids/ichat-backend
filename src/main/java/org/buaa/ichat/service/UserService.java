package org.buaa.ichat.service;

import org.apache.shiro.authc.AuthenticationException;
import org.buaa.ichat.entity.User;

import java.util.List;

public interface UserService {
    public boolean login(Integer userID,String password)throws AuthenticationException;

    public Integer register(String userName, String password, String email)throws Exception;

    public User getInfo(Integer userID)throws Exception;

    public void update(String ID,String info, String username, String password, String avatar, Integer sex,Integer age)throws Exception;

    public List<User> searchByName(String userName)throws Exception;
}
