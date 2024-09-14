package com.jdbc_crud.connection;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerConnection {

	public static Connection getUserConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
