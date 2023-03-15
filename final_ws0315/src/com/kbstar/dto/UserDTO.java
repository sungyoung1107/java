package com.kbstar.dto;

public class UserDTO { 
	
	private String id;
	private String pw;
	private String name;
	private String contact;
	
	public UserDTO() {
	}
	
	public UserDTO(String id, String pw, String name, String contact) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.contact = contact;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
