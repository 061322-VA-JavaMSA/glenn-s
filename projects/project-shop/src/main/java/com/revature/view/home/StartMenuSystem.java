package com.revature.view.home;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;

public class StartMenuSystem {
	static Scanner sc;
	static UserService us;
	public  StartMenuSystem() {
		sc = new Scanner(System.in);

	}
	public User registerMenu() {
		
		User newUser = new User();
		System.out.println("Register:");
		System.out.println("Please enter your username:");
		newUser.setUsername(sc.nextLine());
		System.out.println("Please enter your password:");
		newUser.setPassword(sc.nextLine());
		sc.close();		
		return newUser;
	}

	public User login() {
		User checkUser = new User();
		System.out.println("Login:");
		System.out.println("Please enter your username:");
		checkUser.setUsername(sc.nextLine());
		System.out.println("Please enter your password:");
		checkUser.setPassword(sc.nextLine());
		sc.close();
		return checkUser;
	}	
}
