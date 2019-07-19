package com.tutorial.json.entity;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.Pattern;

import com.tutorial.json.entity.validation.LettersOnly;

@XmlRootElement
public class UserDto {
	@XmlElement(name = "first_name")
	@Size(min = 5, max = 20, message = "First name should be between 5 and 20 characters.")
	//@LettersOnly(message = "fasdfa fasd ")
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement(name = "last_name")
	private String lastName;
	private String email;
	private String password;
	
	@XmlElement(name = "confirm_password")
	private String confirmPassword;	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
