package com.revature.strings;

public class StringDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello";
		String s1 = "Hello";
		String s2 = new String("Hello");

		 //comparing memory address
		System.out.println("Is s==s1?" + (s == s1)); //true
		System.out.println("Is s==s2?" + (s == s2)); //false
		
		System.out.println("Is s==s2?" + s.equals(s2)); 
		
		/*
		 * String methods to look into
		 * 
		 */
		StringBuilder sb = new StringBuilder("Hello World!");
		
		sb.reverse();
		
		sb.append("abc");
		
		System.out.println(sb);
		
		//string Every immutable object in Java is thread safe
	}

}
