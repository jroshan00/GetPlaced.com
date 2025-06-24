package com.infosys.servlet_simple_demo.entity;

public class StudentMessage extends StudentEntity {
	private String message;
	private String name;
	private String email;
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getEmail() {
		return email;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMessage(String feedback) {
		this.message = feedback;
	}
	
	@Override
	public String toString() {
		return "[ name: "+name+"\temail: "+email+"\tmesssage: "+message+" ]";
	}
}
