/**
 * Count Occurrences
 * 
 * Problem Description

Find number of occurrences of bob in the string A consisting of lowercase english alphabets.



Problem Constraints

1 <= |A| <= 1000


Input Format

The first and only argument contains the string A consisting of lowercase english alphabets.


Output Format

Return an integer containing the answer.


Example Input

Input 1:

  "abobc"
Input 2:

  "bobob"


Example Output

Output 1:

  1
Output 2:

  2


Example Explanation

Explanation 1:

  The only occurrence is at second position.
Explanation 2:

  Bob occurs at first and third position.
 */
package com.week7.Strings;

/**
 * @author Bharath
 *
 */
public class CountOccurancesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String A = "bbob";
		System.out.println(solve(A));
	}
	
	public static int solve(String A) {
		int result=0,n=A.length();
		char a,b,c;
		if(n>=3) {
			for(int i=0;i<n-2;i++) {
				a=A.charAt(i);
				b=A.charAt(i+1);
				c=A.charAt(i+2);
				if(a=='b' && b=='o' && c=='b') {
					result++;
					i++;
				}
			}
		}
		return result;
    }

}
