/**
 * Change character
 * 
 * Problem Description

Given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints

1 <= N <= 100000

0 <= B < N



Input Format

First argument is a string A.

Second argument is an integer B.



Output Format

Return an integer denoting the minimum number of distinct characters in the string.



Example Input

A = "abcabbccd"
B = 3



Example Output

2



Example Explanation

We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */
package com.week7.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bharath
 *
 */
public class ChangeCharacterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String A = "abcabbccd";
		String A = "qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmq";
		int B = 119;
		System.out.println(solve(A,B));
	}
	
	public static int solve(String A, int B) {
		int n=A.length(),maxFreq=Integer.MIN_VALUE,minFreq=Integer.MAX_VALUE,ans=0;
		int[] alpha = new int[26];
		char temp=0;
		
		// Count the frequency of each alphabet
		for(int i=0;i<n;i++) {
			temp = A.charAt(i);
			alpha[temp-'a']++;
			if(alpha[temp-'a'] == 1)
				ans++;
		}
		Arrays.sort(alpha);

		//check from least frequency alphabets and replace the character
		for(int i=0;i<26;i++) {
			if(B-alpha[i] >=0 && alpha[i] != 0) {
				ans--;
				B -= alpha[i];
			}
			
		}
		
			return ans;
    }

}
