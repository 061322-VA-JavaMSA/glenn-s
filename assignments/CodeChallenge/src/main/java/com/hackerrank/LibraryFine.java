/**
 * 
 */
package com.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibraryFine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LibraryFineResult {

	/*
	 * Complete the 'libraryFine' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER d1 2. INTEGER m1 3. INTEGER y1 4. INTEGER d2 5.
	 * INTEGER m2 6. INTEGER y2
	 */

	public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
		// Write your code here
		int result = 0;
		if (y1 != y2) {
			if (y2 < y1) {
				result = (y1 - y2) * 10000;
			}

		} else if (m1 != m2) {
			if (m2 < m1) {
				result = (m1 - m2) * 500;
			}
		} else if (d1 != d2) {
			if (d2 < d1) {
				result = (d1 - d2) * 15;
			}
		}

		return result;
	}

}

class LibraryFineSolution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int d1 = Integer.parseInt(firstMultipleInput[0]);

		int m1 = Integer.parseInt(firstMultipleInput[1]);

		int y1 = Integer.parseInt(firstMultipleInput[2]);

		String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int d2 = Integer.parseInt(secondMultipleInput[0]);

		int m2 = Integer.parseInt(secondMultipleInput[1]);

		int y2 = Integer.parseInt(secondMultipleInput[2]);

		int result = LibraryFineResult.libraryFine(d1, m1, y1, d2, m2, y2);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
