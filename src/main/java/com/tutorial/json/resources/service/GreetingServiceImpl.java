package com.tutorial.json.resources.service;

public class GreetingServiceImpl implements GreetingService {
	@Override
	public String getGreeting(String name) {
		return "Hello, " + name;
	}

}
