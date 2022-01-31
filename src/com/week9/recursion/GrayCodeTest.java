/**
 * Gray Code
 * 
 * Problem Description

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



Problem Constraints

1 <= A <= 16



Input Format

First argument is an integer A.



Output Format

Return an array of integers representing the gray code sequence.



Example Input

Input 1:

A = 2
Input 1:

A = 1


Example Output

output 1:

[0, 1, 3, 2]
output 2:

[0, 1]


Example Explanation

Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].
 */
package com.week9.recursion;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class GrayCodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(grayCode(10));

	}

	public static ArrayList<Integer> grayCode(int a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Base case
		if(a<=0) {
			ArrayList<Integer> temp = new ArrayList<Integer>() {{add(0);}};
			return temp;
		}
		if(a==1) {
			ArrayList<Integer> temp = new ArrayList<Integer>() {{add(0);add(1);}};
			return temp;
		}
		
		//Recursion
		ArrayList<Integer> recSol = grayCode(a-1);
		int n = recSol.size(),curr;
		for(int i=0;i<n;i++) {
			curr = recSol.get(i);
			result.add(curr);
			
		}
		for(int i=n-1;i>=0;i--) {
			curr = recSol.get(i);
			curr = curr | (1<<a-1);
			result.add(curr);	
		}
		
		return result;
		
	}
	
}
