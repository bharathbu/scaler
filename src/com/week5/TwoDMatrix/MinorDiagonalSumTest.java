/**
 * 
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class MinorDiagonalSumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = {
				  {2, 8, 8, 8},{2, 8, 8, 8},{2, 8, 8, 8},{2, 8, 8, 8}
				};
		
		System.out.println(solve(A));	
    }	
	public static int solve(int[][] A) {
		int n = A.length, m=A[0].length,result=0; 
		for(int i=0;i<n;i++) {
			result+=A[i][n-1-i];
		}
		return result;
  }

}
