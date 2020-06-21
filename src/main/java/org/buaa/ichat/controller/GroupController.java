package org.buaa.ichat.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.buaa.ichat.entity.GroupFile;
import org.buaa.ichat.service.GroupFileService;
import org.buaa.ichat.service.GroupService;
import org.buaa.ichat.tool.FTPUtil;
import org.buaa.ichat.tool.RetResponse;
import org.buaa.ichat.tool.RetResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/group/")
public class GroupController {

    private static String baseFileUrl;
    @Value(value = "${ftp-centos.baseFileUrl}")
    public void setBaseImageFileUrl(String fileUrl) { baseFileUrl = fileUrl; }

    private final Logger log = LoggerFactory.getLogger(GroupController.class);
    @Autowired
    GroupService groupService;
    @Autowired
    GroupFileService groupFileService;
    @PostMapping({"create"})
    public RetResult<Object> create(String name, String des, String avatar, String[] members){

        if (name == null || name.equals(""))
            return RetResponse.makeErrRsp("群名不可为空");
        Subject subject = SecurityUtils.getSubject();
        Integer userID = new Integer ((String)subject.getPrincipal());
        try {
            int groupID = groupService.create(userID,name,des,avatar,members);
            return RetResponse.makeOKRsp(groupID);
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @PostMapping({"invite"})
    public RetResult<Object> invite(Integer groupID,Integer[] ID){
        if (ID == null || groupID == null)
            return RetResponse.makeErrRsp("参数不可为空");
        try {
            groupService.invite(getUserID(),groupID,ID);
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
        finally {
            return RetResponse.makeOKRsp();
        }
    }
    @PostMapping({"quit"})
    public RetResult<Object> quit(Integer groupID){
        if(groupID == null)
            return RetResponse.makeErrRsp("groupID不可为空");
        try {
            groupService.quit(getUserID(),groupID);
            return RetResponse.makeOKRsp();
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @GetMapping({"getMembers"})
    public RetResult<Object> getMembers(Integer groupID){
        try {
            return RetResponse.makeOKRsp(groupService.getMembers(groupID));
        }catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @GetMapping({"getGroups"})
    public RetResult<Object> getGroupds(){
        try {
            return RetResponse.makeOKRsp(groupService.getGroups(getUserID()));
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @GetMapping({"getFiles"})
    public RetResult<Object> getFiles(Integer groupID){
        try {
            return RetResponse.makeOKRsp( groupFileService.getFiles(groupID));
        }
        catch (Exception e){
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }
    @PostMapping({"uploadFile"})
    public RetResult<Object> upload(Integer groupID, MultipartFile file){
        List<GroupFile> fileList = null;
        //操作数据库接口
        //groupFileService.upload();
        Integer userID = getUserID();
        String newFileUrl = "";
        String newFilename;
        try {
            byte[] bytes = file.getBytes();
            fileList = groupFileService.getFiles(groupID);
            for(GroupFile file1:fileList){
                if(file1.getFileName().equals(file.getOriginalFilename())){
                    return RetResponse.makeErrRsp("Filename already exists!");
                }
            }

            newFileUrl=baseFileUrl + "/" + groupID + "/" + file.getOriginalFilename();
            groupFileService.upload(file.getOriginalFilename(), newFileUrl, groupID, userID);

            FTPUtil.SftpPut(groupID, bytes, file.getOriginalFilename());
            return RetResponse.makeOKRsp("upload success!");

        } catch (Exception e) {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }

    @PostMapping(value = "searchFile")
    public RetResult<Object> searchFile(Integer groupID, Integer fileID) {
        GroupFile targetFile = null;
        String fileUrl = null;
        int num = 0;
        try {
            targetFile = groupFileService.queryFile(fileID);
            if(targetFile == null)
                return RetResponse.makeErrRsp("The file does not exist!");
            if(!groupID.equals(targetFile.getUploadGroupID()))
                return RetResponse.makeErrRsp("The file is not in this group!");
            return RetResponse.makeOKRsp(targetFile);
        } catch (Exception e) {
            return RetResponse.makeErrRsp(e.getMessage());
        }

    }

    @PostMapping(value = "downloadFile")
    public RetResult<Object> downloadFile(Integer groupID, Integer fileID, HttpServletResponse response) {
        GroupFile targetFile = null;
        String fileUrl="";
        try {
            targetFile = groupFileService.queryFile(fileID);
            if(targetFile == null)
                return RetResponse.makeErrRsp("The file does not exist!");
            if(!groupID.equals(targetFile.getUploadGroupID()))
                return RetResponse.makeErrRsp("The file is not in this group!");
            fileUrl = targetFile.getFileUrl();
//            fileUrl = "http://212.64.78.189:8601/files/11/test2.rar";
//            System.out.println("y:" + fileUrl);
            FTPUtil.SftpDownloadFile(fileUrl,response);
            return RetResponse.makeOKRsp("download success!");
        } catch (Exception e) {
            return RetResponse.makeErrRsp(e.getMessage());
        }

    }

    @PostMapping({"deleteFile"})
    public RetResult<Object> delete(Integer groupID, Integer fileID){
        GroupFile targetFile = null;
        String fileUrl="";
        try {
            targetFile = groupFileService.queryFile(fileID);
            if(targetFile == null)
                return RetResponse.makeErrRsp("The file does not exist!");
            if(!groupID.equals(targetFile.getUploadGroupID()))
                return RetResponse.makeErrRsp("The file is not in this group!");
            if(!getUserID().equals(targetFile.getUploadUserID()))
                return RetResponse.makeErrRsp("You are not the uploader so that you cannot delete this file!");

            fileUrl = groupFileService.queryFile(fileID).getFileUrl();
            groupFileService.deleteFile(fileID);
            FTPUtil.SftpDeleteFile(fileUrl);
            return RetResponse.makeOKRsp("delete success!");
        }
        catch (Exception e)
        {
            return RetResponse.makeErrRsp(e.getMessage());
        }
    }


    private Integer getUserID(){
        Subject subject = SecurityUtils.getSubject();
        return new Integer ((String)subject.getPrincipal());
    }
}
