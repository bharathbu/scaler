/**
 * Row Sum
 * 
 * Problem Description

You are given a 2D integer matrix A, return a 1D integer vector containing row-wise sums of original matrix.



Problem Constraints

1 <= A.size() <= 103

1 <= A[i].size() <= 103

1 <= A[i][j] <= 103



Input Format

First argument is a vector of vector of integers.(2D matrix).



Output Format

Return a vector conatining row-wise sums of original matrix.



Example Input

Input 1:

[1,2,3,4]
[5,6,7,8]
[9,2,3,4]


Example Output

Output 1:

{10,26,18}


Example Explanation

Explanation 1

Row 1 = 1+2+3+4 = 10
Row 2 = 5+6+7+8 = 26
Row 3 = 9+2+3+4 = 18
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class RowSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = {
				  {2, 8, 8, 8},{2, 8, 7, 6},{7, 1, 8, 2},{5, 3, 4, 9}
				};
		int n=A.length;
		int[] result = solve(A);
		for(int i=0;i<n;i++) {
			System.out.print(result[i] +" ");
		}

	}
	
	public static int[] solve(int[][] A) {
		int n = A.length, m= A[0].length;
		int[] result = new int[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result[i] += A[i][j];
			}
		}
		return result;
    }

}
