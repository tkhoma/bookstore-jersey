package com.tutorial.json.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.tutorial.json.resources.service.GreetingService;

@Path("/greeting")
public class GreetingResource {
	@Inject
	private GreetingService greetingService;
	
	@GET
	@Produces
	public String getGreeting(@QueryParam("name") String name) {
		return greetingService.getGreeting(name);
	}
}
