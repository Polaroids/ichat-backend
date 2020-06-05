package org.buaa.ichat.tool;


import com.jcraft.jsch.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.UUID;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;


@Component
public class FTPUtil {

    private static String host;
    @Value("${ftp-centos.host}")
    public  void setHost(String hostName){ host = hostName; }

    private static Integer port;
    @Value(value = "${ftp-centos.port}")
    public  void setPort(Integer portName) {
        port = portName;
    }

    private static String user;
    @Value(value = "${ftp-centos.user}")
    public  void setUser(String userName) {
        user = userName;
    }

    private static String password;
    @Value(value = "${ftp-centos.password}")
    public  void setPassword(String passwordName) {
        password = passwordName;
    }

    private static String baseFilePath;
    @Value(value = "${ftp-centos.baseFilePath}")
    public  void setBaseFilePath(String baseFilePath) {
        FTPUtil.baseFilePath = baseFilePath;
    }

    private static String baseImagePath;
    @Value(value = "${ftp-centos.baseImagePath}")
    public  void setBaseImagePath(String baseImagePath) {
        FTPUtil.baseImagePath = baseImagePath;
    }


    //上传文件至服务器不同的路径下
    public static void SftpPut(Integer groupID, byte[] bytes, String fileName) throws Exception {
        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        if (port<= 0) {
            //连接服务器，采用默认端口
            session = jsch.getSession(user, host);
        } else {
            //采用指定的端口连接服务器
            session = jsch.getSession(user,host, port);//session = jsch.getSession("root","212.64.78.189", 22);
        }
        //如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }
        session.setPassword(password);//设置登陆主机的密码
        session.setConfig("StrictHostKeyChecking", "no");//设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.connect(30000);//设置登陆超时时间

        OutputStream outstream = null;
        try {
            //创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            //进入服务器指定的文件夹
            sftp.cd(baseFilePath);//sftp.cd("/usr/local/nginx/files");
            //根据groupID指定对应文件夹，以便将文件存放在groupID的文件加下
            String dirName=groupID.toString();
            SftpATTRS attrs = null;
            try {
                //查找是否有这个文件夹，没有则catch抛出异常
                attrs = sftp.stat(dirName);
            } catch (Exception e) { }
            //抛出异常后,创建文件夹
            if(attrs==null){
                sftp.mkdir(dirName);
            }
            sftp.cd(dirName);
//            //列出服务器指定的文件列表
//            Vector v = sftp.ls("*");
//            for(int i=0;i<v.size();i++){
//                System.out.println(v.get(i));
//            }

            outstream = sftp.put(fileName);//实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
            outstream.write(bytes);



        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            //关流操作
            if (outstream != null) { outstream.flush();outstream.close(); }
            if (session != null) { session.disconnect(); }
            if (channel != null) { channel.disconnect(); }
        }
    }



    //删除旧的头像，更换新头像；如果oldImageUrl为空，直接更换头像
    public static void SftpChangeAvatar(byte[] bytes, String ImageName, String oldImageUrl) throws Exception {
        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        if (port<= 0) {
            session = jsch.getSession(user, host);
        } else {
            session = jsch.getSession(user,host, port);//session = jsch.getSession("root","212.64.78.189", 22);
        }
        if (session == null) {
            throw new Exception("session is null");
        }
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(30000);//设置登陆超时时间

        OutputStream outstream = null;
        try {
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            //进入服务器存储头像的文件夹
            sftp.cd(baseImagePath);//sftp.cd("/usr/local/nginx/images");
            //如果存在原头像路径，则删除对应的原头像图片
            if(oldImageUrl != null && oldImageUrl!=""){
                String[] folders = oldImageUrl.split("/");
                int num=folders.length-1;
                if(num==4){
                    String oldImageName=folders[num];
                    String oldRealUrl=baseImagePath+"/"+oldImageName;
                    try {
                        SftpATTRS attrs = sftp.stat(oldImageName);
                        if(attrs != null){
                            sftp.rm(oldRealUrl);
                        }
                    }catch (Exception e){}
                }
            }
            outstream = sftp.put(ImageName);
            outstream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关流操作
            if (outstream != null) { outstream.flush();outstream.close(); }
            if (session != null) { session.disconnect(); }
            if (channel != null) { channel.disconnect(); }
        }
    }


