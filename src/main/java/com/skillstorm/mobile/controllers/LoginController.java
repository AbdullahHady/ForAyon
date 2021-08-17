package com.skillstorm.mobile.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.mobile.Service.LoginService;
import com.skillstorm.mobile.Service.UserService;
import com.skillstorm.mobile.models.Device;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.UserRepo;

@RestController
@RequestMapping("/index")
public class LoginController {
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private LoginService ls;
	
	
	@PostMapping("/register")                          //Adding User
	public ResponseEntity<User> insertUser(@RequestBody @Valid User user)
	{
		User body= ls.saveUser(user);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> LoginMethod(@RequestBody @Valid User user)
	{
		System.out.println("From controller");
		boolean flag=ls.checkUser(user);
		if(flag==true)
		{
			System.out.println("Sucessfull logged in");
			return new ResponseEntity<>(user, HttpStatus.CREATED);
			
		}
		else
		{
			System.out.println("Invalid credential");
			return null;
		}
		
	}
	
	

		
	

}
