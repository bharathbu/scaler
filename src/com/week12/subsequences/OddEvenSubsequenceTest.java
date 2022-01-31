/**
 * Odd Even Subsequences
 * 
 * Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.

A subsequence is said to odd-even in the following cases:

The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]

The first element of the subsequence is even, second element is odd, third element is even and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]

Return the maximum possible length of odd-even subsequence.

Note: An array B is a subsequence of an array A if B can be obtained from A by deletion of several (possibly, zero or all) elements.


Input Format

The only argument given is the integer array A.
Output Format

Return the maximum possible length of odd-even subsequence.
Constraints

1 <= N <= 100000
1 <= A[i] <= 10^9 
For Example

Input 1:
    A = [1, 2, 2, 5, 6]
Output 1:
    4
    Explanation 1:
        Maximum length odd even subsequence is [1, 2, 5, 6]

Input 2:
    A = [2, 2, 2, 2, 2, 2]
Output 2:
    1
    Explanation 2:
        Maximum length odd even subsequence is [2]
 */
package com.week12.subsequences;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class OddEvenSubsequenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(12);
		A.add(1);
		A.add(20);
		A.add(13);
		A.add(1);
		A.add(4);
		A.add(5);
		System.out.println(solve(A));
	}

	public static int solve(ArrayList<Integer> A) {
		int n=A.size(),temp;
		boolean flag = true;
		ArrayList<Integer> B = new ArrayList<Integer>();
		if(A.get(0)%2==0) flag=false;
		for(int i=0;i<n;i++) {
			temp = A.get(i);
			if(temp%2==1 && flag) {
				B.add(temp);
				flag=false;
			}else if(temp%2==0 && !flag) {
				B.add(temp);
				flag=true;
			}
		}
		return B.size();
    }
	
	
}
