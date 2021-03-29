package com.manageuser.finalmanageuser.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="country")
	private String country;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="role")
	private String Role;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<GroupUser> groupuser;
	
	public User()
	{
		
	}

	public User(int id, String username, String password, String country, int pincode, String role,
			List<GroupUser> groupuser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.country = country;
		this.pincode = pincode;
		Role = role;
		this.groupuser = groupuser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public List<GroupUser> getGroupuser() {
		return groupuser;
	}

	public void setGroupuser(List<GroupUser> groupuser) {
		this.groupuser = groupuser;
	}
	
	
}
