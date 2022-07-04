package com.revature.week3;

import java.util.Scanner;

public class CarrotsConsumed {
	public static int carrotsConsumed(int N, int M, int[] A) {

		// this is default OUTPUT. You can change it.
		int result = -404;

		int output = 0;
		int calc = 0;
		// write your Logic here:
		for (int i = 0; i < A.length; i = i + M) {
			output = output + A[i];
		}
		if (output > 0) {
			result = output;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// INPUT [uncomment & modify if required]
//	    int N = sc.nextInt ();
//	    int M = sc.nextInt ();
//	    
//	    int[] A = new int[N];
//	    for (int i = 0; i < N; i++)
//	    {
//	        A[i] = sc.nextInt ();
//	    }
		int N = 5;
		int M = 2;
		int[] A = { 2, 3, 1, 4, 5 };
		sc.close();

		// OUTPUT [uncomment & modify if required]
		System.out.print(carrotsConsumed(N, M, A));
	}

}
