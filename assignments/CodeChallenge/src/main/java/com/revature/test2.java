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
		int[] nums = { 3,3};
		int target = 6;
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int x = (i + 1 ); x < nums.length; x++) {
				if ((nums[i] + nums[x]) == target) {
					result[0] = i;
					result[1] = x;

				}

			}
				
		}
		System.out.println(result[0]+ " " + result[1] );
	}

}
