/**
 * Leap year?
 * 
 * Problem Description

Given an integer A representing an year, Return 1 if it is a leap year else return 0.

A year is leap year if the following conditions are satisfied:

Year is multiple of 400.
Year is multiple of 4 and not multiple of 100.


Problem Constraints

1 <= A <= 109



Input Format

First and only argument is an integer A



Output Format

Return 1 if it is a leap year else return 0



Example Input

Input 1

 A = 2020
Input 2:

 A = 1999


Example Output

Output 1

 1
Output 2:

 0


Example Explanation

Explanation 1

 2020 is a leap year.
Explanation 2:

 1999 is not a leap year.
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class LeapYearTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve(2020));

	}
	
	public static int solve(int A) {
		int result=0;
		if(A%400 == 0 || (A%4 ==0 && A%100 !=0))
			result=1;
		return result;
    }
	

}
