package com.tutorial.json.resources;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tutorial.json.entity.User;
import com.tutorial.json.entity.UserDto;
import com.tutorial.json.resources.service.UserConverter;
import com.tutorial.json.resources.service.UserService;

@Path("/user")
public class UserResource {
	@Inject
	// we should not put here UserServiceImpl because we configured 
	// UserService in jersey configuration
	private UserService userService;
	
	@Inject
	private UserConverter userConverter;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserDto getUser() {
		UserDto user = new UserDto();
		user.setFirstName("Taras");
		user.setLastName("Khoma");
		user.setEmail("test@gmail.com");
		user.setPassword("test");
//		userService.addUser(user);
		return user;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveUser(@Valid UserDto userDto) {
		User user = userConverter.convert(userDto);
//		userService.addUser(user);
	}
}
