/**
 * 
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class MatrixMultiplicationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = {
				  {1,2},{3,4}
				};
		int[][] B = {
				{5,6},{7,8}
				};
		int[][] result = solve(A,B);
		
		int n=result.length,m=result[0].length;
		for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            	System.out.print(result[i][j] +" ");
            }
            System.out.println();
        }

	}

	public static int[][] solve(int[][] A, int[][] B) {
    
		int aRows = A.length, aColumns = A[0].length;
		int bRows = B.length, bColumns = B[0].length;
		int[][] result = new int[aRows][bColumns];
		for(int i=0;i<aRows;i++) {
			for(int j=0;j<aColumns;j++) {
				for(int k=0;k<bColumns;k++) {
					result[i][k] += A[i][j]*B[j][k] ;
				}
			}
		}
		return result;
	}
}
