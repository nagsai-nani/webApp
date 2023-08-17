package com.spring.webApp.models;

public class FileUploader {

	private String fileName;
	private String fileType;
	private byte[] fileData;
	private String uriPath;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getUriPath() {
		return uriPath;
	}
	public void setUriPath(String uriPath) {
		this.uriPath = uriPath;
	}
	
}
