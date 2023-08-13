package com.spring.webApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.webApp.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
