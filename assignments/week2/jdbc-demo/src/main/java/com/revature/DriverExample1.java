package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.revature.models.User;

public class DriverExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "";
		
		try {
			Connection c = DriverManager.getConnection(url,username,password);
			System.out.println(c.getMetaData().getDriverName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		User u = null; 
		try {
			String sql = "select * from week2tuesday.users ";
			Connection c = DriverManager.getConnection(url,username,password);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql); 
			
			while ( rs.next() ) {
		          String  username1 = rs.getString("username");

		          String password1  = rs.getString("password");
		          System.out.println(username1 + ' '+ password1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
