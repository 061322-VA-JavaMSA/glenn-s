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
		
		menu();
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
		String checkExit = "0";
		while (!checkExit.equals("3"))  {
			StringBuilder sb = new StringBuilder();
			System.out.println("Menu please enter a number of your choice");
			System.out.println("1: get a random number");
			System.out.println("2: reverse a String");
			System.out.println("3: exit the program");
			String usernameInput = scan.nextLine();  
			checkExit = usernameInput;
			switch(usernameInput) {
			case "1":
				System.out.println("enter a number");
				Integer numberInput = scan.nextInt(); 
				System.out.println("Your number " + (numberInput *   Math.random()));
			break;  	
			case "2":
				System.out.println("enter a text");
				String textInput = scan.nextLine();  
				sb.append(textInput);
				System.out.println(sb.reverse());
			break;  
			case "3":
				System.out.println("bye");
			break;  			
 			}				
		} 
	
		
	}
}
