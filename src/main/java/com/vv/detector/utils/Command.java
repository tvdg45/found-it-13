package com.vv.detector.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class Command {
    public static void exec(MultipartFile file) {
        String shell = "/Users/apple/WebApps/ObjectDetector/desh.sh";   //程序路径
        String permit = "chmod 777 " + shell;

        try {
            File shFile = new File(shell);
            PrintStream ps = new PrintStream(new FileOutputStream(shFile));
            ps.println("#!/bin/sh");
            ps.append("cd /Users/apple/MyFiles/darknet;");
            ps.append("./darknet detect cfg/yolov3.cfg yolov3.weights " + "/Users/apple/MyFiles/darknet/upload/"+file.getOriginalFilename());
            ps.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Runtime.getRuntime().exec(permit).waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Runtime.getRuntime().exec(shell).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
