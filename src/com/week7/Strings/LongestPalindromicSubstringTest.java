/**
 * Longest Palindromic Substring
 * 
 * Problem Description

Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints

1 <= N <= 10000



Input Format

First and only argument is a string A.



Output Format

Return a string denoting the longest palindromic substring of string A.



Example Input

A = "aaaabaaa"


Example Output

"aaabaaa"


Example Explanation

We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 * 
 */
package com.week7.Strings;

/**
 * @author Bharath
 *
 */
public class LongestPalindromicSubstringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String A = "asfdefc";
		System.out.println(longestPalindrome(A) );
	}
	
	public static String longestPalindrome(String A) {
		StringBuilder sb = new StringBuilder();
		int n= A.length(),longLength=0,ci=-1,cj=-1;
		int[] result1 = new int[2];
		int[] result2 = new int[2];
		for(int i=0;i<n;i++) {
			result1 = expend(A,i,i);
			result2 = expend(A,i,i+1);
			if((result1[1]-result1[0]+1 > result2[1]-result2[0]+1) && (result1[1]-result1[0]+1 >longLength)) {
				ci = result1[0];
				cj = result1[1];
				longLength = cj-ci+1;
				
			}else if((result2[1]-result2[0]+1 > result1[1]-result1[0]+1) && (result2[1]-result2[0]+1 >longLength)) {
				ci = result2[0];
				cj = result2[1];
				longLength = cj-ci+1;;
			}
		}
		for(int i=ci;i<=cj;i++) {
			sb.append(A.charAt(i));
		}
		return sb.toString();
    }
	
	public static int[] expend(String s, int ci, int cj) {
		int n=s.length(),i=ci,j=cj;
		while(i>=0 && j<n && s.charAt(i)==s.charAt(j)) {
			i--;j++;
		}
		return new int[] {i+1,j-1};
	}

}
