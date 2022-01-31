/**
 * Longest Consecutive Sequence
 * 
 * Problem Description

Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from the array A.



Problem Constraints

1 <= N <= 106

-106 <= A[i] <= 106



Input Format

First argument is an integer array A of size N.



Output Format

Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input

Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output

Output 1:

 4
Output 2:

 2


Example Explanation

Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bharath
 *
 */
public class LongestContinuousSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		A.add(1);A.add(2);A.add(-3);A.add(3);
		//A.add(-19);A.add(8);A.add(2);A.add(-8); A.add(19);A.add(5);A.add(-2);A.add(-23);
		//A.add(0);A.add(19);A.add(18);A.add(-8); A.add(59);A.add(-9);A.add(-72);A.add(52);A.add(-2);A.add(23);A.add(92);
		System.out.println(longestConsecutive(A));

	}
	
	public static int longestConsecutive(final List<Integer> A) {
		int ans = 0,result = 0,n = A.size(),curr;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			set.add(A.get(i));
		}
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			if(!set.contains(curr-1)) {
				ans=0;
				while(set.contains(curr)) {
					ans++;
					curr++;
				}
			}
			result = (ans>result)? ans:result;
		}
		return result;
		
    }

}
