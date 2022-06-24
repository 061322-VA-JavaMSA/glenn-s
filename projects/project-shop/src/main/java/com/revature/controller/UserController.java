package com.revature.controller;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserController {
	static Scanner scan;
	static UserService us;
	static AuthService as;
	static ProductController pc;
	private static Logger log = LogManager.getLogger(UserController.class);
	static User currentUser = new User();

	public void login() {
		as = new AuthService();

		scan = new Scanner(System.in);

//		String username = null;
//		String password = null;
//		System.out.println("Please enter username:");
//		username = scan.nextLine();
//		System.out.println("Please enter password:");
//		password = scan.nextLine();

		String username = "fclemente1";
		String password = "R8fiv28oiT10";
		
		try {
			currentUser = as.login(username, password);
			log.info(currentUser);
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			// log.error("Login exception was thrown: " + e.fillInStackTrace());
		}
		System.out.println(currentUser); 
		if (currentUser.getRole_id() == 1) {
			employeeStartMenu();
		} else if (currentUser.getRole_id() == 2) {
		}
	}

	public void employeeStartMenu() {
		pc = new ProductController();
		scan = new Scanner(System.in);
		int choice = 0;
		int done = 0;

		while (done == 0) {
			System.out.println("Main Menu:");
			System.out.println("1 = Products");
			System.out.println("2 = Offers");
			System.out.println("3 = exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				pc.startMenu();
				break;
			case 2:

				break;
			case 3:
				done = 1;	
				System.err.println("Bye");
				break;
			default:
				System.err.println("Please try again");
				break;
			}
			
		}

	}
}
