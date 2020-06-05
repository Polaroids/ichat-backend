package org.buaa.ichat.service;

public interface AvatarService {
    //byUser判断上传的是用户头像还是群头像
    public String uploadAvatar(Integer ID, String base64Image, boolean byUser) throws Exception;
}
