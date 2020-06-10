package org.buaa.ichat.service.impl;

import org.buaa.ichat.entity.GroupFile;
import org.buaa.ichat.mapper.GroupFileMapper;
import org.buaa.ichat.service.GroupFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GroupFileImpl implements GroupFileService {
    @Autowired
    GroupFileMapper groupFileMapper;


    @Override
    public List<GroupFile> getFiles(Integer groupID) throws Exception {
        if (groupID == null)
            throw new Exception("参数缺失");
        return groupFileMapper.queryGroupFile(GroupFile.QueryBuild().uploadGroupID(groupID));
    }

    @Override
    public void upload(String fileName, String fileUrl, Integer groupID, Integer userID) throws Exception {
        if (fileName == null || fileName.equals(""))
            throw new Exception("文件名不可为空");
        if (fileUrl == null || fileUrl.equals(""))
            throw new Exception("fileurl不可为空");
        if (groupID== null|| userID==null)
            throw new Exception("参数缺失");
        groupFileMapper
                .insertGroupFile(
                        GroupFile.Build()
                                .fileName(fileName)
                                .fileUrl(fileUrl)
                                .uploadTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                                .uploadGroupID(groupID)
                                .uploadUserID(userID)
                                .build());
    }

    @Override
    public void deleteFile(Integer fileID) throws Exception {
        if (fileID == null)
            throw new Exception("参数缺失");
        if(null== groupFileMapper.queryGroupFileLimit1(GroupFile.QueryBuild().fileID(fileID).build()))
            throw new Exception("文件不存在");
        //这里需要删除实体文件的逻辑
        groupFileMapper.delete(fileID);
    }

    @Override
    public GroupFile queryFile(Integer fileID) throws Exception {
        GroupFile con = GroupFile.QueryBuild().fileID(fileID).build();
        GroupFile ans = groupFileMapper.queryGroupFileLimit1(con);

        if (fileID == null)
            throw new Exception("参数缺失");
        if(ans == null)
            throw  new Exception("不存在该文件");
        return ans;
//        return groupFileMapper.queryGroupFileLimit1(GroupFile.QueryBuild().fileID(fileID).build());
    }

}
