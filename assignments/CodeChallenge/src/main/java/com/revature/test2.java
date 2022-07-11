/**
 * 
 */
package com.revature;

import java.util.Scanner;

/**
 *
 */
public class test2 {

 
	  public static void main (String[]args)
	  {
	 
 
		    //INPUT [uncomment & modify if required]
		    int N = 26 ;
		    int P = 5;
		    int Q = 4;
		    int P_tmp = 0;
		    int Q_tmp = 0;
		    int total = 0;
		    int i = 0;
		    while (total < N) {
		    	P_tmp = P_tmp + P;
		    	Q_tmp = Q_tmp + Q;		    	
		    	total = Q_tmp + P_tmp;
		    	i++;
		    }  
		    Q_tmp = Q_tmp - Q;
 		    System.out.println(N - Q_tmp);
	    
	  }

}
