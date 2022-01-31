/**
 * Is Dictionary?
 * 
 * Problem Description

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.



Problem Constraints

1 <= N, length of each word <= 105

Sum of length of all words <= 2 * 106



Input Format

First argument is a string array A of size N.

Second argument is a string B of size 26 denoting the order.



Output Format

Return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.



Example Input

Input 1:

 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:

 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 The order shown in string B is: h < s < i for the given words. So return 1.
Explanation 2:

 "none" should be present after "no". Return 0.
 */
package com.week7.Strings;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class IsDictionaryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<String>();
		A.add("hello");
		A.add("scaler");
		A.add("anterviewbit");
		String B = "adhbcfegskjlponmirqtxwuvzy";
		System.out.println(solve(A,B));

	}

	public static int solve(ArrayList<String> A, String B) {
		int[] orderMap = new int[26];
		for (int i = 0; i < B.length(); i++) {
			orderMap[B.charAt(i) - 'a'] = i;
		}
		int n = A.size();
		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n; j++) {
				// If we do not find a mismatch letter between words[i] and words[i + 1],
				// we need to examine the case when words are like ("apple", "app").
				if (j >= A.get(i+1).length())
					return 0;

				if (A.get(i).charAt(j) != A.get(i + 1).charAt(j)) {
					int currentWordChar = A.get(i).charAt(j) - 'a';
					int nextWordChar = A.get(i + 1).charAt(j) - 'a';
					if (orderMap[currentWordChar] > orderMap[nextWordChar])
						return 0;
					// if we find the first different letter and they are sorted,
					// then there's no need to check remaining letters
					else
						break;
				}
			}
		}

		return 1;
	}
}
