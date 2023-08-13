package com.spring.webApp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.webApp.dao.UserDao;
import com.spring.webApp.models.User;
import com.spring.webApp.repository.UserRepository;
@Repository
public class UserDaoImpl implements UserDao {
		@Autowired
		UserRepository repo;
		
		@Autowired
		MongoTemplate temp;
		
	@Override
	public User save(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getBySearchString(String searchString) {
		Query query=new Query();
		
		query.addCriteria(new Criteria().orOperator
				(Criteria.where("name").regex(searchString,"i"),
				(Criteria.where("desc").regex(searchString,"i")),
				(Criteria.where("exp").regex(searchString,"i")),
				(Criteria.where("profile").regex(searchString,"i")),
				(Criteria.where("techs").regex(searchString,"i"))));
		return temp.find(query, User.class);
	}

}
