package org.buaa.ichat.service;

import org.apache.shiro.authc.AuthenticationException;
import org.buaa.ichat.entity.User;

public interface UserService {
    public boolean login(Integer userID,String password)throws AuthenticationException;

    public Integer register(String userName, String password, String email)throws Exception;

    public User getInfo(Integer userID)throws Exception;
}
