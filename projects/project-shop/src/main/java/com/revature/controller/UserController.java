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

//		String username = "fclemente1";
//		String password = "R8fiv28oiT10";

		String username = "bmattiessen0";
		String password = "iq063Zx7";
		
		try {
			currentUser = as.login(username, password);
			log.info(currentUser);
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			// log.error("Login exception was thrown: " + e.fillInStackTrace());
		}
 		if (currentUser.getRole_id() == 1) {
			ec.employeeStartMenu();
		} else if (currentUser.getRole_id() == 2) {
			cc.save(currentUser);
			cc.customerStartMenu(); 
		} 
	}


}
