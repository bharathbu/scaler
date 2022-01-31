/**
 * Find subsequence
 * 
 * Given two strings A and B, find if A is a subsequence of B.

Return "YES" if A is a subsequence of B, else return "NO".


Input Format

The first argument given is the string A.
The second argument given is the string B.
Output Format

Return "YES" if A is a subsequence of B, else return "NO".
Constraints

1 <= lenght(A), length(B) <= 100000
'a' <= A[i], B[i] <= 'z'
For Example

Input 1:
    A = "bit"
    B = "dfbkjijgbbiihbmmt"
Output 1:
    YES

Input 2:
    A = "apple"
    B = "appel"
Output 2:
    "NO"
 */
package com.week12.subsequences;

/**
 * @author Bharath
 *
 */
public class SubsequenceStringsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "apple";
        String str2 = "appel";
        System.out.println(solve(str1,str2));
    }
	
	public static String solve(String A, String B) {
		int m = A.length();
        int n = B.length();
        boolean res = isSubSequence(A, B, m, n);
        if (res)
            return "Yes";
        else
            return "No";
    }

	private static boolean isSubSequence(String a, String b, int m, int n) {
		if (m == 0)
            return true;
        if (n == 0)
            return false;
 
        // If last characters of two strings are matching
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return isSubSequence(a, b, m - 1, n - 1);
 
        // If last characters are not matching
        return isSubSequence(a, b, m, n - 1);
	}

}
