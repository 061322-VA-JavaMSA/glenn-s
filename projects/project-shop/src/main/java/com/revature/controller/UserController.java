package com.revature.controller;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserController {
	private Scanner scan;
	private UserService us;
	private AuthService as;
	private ProductController pc;
	private  EmployeeController ec;
	private  User currentUser;
	private CustomerController cc;
	private static Logger log = LogManager.getLogger(UserController.class);
 
	public void login() {
		as = new AuthService();
		ec = new EmployeeController(); 
		cc = new CustomerController();
		scan = new Scanner(System.in);

//		String username = null;
//		String password = null;
//		System.out.println("Please enter username:");
//		username = scan.nextLine();
//		System.out.println("Please enter password:");
//		password = scan.nextLine();

// employee		
		String username = "gcrossingham1p";
		String password = "tlaoNFX";

//customer		
//		String username = "lbarr1r";
//		String password = "TK7TvvxeF81T";
		
		try {
			currentUser = as.login(username, password);
			log.info(currentUser);
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			// log.error("Login exception was thrown: " + e.fillInStackTrace());
		}
		if(currentUser != null ) {
	 		if (currentUser.getRole_id() == 1) {
				ec.employeeStartMenu();
			} else if (currentUser.getRole_id() == 2) {
				cc.save(currentUser);
				cc.customerStartMenu(); 
			} 			
		}

	}
	
	public void register() {
		scan = new Scanner(System.in);
		us = new UserService();
		String username = null;
		String password = null;
		System.out.println("Please enter username (length must be greater than 5):");
		username = scan.nextLine();
		System.out.println("Please enter password (length must be greater than 5):");
		password = scan.nextLine();
		if(username.trim().isEmpty() || password.length() < 5  || username.length() < 5) {
				System.out.println("Unable to create your account please try again.");
		} else {
			User checkuser = us.retrieveUserByUsername(username);
			if(checkuser == null) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setRole_id(2);
				us.createUser(u);
				System.out.println("Your account has been created.");
				
			} else {
				System.out.println("Account name already exist");
			}			
		}

		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}	
		
	}	
	
	public void UserStartMenu() {
		scan = new Scanner(System.in);
		PaymentController payc = new PaymentController();
		int choice = 0;
		int done = 0;
		 
		while (done == 0) {
			System.out.println("Account Menu:");
			System.out.println("1 = Login");
			System.out.println("2 = Regsiter");
			System.out.println("3 = Exit");
			choice = scan.nextInt();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  				
			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				done = 1;	
				System.out.println("Bye");
				System.exit(0); 
				break;
			default:
				System.err.println("Please try again");
				break;
			}
			
		}

	}		
 

}
