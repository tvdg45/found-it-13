package com.vv.detector.controller;

import com.vv.detector.utils.Command;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DetectorController {

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/detector")
    public void detector(@RequestParam("file") MultipartFile file) {
        Command.exec(file);
    }
}
