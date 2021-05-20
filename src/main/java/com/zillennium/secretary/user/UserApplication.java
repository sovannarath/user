package com.zillennium.secretary.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zillennium.secretary.user.services.UploadService.FilesStorageService;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class UserApplication implements CommandLineRunner{
	
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception {
	   storageService.deleteAll();
	   storageService.init();
	}

}
