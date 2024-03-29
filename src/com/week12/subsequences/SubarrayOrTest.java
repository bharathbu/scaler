/**
 * SUBARRAY OR
 * 
 * Problem Description

Given an array of integers A of size N.

Value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of Value of all subarrays of A % 109 + 7.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 108



Input Format

The first argument given is the integer array A.



Output Format

Return the sum of Value of all subarrays of A % 109 + 7.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [7, 8, 9, 10]


Example Output

Output 1:

 71
Output 2:

 110


Example Explanation

Explanation 1:

 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
Explanation 2:

 Sum of value of all subarray is 110.
 */
package com.week12.subsequences;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class SubarrayOrTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(7);A.add(8);A.add(9);A.add(10);
		System.out.println(solve(A));
	}
	
	public static int solve(ArrayList<Integer> A) {
		int or =0,n = A.size();
		long result=0;
		for(int i=0;i<n;i++) {
			or=0;
			for(int j=i;j<n;j++) {
				or |= A.get(j);
				result+=or;
			}
			
		}
		return (int) (result%1000000007);
		
    }

}
