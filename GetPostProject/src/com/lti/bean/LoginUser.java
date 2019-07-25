package com.lti.bean;

public class LoginUser {
	
	private String username;
	private String email;
	public LoginUser( ) {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", email=" + email + "]";
	}

}
