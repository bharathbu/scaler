/**
 * Colorful Number
 * 
 * Problem Description

For Given Number A find if its COLORFUL number or not.

If number A is a COLORFUL number return 1 else return 0.

What is a COLORFUL Number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.


Problem Constraints

1 <= A <= 2 * 109



Input Format

Single Argument which denotes integer A.



Output Format

Return 1 if integer A is COLORFUL else return 0.



Example Input

Input 1:

 A = 23
Input 2:

 A = 236


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Possible Sub-sequences: [2, 3, 23] where
 2 -> 2 
 3 -> 3
 23 -> 6  (product of digits)
 This number is a COLORFUL number since product of every digit of a sub-sequence are different. 
Explanation 2:

 Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 2 -> 2 
 3 -> 3
 6 -> 6
 23 -> 6  (product of digits)
 36 -> 18  (product of digits)
 236 -> 36  (product of digits)
 This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same. 
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
public class ColorfulNumberTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(colorful(246));

	}
	
	public static int colorful(int A) {
		// To store the given number
	    // as a string
	    String s = "";
	 
	    // Append all the digits
	    // starting from the end
	    while (A > 0)
	    {
	        s += (char)(A % 10 + '0');
	        A /= 10;
	    }
	 
	    // Reverse the string to get
	    // the original number
	    s = reverse(s);
	 
	    // Store size of the string
	    int sz = s.length();
	 
	    // Set to store product of
	    // each contiguous subsequence
	    HashSet<Integer> se = new HashSet<Integer>();
	 
	    // Find product of every
	    // contiguous subsequence
	    for (int i = 0; i < sz; i++)
	    {
	        int product = 1;
	        for (int j = i; j < sz; j++)
	        {
	            product *= (int)(s.charAt(j) - '0');
	 
	            // If current product already
	            // exists in the set
	            if (se.contains(product))
	                return 0;
	            else
	                se.add(product);
	        }
	    }
	    return 1;
    }
	 
	static String reverse(String input)
	{
	    char[] a = input.toCharArray();
	    int l, r;
	    r = a.length - 1;
	    for (l = 0; l < r; l++, r--)
	    {
	        // Swap values of l and r
	        char temp = a[l];
	        a[l] = a[r];
	        a[r] = temp;
	    }
	    return String.valueOf(a);
	}

}
