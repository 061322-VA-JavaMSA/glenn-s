package com.revature.strings;

public class StringBuild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder();
		String a = new String();
		
		s.append("test");
		
		a = s.toString();
		
		s.delete(0,s.length());
		s.append(a.replace("e","g"));
		System.out.println(s.substring(1,2));
		System.out.println(s);
		
	}

}
