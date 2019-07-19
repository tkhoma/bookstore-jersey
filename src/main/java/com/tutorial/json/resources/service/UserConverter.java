package com.tutorial.json.resources.service;

import com.tutorial.json.entity.User;
import com.tutorial.json.entity.UserDto;

public class UserConverter {

	public User convert(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return user;
	}

}
