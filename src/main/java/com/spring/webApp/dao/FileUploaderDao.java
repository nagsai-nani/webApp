package com.spring.webApp.dao;

import com.spring.webApp.models.FileUploader;

public interface FileUploaderDao {

	void save(FileUploader upload);

	FileUploader getByFileName(String fileName);
}
