/**
 * Spiral Order Matrix II

Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints

1 <= A <= 1000



Input Format

First and only argument is integer A


Output Format

Return a 2-D matrix which consists of the elements in spiral order.



Example Input

Input 1:

1
Input 2:

2


Example Output

Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation

Explanation 1:

 
Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class SpiralOrderMatrixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] result = generateMatrix(4);
		for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
            	System.out.print(result[i][j] +" ");
            }
            System.out.println();
        }
		

	}
	
	public static int[][] generateMatrix(int A) {
	        int top=0, bottom=A-1, left=0, right=A-1, a = 1;
	        int[][] result = new int[A][A];
	        while(top <= bottom && left <= right){
	            for(int k=left;k<=right;k++){
	            	result[top][k] = a++;
	            }
	            top++;
	            for(int k=top;k<=bottom;k++){
	            	result[k][right] = a++;
	            }
	            right--;
	            for(int k=right;k>=left;k--) {
	            	result[bottom][k] = a++;
	            }
	            bottom--;
	            for(int k=bottom;k>=top;k--) {
	            	result[k][left] = a++;
	            }
	            left++;
	        }
	        return result;
	    }

}
