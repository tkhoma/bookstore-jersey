package com.tutorial.json.config;

import org.glassfish.hk2.api.PerLookup;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.tutorial.json.exception.BookstoreExceptionMapper;
import com.tutorial.json.resources.GreetingResource;
import com.tutorial.json.resources.UserResource;
import com.tutorial.json.resources.dao.DbConnection;
import com.tutorial.json.resources.dao.DbConnectionImpl;
import com.tutorial.json.resources.service.GreetingService;
import com.tutorial.json.resources.service.GreetingServiceImpl;
import com.tutorial.json.resources.service.UserConverter;
import com.tutorial.json.resources.service.UserService;
import com.tutorial.json.resources.service.UserServiceImpl;

public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		register(GreetingResource.class);
		register(UserResource.class);
		register(BookstoreExceptionMapper.class);
		register(new AbstractBinder() {

			@Override
			protected void configure() {
				// specify implementation
				bind(GreetingServiceImpl.class)
				// specify interface. This interface is used
				// in classes with Inject annotation
				.to(GreetingService.class)
				// specify when new instance of dependency
				// should be created.
				// Create new instance per every HTTP request
				.in(RequestScoped.class);
				
				bind(UserServiceImpl.class)
				.to(UserService.class)
				.in(RequestScoped.class);
				
				bind(DbConnectionImpl.class)
				.to(DbConnection.class)
				// Create new instance every time
				.in(PerLookup.class);
				
				bindAsContract(UserConverter.class);
			}
			
		});
	}
}
