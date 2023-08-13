package com.spring.webApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.webApp.dao.UserDao;
import com.spring.webApp.models.User;
import com.spring.webApp.response.UserResponse;
 @Component
public class UserService {
@Autowired 
UserDao dao;
	public User save(User user) {
		return	dao.save(user);		
	}
	public List<UserResponse> getBySearchString(String searchString) throws Exception {
		
		List<User> users=dao.getBySearchString(searchString);
		if(users==null||users.equals(null)||users.isEmpty()) {
throw new Exception("Request String not found "+searchString);			
		}
		List<UserResponse> response =new ArrayList<UserResponse>();
		UserResponse resp=null;
		for (User user : users) {
			resp=new UserResponse();
			resp.setDesc(user.getDesc());
			resp.setExp(user.getExp());
			resp.setName(user.getName());
			resp.setProfile(user.getProfile());
			resp.setTechs(user.getTechs());
			response.add(resp);
		}
		return response;
		
	}

}
