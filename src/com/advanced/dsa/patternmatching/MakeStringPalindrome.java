/**
 * Make String Palindrome
 *
 * Problem Description
 * Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.
 *
 * Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 *
 *
 * Input Format
 * The only argument given is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abc"
 * Input 2:
 *
 *  A = "bb"
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Insert 'b' at beginning, string becomes: "babc".
 *  Insert 'c' at beginning, string becomes: "cbabc".
 * Explanation 2:
 *
 *  There is no need to insert any character at the beginning as the string is already a palindrome.
 */
package com.advanced.dsa.patternmatching;

public class MakeStringPalindrome {

    public static void main(String[] args){
        System.out.println(solve("abbaacd"));
    }
    public static int solve(String A) {
        int sizeA = A.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder revA = new StringBuilder();
        revA.append(A);
        sb.append(A).append('$').append(revA.reverse());
        int[] lps = LPS.constructLPS(sb.toString());
        return sizeA-lps[lps.length-1];
    }
}
