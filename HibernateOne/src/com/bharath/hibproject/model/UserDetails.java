package com.bharath.hibproject.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	private String userName;
	@ManyToMany
	private Collection<Vehicle> vehicleList=new ArrayList<>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	
	
}
