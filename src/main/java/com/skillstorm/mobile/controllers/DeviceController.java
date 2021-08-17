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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.mobile.Service.DeviceService;
import com.skillstorm.mobile.Service.UserService;
import com.skillstorm.mobile.models.Device;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.DeviceRepo;
import com.skillstorm.mobile.repository.UserRepo;

@RestController
@RequestMapping("/devices")
public class DeviceController {
	@Autowired
	private DeviceRepo dr;
	
	@Autowired
	private DeviceService ds;
	
	@GetMapping()                             //Showing All available devices
	public List<Device> showAllDevices()
	{
		List<Device> devices=ds.fetchDevices();
		return devices;
		
	} 
	
	@PostMapping()                            //Adding device
	public ResponseEntity<Device> saveDevice(@RequestBody @Valid Device device)
	{
		Device body= ds.saveDevice(device);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/device")                   //User Adding device (Not Finished)
	public ResponseEntity<Device> createDeviceWithUser(@RequestBody @Valid Device device)
	{
		System.out.println("From controller");
		int userID=2;
		String userName="hasanAlif088";
		Device body=ds.addingDeviceWithUser(userID);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	/*
	@PostMapping("/plan")
	public ResponseEntity<Device> UserAddingPlanToDevice(@RequestBody @Valid Device device)
	{
		System.out.println("From controller");
		int userID=2;
		String userName="hasanAlif088";
		Device body=ds.addingDeviceWithUser(userID);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
     */

	@DeleteMapping ()                              //User Deleting device
	public ResponseEntity<Void> deleteDevice()
	{
		User user=new User();
		
		int id=2;
		String deviceName="Nokia x6";
		//deviceRepository.deleteById(id);
		//Device device=ds.deleteDevice(id, deviceName);
		ds.removeDevice(id,deviceName);
		//dr.deleteByIdAndName(id, deviceName);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
