package com.skillstorm.mobile.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.mobile.models.Device;
import com.skillstorm.mobile.models.Plan;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.DeviceRepo;
import com.skillstorm.mobile.repository.PlanRepo;
import com.skillstorm.mobile.repository.UserRepo;

@Service
public class PlanService {
	
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private PlanRepo pr;
	
	@Autowired
	private DeviceRepo dr;
	
	public Plan addingPlanWithUser(Plan plan,int userID)        //Creating Plan with User 
	{
		Optional<User> optional=ur.findById(userID);
		User user=optional.get();
		Plan newPlan= pr.save(new Plan(plan.getPlanName(),plan.getCost(),user));
	    return newPlan;
	}
	//Experiment
	public Plan assignPlanToDevice(Plan plan,int userID, String deviceName)        //assigning plan to device
	{
		Optional<User> optional=ur.findById(userID); // Getting the USER obj
		User user=optional.get();
		List<Device> devices= user.getDevice(); // Getting all devices of that User
		for(Device i : devices)
		{
			if(i.getName().equals(deviceName))
			{
				Optional<Device> optional2=dr.findById(i.getId());
				Device userDevice=optional2.get();
			}
		}
		
		
		Plan newPlan= pr.save(new Plan(plan.getPlanName(),plan.getCost(),user,userDevice));
	    //return newPlan;
		return null;
	}
	
	

}
