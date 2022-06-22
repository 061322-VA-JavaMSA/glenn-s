package com.revature.controller;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.util.StartMenuSystem;

public class HomeController {
	static Scanner sc;
	static UserService us;
	static User currentUser = new User(); 
    static AuthService authService = new AuthService();
	public static void home() {
		// Scanner, menus
		User newUser = new User();
		us = new UserService();	
 		sc = new Scanner(System.in);
 		StartMenuSystem sms = new StartMenuSystem();
		System.out.println("Welcome to Task Manager!");
		System.out.println("Please select an option \n -1: Register");
		System.out.println("Please select an option \n -2: Login");
		String choice = sc.nextLine();
		switch(choice) {
			case "1":
				
				User registerUser = sms.registerMenu();
				System.out.println(registerUser);
				if(authService.register(registerUser)) {
				 us.createUser(registerUser);
 				} 
				
			break;
			case "2":
				currentUser = sms.login();
			break;		
		}	
		sc.close();
	}
}
