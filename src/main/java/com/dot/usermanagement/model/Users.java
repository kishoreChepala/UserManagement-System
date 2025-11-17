package com.dot.usermanagement.model;

public class Users {
	
	private int id;
	private String name;
	private String email;
	private String country;
	
	
	public Users(int id, String name, String email, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
	}
	
	
	public Users(String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
