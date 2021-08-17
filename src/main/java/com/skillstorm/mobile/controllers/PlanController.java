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

import com.skillstorm.mobile.Service.PlanService;
import com.skillstorm.mobile.models.Device;
import com.skillstorm.mobile.models.Plan;
import com.skillstorm.mobile.repository.PlanRepo;

@RestController
@RequestMapping("/plans")
public class PlanController {
	
	@Autowired
	private PlanRepo pr;
	
	@Autowired
	private PlanService ps;
	
	@GetMapping                 //Showing All Plans
	public List<Plan> AllPlans()
	{
		List<Plan> plans=pr.findAll();
		return plans;
		
	}
	@PostMapping()                   //User Adding plan   .
	public ResponseEntity<Plan> createPlanWithUser(@RequestBody @Valid Plan plan)
	{
		int userID=2;
		Plan body=ps.addingPlanWithUser(plan,userID);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	//Experiment 
	@PostMapping("/plan")                   //User Adding plan with device  /// Device Add kora ase , ekhon plan assign korbe.
	public ResponseEntity<Plan> createPlanWithUserAndDevice(@RequestBody @Valid Plan plan)
	{
		int userID=2;
		String deviceName="I phone 4";
		Plan body=ps.assignPlanToDevice(plan,userID,deviceName);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	

}
