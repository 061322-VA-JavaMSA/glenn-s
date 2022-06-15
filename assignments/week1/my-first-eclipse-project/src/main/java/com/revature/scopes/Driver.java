package com.revature.scopes;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass mc = new MyClass();
		MyClass mc1 = new MyClass("Kevin");
		
		System.out.println(mc.reverseString("Nikita"));
		System.out.println(mc.reverseString("Asmaa"));
		
		System.out.println("mc: " + mc.myString);
		System.out.println("mc1: " + mc1.myString);
		
		boolean isCool; // not provided a default value
		
		int x = MyClass.myStaticVariable;
		String s = mc.myString;
	}

}
