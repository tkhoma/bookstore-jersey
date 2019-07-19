package com.tutorial.json.resources.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import com.tutorial.json.entity.User;
import com.tutorial.json.resources.dao.DbConnection;

public class UserServiceImpl implements UserService {
	@Inject
	private DbConnection dbConnection;

	@Override
	public void addUser(User user) {
		Connection connection = dbConnection.createConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into user (FirstName, LastName, Password, Email) values (?, ?, ?, ?, ?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			
//			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
		
		System.out.println("User is created");
	}

	private void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
