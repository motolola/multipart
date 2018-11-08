package com.motolola.upload_file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Akinjide Motolola.
 * email: motolola@icloud.com
 */
@Controller
public class UploadController {

    public final static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

    @GetMapping("/")
    public String upload(Model model)
    {
        return "uploadview";
    }
    @PostMapping("/upload")
    public String upload(Model model, @RequestParam("files")MultipartFile[] files)
    {
        StringBuilder fileNames = new StringBuilder();
        for(MultipartFile file : files){
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("msg", "File uploaded succesfully "+fileNames.toString());
        return "uploadedstatusview";
    }

}
