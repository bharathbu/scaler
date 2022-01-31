/**
 * Pairs With Given Xor
 * 
 * Problem Description

Given an 1D integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be same and should be counted once.


Problem Constraints

1 <= N <= 105

1 <= A[i], B <= 107



Input Format

First argument is an 1D integer array A.

Second argument is an integer B.



Output Format

Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.



Example Input

Input 1:

 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:

 A = [3, 6, 8, 10, 15, 50]
 B = 5


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 (10 ^ 15) = 5
Explanation 2:

 (3 ^ 6) = 5 and (10 ^ 15) = 5 
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bharath
 *
 */
public class PairsWithXORTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 3, 6, 8, 10, 15, 50
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);A.add(6);A.add(2);A.add(10);A.add(15);A.add(50);A.add(7);
		System.out.println(solve(A,5));
	}
	
	public static int solve(ArrayList<Integer> A, int B) {
		int result = 0,n=A.size(),curr,x;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			set.add(A.get(i));
		}
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			x = curr^B; 
			if(set.contains(x))
				result++;
		}
		return result/2;
    }

}
