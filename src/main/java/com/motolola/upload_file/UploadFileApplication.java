package com.motolola.upload_file;

import com.motolola.upload_file.controller.UploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class UploadFileApplication {

	public static void main(String[] args) {

			 if(new File(UploadController.uploadDirectory).mkdir()){
				 System.out.println("Directory created");
			 }

		//just before the file is stored ...
		SpringApplication.run(UploadFileApplication.class, args);
	}
}
