package com.revature.week3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RearrangeLetters {
	public static String rearrangeLetters(String S) {
		// this is default OUTPUT. You can change it.
		String result = "-404";
	    char[] charArr = S.toCharArray();
	    Arrays.sort(charArr);
	    ArrayList<String> dups = new ArrayList<String>(); 
	    for (int i = 0; i < charArr.length; i++) {
	        for (int j = i + 1; j < charArr.length; j++) {
	            if (charArr[i] == charArr[j]) {
	                dups.add( ""+ charArr[j]);
	                
	            }
	        }
	    }
	    String text = "";
	    for (int i = 0; i < charArr.length; i++) {
	        if(dups.contains(""+charArr[i])) {
	            text = text + charArr[i];
	        }
	    }    
	    if(!text.isEmpty()) {
	        result = text;
	    }
 		return result;
	}

	  public static void main (String[]args)
	  {
	    Scanner sc = new Scanner (System.in);

	    //INPUT [uncomment & modify if required]
	    String S = sc.next();
	    
	     sc.close ();

	    //OUTPUT [uncomment & modify if required]
	    System.out.print(rearrangeLetters(S));
	  }
}
