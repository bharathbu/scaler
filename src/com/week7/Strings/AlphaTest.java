/**
 * Isalpha()
 * 
 * Problem Description

You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.



Problem Constraints

1 <= |A| <= 105



Input Format

Only argument is a character array A.



Output Format

Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.



Example Input

Input 1:

 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y']
Input 2:

 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 All the characters are alphabets.
Explanation 2:

 All the characters are NOT alphabets i.e ('#', '2', '0', '2', '0').
 * 
 */
package com.week7.Strings;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class AlphaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Character> A = new ArrayList<Character>();
		A.add('A');A.add('b');A.add('g');A.add('Z');A.add('M');A.add('N');A.add('0');A.add('p');
		System.out.println(solve(A) );
	}
	
	public static int solve(ArrayList<Character> A) {
		int result = 1;
		int n = A.size();
		Character curr = null;
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			if(!((curr>='a' && curr<='z')|| (curr>='A' && curr<='Z'))) {
				result = 0;
				break;
			}
		}
		return result;
    }

}
