package com.skillstorm.mobile.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillstorm.mobile.models.Device;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.DeviceRepo;
import com.skillstorm.mobile.repository.PlanRepo;
import com.skillstorm.mobile.repository.UserRepo;
import com.skillstorm.mobile.models.Plan;

@SpringBootTest
class MyMobileAppApplicationTests {
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private DeviceRepo dr;
	
	@Autowired
	private PlanRepo pr;
	

	@Test
	void contextLoads()
	{
		
		//User user = ur.save(new User("SalmanRayen", "Chelsea","salmanRayen064@gmail.com","125 67 Shaua st"));
		//Device device = dr.save(new Device("Nokia 1100",700.00,new User(1,"hasanalif074@gmail.com","106 67 Waltham st","barca","alifHasan")));
		//Device device = dr.save(new Device("Samsang Galaxy 7",550.00,new User(4,"bishu45@gmail.com","108 Rogers Blvd","ki732a0","bishuTheman")));
		//Device device2 = dr.save(new Device("IPhone 7",600.00,new User(4,"bishu45@gmail.com","108 Rogers Blvd","ki732a0","bishuTheman")));
		//System.out.println(device);
		//Device device=dr.save(new Device(null, null, null))
		
		
		//Plan plan= pr.save(new Plan("Unlimited Starter", 35.00, new User(1,"SalmanRayen", "Chelsea","salmanRayen064@gmail.com","125 41 Liverpool st")));
	}

}
