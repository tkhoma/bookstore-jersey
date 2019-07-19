package com.tutorial.json.resources.dao;

import java.sql.Connection;

public interface DbConnection {
	Connection createConnection();
}
