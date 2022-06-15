package com.revature.scopes;

public class MyClass {
	public static int myStaticVariable = 1;
	
	// instance scope
	public String myString;
	public boolean myBool; // default value is false
	
	public MyClass() {
		
	}
	
	public MyClass(String myString) {
		this.myString = myString; // "this" keyword prevents variable shadowing
	}
	// [access modifier] [non-access modifiers] [returnType] [name] ([params if any]){}
	// Reverse a String, take in a String and return a reversed String
	public String reverseString(String stringToBeReversed) {
		// boa => aob
		// kevin => nivek
		String reversed = "";

		char[] letters = stringToBeReversed.toCharArray();
		
		for(int i = letters.length-1; i >= 0 ;i--) {
			reversed = reversed + letters[i];
		}

		return reversed;
	}
	
	public static void myStaticMethod() {
		
	}
}
