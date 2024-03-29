/**
 * Rotate Matrix
 * 
 * Problem Description

	You are given a n x n 2D matrix A representing an image.
	
	Rotate the image by 90 degrees (clockwise).
	
	You need to do this in place.
	
	Note: If you end up using an additional array, you will only receive partial score.
	
	
	
	Problem Constraints
	
	1 <= n <= 1000
	
	
	
	Input Format
	
	First argument is a 2D matrix A of integers
	
	
	
	Output Format
	
	Return the 2D rotated matrix.
	
	
	
	Example Input
	
	Input 1:
	
	 [
	    [1, 2],
	    [3, 4]
	 ]
	Input 2:
	
	 [
	    [1]
	 ]
	
	
	Example Output
	
	Output 1:
	
	 [
	    [3, 1],
	    [4, 2]
	 ]
	Output 2:
	
	 [
	    [1]
	 ]
	
	
	Example Explanation
	
	Explanation 1:
	
	 After rotating the matrix by 90 degree:
	 1 goes to 2, 2 goes to 4
	 4 goes to 3, 3 goes to 1
	Explanation 2:
	
	 2D array remains the same as there is only element.
 
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class Rotate90Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = {
				  {1,2,3},{4,5,6},{7,8,9}
				};
		solve(A);

	}

	public static void solve(int[][] A) {
		int n=A.length;
		int temp=0;
		for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            	System.out.print(A[i][j] +" ");
            }
            System.out.println();
        }
		System.out.println("----------------------------------");
		for(int i=0;i<(n+1)/2;i++) {
			for(int j=0;j<n/2;j++) {
				temp = A[n-1-j][i];
				A[n-1-j][i] = A[n-1-i][n-j-1];
				A[n-1-i][n-j-1] = A[j][n-1-i];
				A[j][n-1-i] = A[i][j];
				A[i][j] = temp;
			}
		}
		
		for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            	System.out.print(A[i][j] +" ");
            }
            System.out.println();
        }
    }
}
