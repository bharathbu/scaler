/**
 * Find nth Magic Number
 * 
 * Problem Description

Given an integer A, find and return the Ath magic number.

A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….



Problem Constraints

1 <= A <= 5000



Input Format

The only argument given is integer A.



Output Format

Return the Ath magic number.



Example Input

Example Input 1:

 A = 3
Example Input 2:

 A = 10


Example Output

Example Output 1:

 30
Example Output 2:

 650


Example Explanation

Explanation 1:

 A in increasing order is [5, 25, 30, 125, 130, ...]
 3rd element in this is 30
Explanation 2:

 In the sequence shown in explanation 1, 10th element will be 650.
 * 
 */
package com.week6.MathsII;

/**
 * @author Bharath
 *
 */
public class NthMagicNumberTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve(10));

	}
	
	public static int solve(int A) {
		/*
		 * If we notice carefully the magic numbers can be represented as 001, 010, 011, 100, 101, 110 etc, where 001 is 0*pow(5,3) + 0*pow(5,2) + 1*pow(5,1). 
		 * So basically we need to add powers of 5 for each bit set in given integer n. 
		 * Below is the implementation based on this idea. 
		 */
		int result=0,n=A;
		int pow=1;
		while(n>0) {
			pow=pow*5;
			if((n&1) == 1) {
				result += pow;
			}
			n= n>>1;
		}
		return result;
    }

}
