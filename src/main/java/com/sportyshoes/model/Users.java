package com.sportyshoes.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name ="users")
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "user_id")
	private int userId;
	
	
	@Column (name = "name")
	private String name;
	
	
	@Column (name = "password")
	private String password;
	
	public Users() {
		super();
		
	}
	public Users(int userId, String name, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
