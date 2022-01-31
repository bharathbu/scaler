/**
 * First Repeating element
 * 
 * Problem Description

Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of first occurrence is smallest.

If there is no repeating element, return -1.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 109



Input Format

First and only argument is an integer array A of size N.



Output Format

Return an integer denoting the first repeating element.



Example Input

Input 1:

 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:

 A = [6, 10, 5, 4, 9, 120]


Example Output

Output 1:

 5
Output 2:

 -1


Example Explanation

Explanation 1:

 5 is the first element that repeats
Explanation 2:

 There is no repeating element, output -1
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class FirstRepeatElementTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);A.add(2);A.add(2);A.add(1);
		System.out.println(solve(A));
	}

	public static int solve(ArrayList<Integer> A) {
		int result=-1;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n = A.size(),curr=0,count=0;
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			count = (map.get(curr)==null ? 0:map.get(curr));
			map.put(curr, (count==0)?1:count+1);
		}
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			if(map.get(curr) > 1) {
				result=curr;
				break;
			}		
		}
		return result;
    }
}
