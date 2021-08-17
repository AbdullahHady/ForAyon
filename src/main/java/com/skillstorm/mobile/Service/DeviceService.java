package com.skillstorm.mobile.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.mobile.models.Device;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.DeviceRepo;
import com.skillstorm.mobile.repository.UserRepo;


@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepo dr;
	@Autowired
	private UserRepo ur;
	
	public List<Device> fetchDevices()                   //Fetching All devices
	{
		List<Device> devices= dr.findAll();
		return devices;
	}
	
	public Device saveDevice(Device device)             //Creating device without user
	{
		Device body= dr.save(device);
		return body;
		
	}
	
	public Device addingDeviceWithUser(int userID)        //Creating Device with User
	{
		//User user=ur.findById(userID);
		//System.out.println(user);
		Optional<User> optional= ur.findById(userID);
		System.out.println("From service1");
		User tempUser=optional.get();
		
		//User myUser=Optional.of(tempUser);
		Device device=dr.save(new Device("Nokia x6", 120.99,87988734, tempUser));
		System.out.println("From service2");
		//Device device = dr.save(new Device("Nokia x6",100.00,tempUser));
		System.out.println(device);
		return null;
	}
	
	public void removeDevice(int id,String name)
	{
		//System.out.println(id+name);
		//List<Device> devices=dr.findByPriceEquals(amount);
		//List<Device> devices=dr.findByPriceLessThan(amount);
		//System.out.println(devices);
		//Device device=dr.findByUserIdAndName( id, name);
		 List<Device> devices= dr.findByName(name);
		 System.out.println(devices);
		 for(Device i : devices)
		 {
			 //System.out.println("Device Names are ");
			 //System.out.println(i.getName());
			 /*
			 List<User> users=(List<User>) i.getUser();
			 for(User j:users)
			 {
				 System.out.println(users);
			 }
			 */
			 //System.out.println(i.getUser());
			 if(i.getUser().getId()==id)
			 {
				 System.out.println("Holla");
				 int deviceID=i.getId();
				 System.out.println("The device id is "+ deviceID);
				 dr.deleteById(deviceID);
			 }
			 else
			 {
				 System.out.println("Shaua");
			 }
		 }
		
		
	}
	
	

}
