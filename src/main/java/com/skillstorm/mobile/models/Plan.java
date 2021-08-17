package com.skillstorm.mobile.models;

import java.util.List;

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
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@NotBlank
	private String planName;
	
	@Column
	private double cost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID") //FOREIGN Key
	private User user;
	
	@OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
	@Column
	private List<Device> device; 
    
	
	
	
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Plan(int id, @NotBlank String planName, double cost, User user, List<Device> device) { // All Fields
		super();
		this.id = id;
		this.planName = planName;
		this.cost = cost;
		this.user = user;
		this.device = device;
	}

	public Plan(int id, @NotBlank String planName, double cost, User user) { // All Field except Device 
		super();
		this.id = id;
		this.planName = planName;
		this.cost = cost;
		this.user = user;
	}
	
	
	
	
	
	public Plan(@NotBlank String planName, double cost, User user, List<Device> device) {
		super();
		this.planName = planName;
		this.cost = cost;
		this.user = user;
		this.device = device;
	}

	public Plan(@NotBlank String planName, double cost, User user) { // Except id 
		super();
		this.planName = planName;
		this.cost = cost;
		this.user = user;
	}
	
	
	public Plan(@NotBlank String planName, double cost) { // Except id and User object field
		super();
		this.planName = planName;
		this.cost = cost;
		
	}
    
	public Plan(int id, @NotBlank String planName, double cost) {   // without user object field
		super();
		this.id = id;
		this.planName = planName;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	
	
	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", planName=" + planName + ", cost=" + cost + ", user=" + user + "]";
	}
	
	
	

}
