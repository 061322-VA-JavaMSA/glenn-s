/**
 * 
 */
package com.leetcode;

/**
 *
 */
public class TwoSum {

}
/*
 * [2,7,11,15]
9
[3,2,4]
6
[3,3]
6
 */
class TwoSumSolution {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int x = (i + 1); x < nums.length; x++) {
				if ((nums[i] + nums[x]) == target) {
					result[0] = i;
					result[1] = x;
				}

			}

		}
		return result;
	}
}