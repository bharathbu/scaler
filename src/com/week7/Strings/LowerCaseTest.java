/**
 * tolower()
 * 
 * Problem Description

You are given a function to_lower() consisting of a character array A.

Convert each character of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.

Return the lowercase version of the given character array.



Problem Constraints

1 <= |A| <= 105



Input Format

Only argument is a character array A.



Output Format

Return the lowercase version of the given character array.



Example Input

Input 1:

 A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2:

 A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']


Example Output

Output 1:

 ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']
Output 2:

 ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Explanation

Explanation 1:

 All the characters in the returned array are in lower case alphabets.
 * 
 */
package com.week7.Strings;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class LowerCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Character> A = new ArrayList<Character>();
		A.add('A');A.add('b');A.add('0');A.add('Z');A.add('M');A.add('N');A.add('o');A.add('p');
		System.out.println(to_lower(A) );
	}
	
	public static ArrayList<Character> to_lower(ArrayList<Character> A) {
		ArrayList<Character> result = new ArrayList<Character>();
		int n = A.size();
		Character curr = null;
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			if((curr>='A') && (curr<='Z')) {
				curr = (char) (curr^32);
			}
			result.add(curr);
		}
		return result;
    }

}
