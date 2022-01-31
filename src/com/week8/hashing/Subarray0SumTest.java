/**
 * Sub-array with 0 sum
 * 
 * Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints

1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.



Output Format

Return whether the given array contains a subarray with a sum equal to 0.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bharath
 *
 */
public class Subarray0SumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(5);A.add(10);A.add(-1);A.add(-9);A.add(105);
		System.out.println(solve(A));

	}
	
	public static int solve(ArrayList<Integer> A) {
		int result=0,n=A.size();
		long[] ps = new long[n];
		Set<Long> set = new HashSet<Long>();
		ps[0]=A.get(0);
		set.add(ps[0]);
		for(int i=1;i<n;i++) {
			ps[i]=ps[i-1]+A.get(i);
			if(set.contains(ps[i])) {
				result=1;
				break;
			}else
				set.add(ps[i]);
		}
		if(set.contains((long)0))
			result=1;
		return result;
    }

}
