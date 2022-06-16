package com.revature.scanner;

import java.util.Scanner;
import java.util.Random;
public class ScannerDriver {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Hello Word!");
//		System.out.println("What is your name?");
//		
//		String name = scan.nextLine();
//		
//		System.out.println("Hello " + name + "!");
//		System.out.println("Please pick a number");
//		
//		int num = scan.nextInt();
//		scan.nextLine();
//		System.out.println("Your number is " + num);
//		System.out.println("Please pick a number from 1-2:");
//		String number = scan.nextLine();
//		switch(number) {
//		case "1":
//			System.out.println("Hello");
//		break;  	
//		case "2":
//			System.out.println("Goodbye");
//		break;  			
//		default:
//			System.out.println("Unrecognized");
//			
//		}
//		scan.close();
//		loginScreen();
		
		//menu();
		 menuKevin();
	}
	
	public static void loginScreen() {
		String username = "admin";
		String password = "pass";
		
		System.out.println("Please enter username");
		String usernameInput = scan.nextLine();  
		
		System.out.println("Please enter password");
		String passwordInput = scan.nextLine();  
		
		if(username.equals(usernameInput) && password.equals(passwordInput)) {
			System.out.println("Welcome");
		} else {
			System.out.println("Invalid Credentials");
		} 
	}

 

	public static void menu() {
		/*
		 * Menu that gives a user multiple options:
		 * 	- 1: get a random number
		 *  - 2: reverse a String of the user's choice
		 *  - 3: exit the program
		 *  
		 *  this menu should repeat until the user decides to exit
		 */
		Boolean checkExit = true;
		while (checkExit)  {
			System.out.println("Menu please enter a number of your choice");
			System.out.println("1: get a random number");
			System.out.println("2: reverse a String");
			System.out.println("3: exit the program");
			String usernameInput = scan.nextLine();  
			switch(usernameInput) {
			case "1":
				System.out.println("Your random number " +  Math.round(Math.random() * 100));
			break;  	
			case "2":
				System.out.println("enter a text");
				StringBuffer sb = new StringBuffer(scan.nextLine());
				System.out.println(sb.reverse());
			break;  
			case "3":
				System.out.println("bye");
				checkExit = false;
			break;  
			default:
				System.out.println("Invalid option.");			
 			}				
		} 
	
		
	}
	
	public static void menuKevin() {
		/*
		 * Menu that gives a user multiple options:
		 * 	- 1: get a random number
		 *  - 2: reverse a String of the user's choice
		 *  - 3: exit the program
		 *  
		 *  this menu should repeat until the user decides to exit
		 */
		
		boolean run = true;
		while(run) {
			System.out.println("Please select an option:\n"
								+ "1: to retrieve a random number\n"
								+ "2: to reverse a word\n"
								+ "3: to exit the program");
			String input = scan.nextLine();
			switch(input) {
			case "1": 
				System.out.println("Here's a random number: " + Math.round(Math.random() * 100));
				break;
			case "2":
				System.out.println("Please enter a word:");
				StringBuffer sb = new StringBuffer(scan.nextLine());
				System.out.println("Here is your reversed word: " + sb.reverse());
				break;
			case "3":
				run = false;
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option.");
			}
			
		}
	} 
}
