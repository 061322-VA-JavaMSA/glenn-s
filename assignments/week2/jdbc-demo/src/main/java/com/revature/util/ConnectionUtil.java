package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	// reuse c instead of creating new connections to the database
	private static Connection c;

	public static Connection getHardcodedConnection() throws SQLException {
		// String url = "jdbc:[driver]://[url]:[port]/[db-name]";
		// String url = "jdbc:postgresql://localhost:5432/postgres";
		String url = "jdbc:postgresql://database-1.cllvqmegtmuc.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "p4ssw0rd";

		// checks if a connection is open else opens a new one and assigns it to c
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
	
	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("connection.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
	
	public static Connection getConnectionFromEnv() throws SQLException {
		/*
		 * In windows, search for environment variables in search bar
		 * 	- set new system variables
		 *  - RESTART IDE TO RESET THE VARIABLE
		 */
		
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
}
