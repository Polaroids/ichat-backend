package org.buaa.ichat.service.impl;

import org.buaa.ichat.service.AvatarService;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.mapper.UserMapper;
import org.buaa.ichat.service.UserService;
import org.buaa.ichat.tool.FTPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
public class AvatarImpl implements AvatarService{

    private static String baseImageUrl;
    @Value(value = "${ftp-centos.baseImageUrl}")
    public void setBaseImageUrl(String imageUrl) {
        baseImageUrl = imageUrl;
    }

    @Autowired
    UserService userService;

    //上传头像图片，返回图片url;如果用户已经有头像，则先删除原有头像
    public String uploadAvatar(Integer ID,String base64Image, boolean byUser) throws Exception{

        //在数据库中根据ID查找头像的url，存在则先将服务器中原头像删除
        String oldImageUrl = "";
        if(byUser==true){//上传的是用户头像
            //在数据库中根据ID查找原用户头像的url
            oldImageUrl = userService.getInfo(ID).getAvatar();
        }
        else {
            //在数据库中根据ID查找原来群头像的url
            oldImageUrl="";
        }

        String dataPrix = ""; //base64格式前头
        String data = "";//实体部分数据
        if(base64Image==null||"".equals(base64Image)){
            throw new Exception("上传失败，上传图片数据为空");
        }else {
            String [] d = base64Image.split("base64,");//将字符串分成数组

            if(d != null && d.length == 2){
                dataPrix = d[0];
                data = d[1];
            }else {
                System.out.println("888888");
                throw new Exception("上传失败，数据不合法");
            }
        }
        String suffix = "";//图片后缀
        if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){
            //data:image/jpeg;base64,base64编码的jpeg图片数据
            suffix = ".jpg";
        }
        else if("data:image/png;".equalsIgnoreCase(dataPrix)){
            //data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        }else {
            throw new Exception("上传失败，图片格式不合法");
        }
        //生成图片唯一识别码，添加后缀组成新图片名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String tempFileName=uuid+suffix;
        //base64解码
        Base64.Decoder decoder=Base64.getDecoder();
        decoder.decode(data);
        try {
            byte[] b = decoder.decode(data);
            for(int i=0;i<b.length;++i) {
                if(b[i]<0) {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            //上传头像至服务器
            FTPUtil.SftpChangeAvatar(b,tempFileName,oldImageUrl);

            //获得新头像的url，并在数据库中更新相应用户或群的属性
            String imgurl=baseImageUrl + "/"+tempFileName;
            if(byUser==true){
                userService.update(ID.toString(),null,null,null,imgurl,null,null);
            }
            else{

            }
            return imgurl;
        } catch (Exception e) {
            return "";
        }
    }

}
