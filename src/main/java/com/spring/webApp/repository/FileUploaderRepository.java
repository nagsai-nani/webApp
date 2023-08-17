package com.spring.webApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.webApp.models.FileUploader;

public interface FileUploaderRepository extends MongoRepository<FileUploader, String> {

}
