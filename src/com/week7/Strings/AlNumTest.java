/**
  * Isalnum()
 * 
 * Problem Description

You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Problem Constraints

1 <= |A| <= 105



Input Format

Only argument is a character array A.



Output Format

Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Example Input

Input 1:

 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:

 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 All the characters are alphanumeric.
Explanation 2:

 All the characters are NOT alphabets i.e ('#').
 */
package com.week7.Strings;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class AlNumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Character> A = new ArrayList<Character>();
		A.add('A');A.add('b');A.add('*');A.add('Z');A.add('M');A.add('N');A.add('o');A.add('p');
		System.out.println(solve(A) );
	}
	
	public static int solve(ArrayList<Character> A) {
		int result = 1;
		int n = A.size();
		Character curr = null;
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			if(!((curr>='a' && curr<='z')|| (curr>='A' && curr<='Z')|| (curr>='0' && curr<='9'))) {
				result = 0;
				break;
			}
		}
		return result;
    }

}
