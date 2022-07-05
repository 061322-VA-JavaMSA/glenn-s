/**
 * 
 */
package com.revature;

/**
 *
 */
public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 121;
		String st = (new Integer(x).toString());
		String[] num_str =   st.split("");
		boolean bl = false;
		String st_outputString = "";
		if(num_str[0].equals(num_str[(num_str.length - 1)])) {
			for(int i=(num_str.length-1);i>=0;i--) {
				st_outputString = st_outputString + num_str[i];
			}
		} 
		System.out.println(st_outputString);	
		
   	}

}
