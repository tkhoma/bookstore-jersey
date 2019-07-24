package com.tutorial.json.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tutorial.json.entity.validation.LettersOnly;

@XmlRootElement
public class UserDto {
	@XmlElement(name = "first_name")
	@Size(min = 5, max = 20, message = "First name should be between 5 and 20 characters.")
	@LettersOnly(message = "First name should contain only letters")
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement(name = "last_name")
	@Size(min = 5, max = 20, message = "Last name should be between 5 and 20 characters.")
	@LettersOnly(message = "Last name should contain only letters")
	private String lastName;
	
	//TODO: add email validation
	@NotBlank(message = "Email should be not empty.")
	@Email(message = "Email value has wrong format.")
	private String email;
	@Size(min = 5, max = 20, message = "Password should be between 5 and 20 characters.")
	private String password;
	
	@XmlElement(name = "confirm_password")
	@Size(min = 5, max = 20, message = "Confirm password should be between 5 and 20 characters.")
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
