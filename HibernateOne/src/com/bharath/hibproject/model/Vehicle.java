package com.bharath.hibproject.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleModel;
	@ManyToMany(mappedBy="vehicleList")
	private Collection<UserDetails> userDetailsList=new ArrayList<>();
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public Collection<UserDetails> getUserDetailsList() {
		return userDetailsList;
	}
	public void setUserDetailsList(Collection<UserDetails> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}
	
	
}
