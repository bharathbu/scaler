/**
 * Check Palindrome!
 * 
 * Problem Description

Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.

Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Problem Constraints

1 <= |A| <= 105

A consists only of lower-case characters.



Input Format

First argument is an string A.



Output Format

Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Example Input

Input 1:

 A = "abcde"
Input 2:

 A = "abbaee"


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 No possible rearrangement to make the string palindrome.
Explanation 2:

 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */
package com.week8.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class CheckPalindromeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve("yzfbzbyyrurquqf"));
	}
	
	public static int solve(String A) {
		int result = 1,oddCount=0,n=A.length();
		int[] frequency = new int[26];
		for(int i=0;i<n;i++) {
			frequency[A.charAt(i)-'a']++;
		}
		for (int i : frequency) {
			if(i%2 == 1)
				oddCount++;
		}
		if(oddCount >1)
			result=0;
		/*Map<Character, Integer> map = new HashMap<Character, Integer>();
		Character c = '\0';
		Integer count = null;
		for(int i=0;i<n;i++) {
			c = A.charAt(i);
			count = map.get(c);
			map.put(c, (count==null)?1:++count);
		}
		for (java.util.Map.Entry<Character, Integer> entry : map.entrySet()) {
			count = entry.getValue();
			if(count%2 == 1)
				oddCount++;
		}
		if(oddCount >1)
			result=0;*/
		return result;
    }

}
