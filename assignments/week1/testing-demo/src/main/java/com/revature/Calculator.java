package com.revature;

import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.Number13Exception;

public class Calculator {
	/*
	 * - add(int a, int b)
	 * 		- if the result is 13
	 * 			- throw an exception
	 * 				- Number13Exception
	 * - subtract
	 * - multiply
	 * - sum of an array
	 * - divide
	 * 		- throw a custom exception if divided by 0
	 */
	
	public int add(int a, int b) {
		int sum = a + b;
		if(sum == 13 ) {
			throw new Number13Exception();
		}	
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int sumOfAnArray(int[] intArr) {
	    int sum = 0;
	    for (int value : intArr) {
	        sum += value;
	    }
	    return sum;
	}
	
	public int divide(int a, int b) {
		if(b == 0) {
			throw new DivideBy0Exception();
		}	
	    return a / b;
	}	
}