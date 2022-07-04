/**
 * 
 */
package com.revature.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Staircase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}

}

class StaircaseResult {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
           String number_char = "";  
           String space = "";
           int x = 1;
           while(x <= n)  {      
                   space = "";     
                for (int i = x; i < n; i++ ) {
                    space = space +" ";
                } 
                number_char = number_char + "#"; 
              System.out.println(space + number_char );
            x++;
           } 
 
     }

}

class StaircaseSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        StaircaseResult.staircase(n);

        bufferedReader.close();
    }
}