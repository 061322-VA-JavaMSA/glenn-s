package com.revature.memory;


//Stack Memory in Java is used for static memory allocation 
//and the execution  of a thread

//Heap space is used for the dynamic memory allocation 
//of Java objects and JRE classes at runtime
public class Driver {
	int myNumber = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		
		Driver d = new Driver();
		
//		d.method1(x);
//		
//		x = d.method2(x);
//
		System.out.println(x);
		
		d.method3(d);
		System.out.println(d.myNumber);
	}

	public void method1(int x) {
		x = x + 5;
	}
	
	public int method2(int x) {
		return x = x + 5;
	}	
	
	public void method3(Driver d) {
		d.myNumber = d.myNumber + 5;
	}		
}
