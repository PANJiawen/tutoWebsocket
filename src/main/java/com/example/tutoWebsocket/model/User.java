package com.example.tutoWebsocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String name;
    private String sex;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User(String username, String password, String name, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
	}
    
	public User() {
		super();
	}
    
}