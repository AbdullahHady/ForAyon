package com.skillstorm.mobile.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.mobile.models.Device;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.DeviceRepo;
import com.skillstorm.mobile.repository.UserRepo;

@Service
public class LoginService {
	
	@Autowired
	private UserRepo ur;
	
	
	public User saveUser(User user)
	{
        User body= ur.save(user);
		return body;
		
	}
    

	public boolean checkUser(User user)
	{
		String userName=user.getUserName();
		String password=user.getPassword();
		//System.out.println(userName+" "+password);
		
		List<User> users= ur.findAll();
		boolean flag=false;
		//System.out.println(users);
		for(User i : users)
		{
			
			if(i.getUserName().equals(userName) && i.getPassword().equals(password))
			{
				 flag=true;
				 
			}
		
		}
		
		return flag;
		
	
		
	}
	
	

}
