package com.spring.webApp.service;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.webApp.dao.FileUploaderDao;
import com.spring.webApp.models.FileUploader;
import com.spring.webApp.response.FileUploadResponse;

@Service
public class FileUploadService {
	@Autowired
	FileUploaderDao fileUploadDao;

	public FileUploader save(MultipartFile mfile) throws Exception {
		FileUploader upload = new FileUploader();
		boolean isPdf = false;
		String extension = getFileExtension(mfile.getOriginalFilename().replace(" ", ""));
		isPdf = ".pdf".equalsIgnoreCase(extension) ? true : false;
		FileUploader fileUploaded = fileUploadDao.getByFileName(upload.getFileName());
		if (fileUploaded != null) {
			throw new Exception("Duplicate records not allowed");
		}
		if (!isPdf) {
			throw new Exception("Please provide pdf file");
		}

		try {
			upload.setFileData(mfile.getBytes());
			upload.setFileName(mfile.getOriginalFilename());
			upload.setFileType(mfile.getContentType());
			fileUploadDao.save(upload);
			String downloadurl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/file-upload/getfile/")
					.path(upload.getFileName()).toUriString();
			upload.setUriPath(downloadurl);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return upload;
	}

	private String getFileExtension(String fileName) {
		String extension = "";
		if (fileName != null) {
			extension = fileName.substring(fileName.lastIndexOf("."));
		}
		return extension;

	}

	 public FileUploadResponse getByNames(String fileName) {
	  FileUploader fileUpload= fileUploadDao.getByFileName(fileName);
	  BufferedOutputStream bout=null; ByteArrayOutputStream bytout=null;
	  FileUploadResponse resp=new FileUploadResponse();
	  resp.setFileType(fileUpload.getFileType()); byte[]
	 data=fileUpload.getFileData(); String path="C:\\Users\\harry\\Desktop";
	  String fileNAme="hashwin"; try { File file =new File(path,fileNAme);
	  file.createNewFile();
	  ByteArrayResource resk=null;
	  resk=new ByteArrayResource(data, fileNAme);
	  file.getAbsoluteFile(); bout=new BufferedOutputStream(new
	  FileOutputStream(file)); bytout=new ByteArrayOutputStream();
	 bout.write(data);
	 bytout.write(data);
	  System.out.println("NAGSAI___________________7025"); bout.flush();
	  bout.close(); } catch (IOException e) { e.getMessage(); }
	  
	  
	  resp.setFileData(data); return resp; }
	 
	public FileUploader getByName(String fileName) {
		FileUploader fu = fileUploadDao.getByFileName(fileName);
		fu.getUriPath();
		return fu;
	}

}
