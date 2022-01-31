/**
 * Sum the Difference
 * 
 * Problem Description

Given an integer array A of size N.
You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.



Problem Constraints

1 <= N <= 10000

1<= A[i] <=1000



Input Format

First argument is an integer array A.



Output Format

Return an integer denoting the output.



Example Input

Input 1:

A = [1, 2]
Input 2:

A = [1]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1
Explanation 2:

 Only 1 subsequence of 1 element is formed.
 */
package com.week12.subsequences;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Bharath
 *
 */
public class SumDiffsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(-4);
		A.add(1);
		A.add(3);
		System.out.println(solve(A));
	}

	public static int solve(ArrayList<Integer> A) {
		int n=A.size();
        long mod=1000000007,max=0,min=0;
		Collections.sort(A);
		
		for(int i=0;i<n;i++) {
			max += (A.get(i)*1l*Math.pow(2, i))%mod;
			max %= mod;
		}
		for(int i=0;i<n;i++) {
			min += (A.get(i)*1l*Math.pow(2, n-i-1))%mod;
			min %= mod;
		}
		
		return (int) ((max-min+mod)%mod);
	}


}
