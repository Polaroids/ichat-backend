package org.buaa.ichat.service;

import org.buaa.ichat.entity.GroupFile;

import java.util.List;

public interface GroupFileService {
    public void upload(String fileName,String fileUrl,Integer groupID,Integer userID)throws Exception;
    public List<GroupFile> getFiles(Integer groupID)throws Exception;
    public void deleteFile(Integer fileID)throws Exception;
    public GroupFile queryFile(Integer fileID)throws Exception;
}
