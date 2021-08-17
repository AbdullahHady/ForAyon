package com.skillstorm.mobile.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.UserRepo;
@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;

	
	public User findUser(int id)
	{
		Optional<User> optional=ur.findById(id);
		User tempUser=optional.get();
		System.out.println(tempUser);
		return tempUser;

	}
	

	
	public User updateUserInfo(User user)
	{
		String userName= user.getUserName();
		List<User> users= ur.findAll();
		int userID=0;
		
		for(User i : users)
		{
			
			if(i.getUserName().equals(userName))
			{
				userID=i.getId();
			}
		
		}
		
		System.out.println(userID);
		User updatedUser=new User(userID,user.getUserName(),user.getPassword(),user.getEmail(),user.getHomeAddress());
		return ur.save(updatedUser);
		
	}

}
