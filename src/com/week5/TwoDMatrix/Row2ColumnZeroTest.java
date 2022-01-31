/**
 * Row to Column Zero
 * 
 * Problem Description

You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.



Problem Constraints

1 <= A.size() <= 103

1 <= A[i].size() <= 103

0 <= A[i][j] <= 103



Input Format

First argument is a vector of vector of integers.(2D matrix).



Output Format

Return a vector of vector after doing required operations.



Example Input

Input 1:

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]


Example Output

Output 1:

[1,2,0,0]
[0,0,0,0]
[0,0,0,0]


Example Explanation

Explanation 1:

A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.

 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class Row2ColumnZeroTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] A = {
				  {2, 8, 8, 8},{2, 8, 7, 0},{7, 1, 0, 2},{2,8,8,8},{2,8,8,8}
				};
		int n=A.length, m=A[0].length;
		int[][] result= solve(A);
		for(int i=0;i<n;i++){
	          for(int j=0;j<m;j++){
	          	System.out.print(result[i][j] +" ");
	          }
	          System.out.println();
	      }
		
	}
	
	public static int[][] solve(int[][] A) {
		int n=A.length, m=A[0].length;
		int[][] result = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result[i][j]=A[i][j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if( A[i][j] ==0 ) {
					makeZero(result,i,j,n,m);
				}
			}
		}
		return result;
    }

	private static void makeZero(int[][] result, int i, int j,int n,int m) {
		for(int l=0;l<m;l++)
			result[i][l]=0;
		for(int k=0;k<n;k++)
			result[k][j]=0;
	}

}
