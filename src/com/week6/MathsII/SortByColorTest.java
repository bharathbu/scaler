/**
 * Sort by Color
 * 
 * Problem Description

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.



Problem Constraints

1 <= N <= 1000000
0 <= A[i] <= 2


Input Format

First and only argument of input contains an integer array A.


Output Format

Return an integer array in asked order


Example Input

Input 1 :
    A = [0 1 2 0 1 2]
Input 2:

    A = [0]


Example Output

Output 1:
    [0 0 1 1 2 2]
Output 2:

    [0]


Example Explanation

Explanation 1:
    [0 0 1 1 2 2] is the required order.
 * 
 */
package com.week6.MathsII;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class SortByColorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(0);
		A.add(0);
		A.add(0);
		A = sortColors(A);
		System.out.print(A);
	}

	public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int n = A.size(),count0=0,count1=0,count2=0,temp=-1;
		for(int i=0;i<n;i++) {
			temp=A.get(i);
			if(temp==0)
				count0++;
			else if(temp == 1)
				count1++;
			else
				count2++;
		}
		
		while(count0 > 0) {
			result.add(0);
			count0--;
		}
		while(count1 > 0) {
			result.add(1);
			count1--;
		}
		while(count2 > 0) {
			result.add(2);
			count2--;
		}
		
		return result;
    }
}
