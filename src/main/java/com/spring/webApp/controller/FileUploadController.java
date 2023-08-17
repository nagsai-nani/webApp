package com.spring.webApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.webApp.models.FileUploader;
import com.spring.webApp.response.FileUploadResponse;
import com.spring.webApp.service.FileUploadService;
@RestController
@RequestMapping("/user/file-upload")

public class FileUploadController {
	@Autowired
	FileUploadService service;
	@PostMapping("/upload")
	public ResponseEntity<FileUploader> uploadFile(@RequestParam ("file")MultipartFile mfile) throws Exception{
		return ResponseEntity.ok(service.save(mfile));
		
	}
	@GetMapping("/getfile/{fileName}")
	public ResponseEntity<Resource> getByName(@PathVariable String fileName){
		FileUploader fileUploader =service.getByName(fileName);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileUploader.getFileType())).
				header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+fileUploader.getFileName()).
				body(new ByteArrayResource(fileUploader.getFileData()));
		
	}
	
}