    //删除服务器中存储的头像
    public static void SftpDeleteAvatar(String targetFilePath) throws Exception {
        String fileName="";
        if(targetFilePath==null||targetFilePath==""){
            throw new Exception("filepath is empty!");
        }
        String[] folders = targetFilePath.split("/");
        int index=folders.length-1;//头像图片名称的索引
        fileName=folders[index];

        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        if (port<= 0) {
            session = jsch.getSession(user, host);
        } else {
            session = jsch.getSession(user,host, port);//session = jsch.getSession("root","212.64.78.189", 22);
        }
        if (session == null) {
            throw new Exception("session is null");
        }
        session.setPassword(password);//设置登陆主机的密码
        session.setConfig("StrictHostKeyChecking", "no");//设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.connect(30000);//设置登陆超时时间

        try {
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;

            sftp.cd(baseImagePath);
            String realurl=baseFilePath+"/"+fileName;
            System.out.println(realurl);

            try {
                SftpATTRS attrs = sftp.stat(fileName);
                if(attrs != null){
                    sftp.get(realurl);
                }
            }catch (Exception e){}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
    }

    //删除服务器中存储的文件
    public static void SftpDeleteFile(String targetFilePath) throws Exception {
        String fileName="";
        String groupIDdir="";
        if(targetFilePath==null||targetFilePath==""){
            throw new Exception("filepath is empty!");
        }
        String[] folders = targetFilePath.split("/");
        int index=folders.length-1;//文件名称的索引
        fileName=folders[index];
        groupIDdir=folders[index-1];

        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        if (port<= 0) {
            session = jsch.getSession(user, host);
        } else {
            session = jsch.getSession(user,host, port);//session = jsch.getSession("root","212.64.78.189", 22);
        }
        if (session == null) {
            throw new Exception("session is null");
        }
        session.setPassword(password);//设置登陆主机的密码
        session.setConfig("StrictHostKeyChecking", "no");//设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.connect(30000);//设置登陆超时时间
        try {
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;

            sftp.cd(baseFilePath);
            String realurl=baseFilePath + "/" + groupIDdir + "/" + fileName;
            System.out.println(realurl);

            try {
                sftp.cd(groupIDdir);
                SftpATTRS attrs = sftp.stat(fileName);
                if(attrs != null){
                    sftp.rm(realurl);
                }
            }catch (Exception e){}

        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            if (session != null) { session.disconnect(); }
            if (channel != null) { channel.disconnect(); }
        }
    }

    public static void SftpDownloadFile(String targetFilePath, HttpServletResponse response)throws Exception{
        String fileName="";
        String groupIDdir="";
        if(targetFilePath==null||targetFilePath==""){
            throw new Exception("filepath is empty!");
        }
        String[] folders = targetFilePath.split("/");
        int index=folders.length-1;//文件名称的索引
        fileName=folders[index];
        groupIDdir=folders[index-1];

        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        if (port<= 0) {
            session = jsch.getSession(user, host);
        } else {
            session = jsch.getSession(user,host, port);//session = jsch.getSession("root","212.64.78.189", 22);
        }
        if (session == null) {
            throw new Exception("session is null");
        }
        session.setPassword(password);//设置登陆主机的密码
        session.setConfig("StrictHostKeyChecking", "no");//设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.connect(30000);//设置登陆超时时间

//        String dst = "D:\\IntellijProject\\localfile" + "\\" + fileName;
//        OutputStream out = new FileOutputStream(dst);

        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        OutputStream out=response.getOutputStream();

        try {
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            sftp.cd(baseFilePath);
            String realurl=baseFilePath + "/" + groupIDdir + "/" + fileName;
            System.out.println(realurl);
            try {
                sftp.cd(groupIDdir);
                SftpATTRS attrs = sftp.stat(fileName);
                if(attrs != null){
                    sftp.get(fileName,out);
                }
            }catch (Exception e){}

        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            if (out != null) { out.flush();out.close();}
            if (session != null) { session.disconnect(); }
            if (channel != null) { channel.disconnect(); }
        }
    }


}

