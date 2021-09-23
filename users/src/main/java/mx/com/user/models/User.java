package mx.com.user.models;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = -4458874740740402345L;
	private String name;
	private String username;
	private String pasword;
	
	public User(String name, String username, String pasword) {
		this.name = name;
		this.username = username;
		this.pasword = pasword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	
}
