package com.revature;

import java.util.Arrays;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello from Eclipse!");
		
				boolean bool = true; // 1bit
				byte myByte = 127; // 8bits (-128 to 127)
		//		myByte = 128;
				short myShort = 128; // 16 bits or 2 bytes
				char myChar = 'a'; // 16 bits of memory
				
				int standardDataTypeForWholeNumber = 12345; // 32 bits
				float lessPreciseDouble = 92.3f; // 32 bits
				
				double standardDecimal = 20.45; // 64 bits
				long bigNumber = 165654654L; // 64 bits
				
				/*
				 * Casting
				 */
				// implicit/automatic
				byte a = 2;
				int b = a;
				
				//explicit
				double d = 35.5;
				float f = (float)d;
				
				// s and s2 are a reference type that references the String in the heap
				String s = "Hello";
				String s2 = new String("World");
				
				Object o = new Object();
				
		//		Integer intWrap = new Integer(standardDataTypeForWholeNumber);
				Integer intWrap = standardDataTypeForWholeNumber;
				
				// Converts string "5" to int 5
				int i = Integer.parseInt("5");
				
				System.out.println("Max value for int: " + Integer.MAX_VALUE + ", min value for int: " + Integer.MIN_VALUE);
			
				// declaring an array
				int[] numbers;
				
				// create an array of size 5 and assign it to the variable numbers
				numbers = new int[5];
				
				numbers[0] = 2;
				numbers[3] = 4;
				
		//		System.out.println(numbers[0]);
				
				for(int j = 0; j < numbers.length; j++ ) {
					System.out.println(numbers[j]);
				}
				
				// enhanced for-loop, however we don't have access to the index
				for(int in : numbers) {
					System.out.println(in);
				}
				
				String k = "kevin";
				char[] chars = k.toCharArray();	
				
				for(char c : chars) {
					System.out.println(c);
				}
				
				Arrays.sort(numbers);
				
				// enhanced for-loop, however we don't have access to the index
				for(int in : numbers) {
					System.out.println(in);
				}
	}

}
