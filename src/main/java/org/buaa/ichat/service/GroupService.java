package org.buaa.ichat.service;

import org.buaa.ichat.entity.Group;
import org.buaa.ichat.entity.User;

import java.util.List;

public interface GroupService {
    public int create(Integer userID, String name, String des, String avatar, String[] members)throws Exception;
    public void invite(Integer userID,Integer groupID,Integer[] friendID)throws Exception;
    public void quit(Integer userID,Integer groupID)throws Exception;
    public boolean isManager(Integer userID,Integer groupID);
    public List<Group> getGroups(Integer userID);
    public List<User> getMembers(Integer groupID)throws Exception;
}
