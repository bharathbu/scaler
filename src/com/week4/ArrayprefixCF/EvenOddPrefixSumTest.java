/**
 * Count ways to make sum of odd and even indexed elements equal by removing an array element
 * 
 * Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints

1<=n<=1e5
-1e5<=A[i]<=1e5


Input Format

First argument contains an array A of integers of size N


Output Format

Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input

Input 1:
A=[2, 1, 6, 4]
Input 2:

A=[1, 1, 1]


Example Output

Output 1:
1
Output 2:

3


Example Explanation

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 
Explanation 2:

 Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.

 */
package com.week4.ArrayprefixCF;

/**
 * @author Bharath
 *
 */
public class EvenOddPrefixSumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 2, 1, 6, 4 };
		System.out.println(solve(A));

	}
	
	public static int solve(int[] A) {
		
		int result=0, n=A.length,Se=0,So=0;
		int[] PSe = new int[n];
		int[] PSo = new int[n];
		
		PSe[0]=A[0];
		for(int i=1;i<n;i++) {
			if(i%2 == 0) {
				PSe[i] = PSe[i-1]+A[i];
			}else {
				PSe[i] = PSe[i-1];
			}			
		}
		PSo[0]=0;
		for(int i=1;i<n;i++) {
			if(i%2 == 1) {
				PSo[i] = PSo[i-1]+A[i];
			}else {
				PSo[i] = PSo[i-1];
			}	
		}
		
		for(int i=0; i<n; i++) {
			if(i>0) {
				Se = PSe[i-1] + PSo[n-1]-PSo[i];
				So = PSo[i-1] + PSe[n-1]-PSe[i];
			}else {
				Se = PSo[n-1]-PSo[i];
				So = PSe[n-1]-PSe[i];
			}
			if(Se == So) {
				result++;
			}
			
		}
		return result;
    }

}
