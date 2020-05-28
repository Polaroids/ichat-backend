package org.buaa.ichat.service;

import java.util.List;

public interface GroupService {
    public void create(Integer userID, String name, String des, String avatar, String[] members)throws Exception;
    public void invite(Integer userID,Integer groupID,Integer friendID)throws Exception;
    public void quit(Integer userID,Integer groupID)throws Exception;
    public boolean isManager(Integer userID,Integer groupID);
}
