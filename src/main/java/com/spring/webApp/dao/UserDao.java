package com.spring.webApp.dao;

import java.util.List;

import com.spring.webApp.models.User;

public interface UserDao {

	User save(User user);

	List<User> getBySearchString(String searchString);

}
