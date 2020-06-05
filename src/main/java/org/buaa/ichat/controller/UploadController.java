package org.buaa.ichat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @PostMapping("/upload")
    @ResponseBody
    public String upload(){
        return "shangchuan";
    }
//    public String upload(@RequestParam("file")MultipartFile file){
//        return "shangchuan";
//    }
}
