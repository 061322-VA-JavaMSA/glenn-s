package com.revature.week3;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class ReduceString {
 
	public static String reduceString(int N, String S) {

		// this is default OUTPUT. You can change it.
		String result = "-404";
 		// write your Logic here:
		String output = "";
 		for (int i =0; i < S.length(); i++) {
 			if(output.indexOf(S.substring(i, i +  1)) < 0 ) {
 				output = output + S.substring(i, i +  1);
 			}
			  
  		} 
 		
	    if(!output.isEmpty()) {
	    	result = output;
	    }
  		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner sc = new Scanner (System.in);

	    //INPUT [uncomment & modify if required]
//	    int N = sc.nextInt ();
//	    String S = sc.next();
	    int N = 13;
	    String S = "ebgnhamdhnuxbvzlufpkksnbvdsssjdwkkjumxxtntsooraiyrsllimgnhafq";	    
	    sc.close ();

	    //OUTPUT [uncomment & modify if required]
	    System.out.println(reduceString(N,S));
	    System.out.println("ebgnhamduxvzlfpksjwtoriyq");

	}

}
