package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;

public class DriverTest {
	static UserService us;

	public static void main(String[] args) {
		us = new UserService();
		List<User> users = us.getUsers();
		for(User u : users) {
			System.out.println(u);
		}	
		
	}
	
 
}
