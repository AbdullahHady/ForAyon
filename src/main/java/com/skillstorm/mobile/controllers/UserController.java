package com.skillstorm.mobile.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.mobile.Service.UserService;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.UserRepo;
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private UserService us;

	@GetMapping(value="/user")            //showing all user info to a User
	public User showUserInfo()
	{
		int num=1;
		System.out.println("The input is "+num);
		User user=  us.findUser(num);
	    return user;
		
		
	}

	@PutMapping()                          //updating User info
	public ResponseEntity<User> updateUser(@RequestBody @Valid User user)
	{
		User body= us.updateUserInfo(user);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
		
	}
	
	
	

	
	
	
	
	
	

}
