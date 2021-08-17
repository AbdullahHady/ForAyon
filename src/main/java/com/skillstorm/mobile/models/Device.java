package com.skillstorm.mobile.models;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Device_Name")
	@NotBlank
	private String name;

	@Column
	@Min(value = 0, message = "Price is more than one")
	private Double price;
	
	@Column(name="Phone_No.")
	private long phoneNo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID") //FOREIGN Key
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Plan_ID") //FOREIGN Key
	private Plan plan;
    
	
	
	
	public Device() {
		super();
	}
    
	public Device(@NotBlank String name, @Min(value = 0, message = "Price is more than one") Double price,long phoneNo, User user) 
	{
		super();
		this.name = name;
		this.price = price;
		this.phoneNo=phoneNo;
		this.user = user;
	}
	
	public Device(int id, @NotBlank String name,@Min(value = 0, message = "Price is more than one") Double price,long phoneNo) 
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.phoneNo=phoneNo;
	}

	public Device(int id, @NotBlank String name,@Min(value = 0, message = "Price is more than one") Double price,long phoneNo, User tempUser) 
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.phoneNo=phoneNo;
		this.user=tempUser;
		
	}

    
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	
	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", price=" + price + ", phoneNo=" + phoneNo + ", user=" + user
				+ ", plan=" + plan + "]";
	}

	
    
	
	

}
