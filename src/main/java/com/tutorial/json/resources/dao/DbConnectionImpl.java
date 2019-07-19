package com.tutorial.json.resources.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionImpl implements DbConnection {

	@Override
	public Connection createConnection() {
		String connectionUrl = "jdbc:mysql://localhost:3306/book_store";
		String userName = "tutorial";
		String password = "tutorial";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager
                    .getConnection(connectionUrl, userName, password);
		} catch (InstantiationException 
				| IllegalAccessException
				| ClassNotFoundException
				| SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}

}
