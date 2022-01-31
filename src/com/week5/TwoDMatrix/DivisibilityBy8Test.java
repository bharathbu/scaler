/**
 * Divisibility by 8
 * 
 * Given a number A in the form of string. Check if the number is divisible by 8 or not.

	Return 1 if it is divisible by 8 else return 0.
	
	
	Input Format
	
	The only argument given is string A.
	Output Format
	
	Return 1 if it is divisible by 8 else return 0.
	
	Constraints
	
	1 <= length of the String <= 100000
	'0' <= A[i] <= '9'
	For Example
	
	Input 1:
	    A = "16"
	Output 1:
	    1
	
	Input 2:
	    A = "123"
	Output 2:
	    0
	    
***** Divisibility rules:
*Divisibility Rule of 8
If the last three digits of a number are divisible by 8, then the number is completely divisible by 8.

Example: Take number 24344. Consider the last three digits i.e.  344. As 344 is divisible by 8, the original number 24344 is also divisible by 8.

Divisibility Rule of 9
The rule for divisibility by 9 is similar to divisibility rule for 3. That is, if the sum of digits of the number is divisible by 9, then the number itself is divisible by 9.

Example: Consider 78532, as the sum of its digits (7+8+5+3+2) is 25, which is not divisible by 9, hence 78532 is not divisible by 9.

Divisibility Rule of 10
Divisibility rule for 10 states that any number whose last digit is 0, is divisible by 10.

Example: 10, 20, 30, 1000, 5000, 60000, etc.

Divisibility Rules for 11
If the difference of the sum of alternative digits of a number is divisible by 11, then that number is divisible by 11 completely.

In order to check whether a number like 2143 is divisible by 11, below is the following procedure.

Group the alternative digits i.e. digits which are in odd places together and digits in even places together. Here 24 and 13 are two groups.
Take the sum of the digits of each group i.e. 2+4=6 and 1+3= 4
Now find the difference of the sums; 6-4=2
If the difference is divisible by 11, then the original number is also divisible by 11. Here 2 is the difference which is not divisible by 11.
Therefore, 2143 is not divisible by 11.	    
 * 
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class DivisibilityBy8Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve("8"));

	}
	
	public static int solve(String A) {
		int result=-1,n=A.length();
		String last3 = A;
		if(n>3) {
			last3 = A.substring(n-3);
		}
		int num = Integer.parseInt(last3);
		result = num%8;
		return ( (result==0) ? 1: 0);
    }

}
