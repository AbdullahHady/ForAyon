package com.skillstorm.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.mobile.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	//public User findByName();

}
