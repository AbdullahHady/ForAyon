package com.skillstorm.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.mobile.models.Device;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Integer> {
	
	//public List<Device> findByPriceLessThan(double amount);
	//public List<Device> findByPriceEquals(double amount);
	//public void deleteByIdEquals(int id);
	public List<Device> findByName(String deviceName);
}
