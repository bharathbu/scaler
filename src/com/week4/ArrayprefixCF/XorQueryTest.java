/**
 * Xor queries
 * 
 * Problem Description

You are given an array A (containing only 0 and 1) as element of N length.
Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.



Problem Constraints

1<=N,Q<=100000
1<=L<=R<=N


Input Format

First argument contains the array of size N containing 0 and 1 only. 
Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.


Output Format

Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.


Example Input

A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]


Example Output

[[0 3]
[0 3]
[1 2]]


Example Explanation

In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
Similarly for other queries.

 */
package com.week4.ArrayprefixCF;

/**
 * @author Bharath
 *
 */
public class XorQueryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,0,0,0,1};
		int[][] B = {
				{2,4},{1,5},{3,5}
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

	public static int[][] solve(int[] A, int[][] B) {
		int n=B.length, xor=0, zCount=0,si=0,se=0;
		int[][] result = new int[n][2];
		
		for(int i=0;i<n;i++) {
			si=B[i][0];
			se=B[i][1];
			for(int j=si-1;j<se;j++) {
				xor = xor^A[j];
				if(A[j] == 0)
					zCount++;
			}
			result[i][0] = xor;
			result[i][1] = zCount;
			xor=0; zCount=0;
		}
		return result;
    }
	
}
