package com.spring.webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.webApp.models.User;
import com.spring.webApp.response.UserResponse;
import com.spring.webApp.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/rest/user")
public class UserController {
	@Autowired
	UserService service;
	@ApiIgnore
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return ResponseEntity.ok(service.save(user));
	}
	
	@GetMapping("/get/{searchString}")
	public ResponseEntity<List<UserResponse>> getBySearch(@PathVariable String searchString) throws Exception{
		return ResponseEntity.ok(service.getBySearchString(searchString));
		
	}
	
}
