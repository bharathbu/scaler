/**
 * Count A
 *
 * Problem Description
 * You are given a string A. Find the number of substrings that start and end with 'a'.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 * The string will have only lowercase English letters.
 *
 *
 *
 * Input Format
 * Given the only argument is a String A.
 *
 *
 *
 * Output Format
 * Return number of substrings that start and end with 'a'.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aab"
 * Input 2:
 *
 *  A = "bcbc"
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Substrings that start and end with 'a' are:
 *     1. "a"
 *     2. "aa"
 *     3. "a"
 * Explanation 2:
 *
 *  There are no substrings that start and end with 'a'.
 */
package com.advanced.dsa.patternmatching;

public class CountA {

    /*
    You need to look for an optimal way for finding the number of substrings in a string that starts and ends with ‘a’.

    Count the number of a’s, let that number be N.

    Then the number of substrings that start and end with ‘a’ will be (N * (N + 1)) / 2.
     */
    public static void main(String[] args){
        System.out.println(solve("abaaabac"));
    }
    public static int solve(String A) {
        int[] alpha = new int[26];
        int n=A.length(),result=0;

        for (int i = 0; i < n; i++)
            alpha[A.charAt(i)-'a']++;
        if(alpha[0] == 0)
            return 0;
        result=(alpha[0]*(alpha[0]+1))/2;

        return result;
    }

}
