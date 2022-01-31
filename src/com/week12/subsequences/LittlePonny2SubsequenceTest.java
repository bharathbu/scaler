/**
 * Little Ponny and 2-Subsequence
 * 
 * Problem Description

Little Ponny is given a string A and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?

A string a is lexicographically smaller than a string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".

 



Problem Constraints

1 <= |A| <= 105

A only contains lowercase alphabets.



Input Format

The first and the only argument of input contains the string, A.



Output Format

Return a string representing the answer.



Example Input

Input 1:

 A = "abcdsfhjagj" 
Input 2:

 A = "ksdjgha" 


Example Output

Output 1:

 "aa" 
Output 2:

 "da" 


Example Explanation

Explanation 1:

 "aa" is the lexicographically minimum subsequence from A. 
Explanation 2:

 "da" is the lexicographically minimum subsequence from A. 
 */
package com.week12.subsequences;

import java.util.Stack;

/**
 * @author Bharath
 *
 */
public class LittlePonny2SubsequenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String A = "abcdsfhjagj" ;
		System.out.println(solve(A));
	}

	public static String solve(String A) {
		// Length of String
		int N = A.length(), K = 2;

		// Stores the minimum subsequence
		Stack<Character> answer = new Stack<>();

		// Traverse the String S
		for (int i = 0; i < N; ++i) {

			// If the stack is empty
			if (answer.isEmpty()) {
				answer.add(A.charAt(i));
			} else {

				// Iterate till the current
				// character is less than the
				// the character at the top of stack
				while ((!answer.isEmpty()) && (A.charAt(i) < answer.peek())

				// Check if there are enough
				// characters remaining
				// to obtain length K
						&& (answer.size() - 1 + N - i >= K)) {
					answer.pop();
				}

				// If stack size is < K
				if (answer.isEmpty() || answer.size() < K) {

					// Push the current
					// character into it
					answer.add(A.charAt(i));
				}
			}
		}

		// Stores the resultant String
		StringBuilder ret = new StringBuilder();
		// Iterate until stack is empty
		while (!answer.isEmpty()) {
			ret.append(answer.peek());
			answer.pop();
		}

		// Reverse the String
		ret.reverse();

		return ret.toString();
	}

}
