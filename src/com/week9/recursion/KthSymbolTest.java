/**
 *  Kth Symbol
 *  
 *  Problem Description

On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).



Problem Constraints

1 <= A <= 20

1 <= B <= 2A - 1



Input Format

First argument is an integer A.

Second argument is an integer B.



Output Format

Return an integer denoting the Bth indexed symbol in row A.



Example Input

Input 1:

 A = 2
 B = 1
Input 2:

 A = 2
 B = 2


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 Row 1: 0
 Row 2: 01
Explanation 2:

 Row 1: 0
 Row 2: 01
 */
package com.week9.recursion;

/**
 * @author Bharath
 *
 */
public class KthSymbolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve(5,10));

	}
	
	public static int solve(int A, int B) {
		/*
		index i at ath row  will generate (2i and 2i+1) in (a+1)th row
		 */
		if(B==1) return 0;
		int x = solve(A-1,(B+1)/2);
		if((B+1)%2 == 0) return x;
		else return (1-x);

		/*if(A==1 && B==1)
			return 0;
		int mid = (int) (Math.pow(2, A-1)/2);
		if(B<=mid)
			return solve(A-1,B);
		else
			return (solve(A-1,B-mid)==0?1:0);*/
    }

}
