package com.vv.detector.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            if(file.getContentType().contains("image")) {
                try {
                    String temp = "images" + File.separator + "upload" + File.separator;
                    //String fileName = file.getOriginalFilename();
                    //String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    String newFileName = file.getOriginalFilename();
                    String filePath = "/Users/apple/MyFiles/darknet/upload";
                    File dest = new File(filePath +"/"+ newFileName);
                    System.out.println(dest.getParentFile());
                    if(!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdirs();
                    }
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
