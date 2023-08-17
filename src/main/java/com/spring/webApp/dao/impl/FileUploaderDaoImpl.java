package com.spring.webApp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.webApp.dao.FileUploaderDao;
import com.spring.webApp.models.FileUploader;
import com.spring.webApp.repository.FileUploaderRepository;
@Repository
public class FileUploaderDaoImpl implements FileUploaderDao {
@Autowired
FileUploaderRepository
repo;
@Autowired
MongoTemplate temp;
	@Override
	public void save(FileUploader upload) {
		repo.save(upload);
	}
	@Override
	public FileUploader getByFileName(String fileName) {
		Query query =new Query();
		query.addCriteria(Criteria.where("fileName").is(fileName));
		
		return temp.findOne(query, FileUploader.class);
	}

}
