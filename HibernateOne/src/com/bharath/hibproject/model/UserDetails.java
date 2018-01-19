package com.bharath.hibproject.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@Column(name="USER_ID")
	private int userId;
	private String userName;
	@ElementCollection
	private Set<Address> listOfAdresses=new HashSet<>();
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
	public Set<Address> getListOfAdresses() {
		return listOfAdresses;
	}
	public void setListOfAdresses(Set<Address> listOfAdresses) {
		this.listOfAdresses = listOfAdresses;
	}
	
}
