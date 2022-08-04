/**
 * Longest Common Subsequence
 *
 * Problem Description
 * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
 *
 * You need to return the length of such longest common subsequence.
 *
 *
 *
 * Problem Constraints
 * 1 <= Length of A, B <= 1005
 *
 *
 *
 * Input Format
 * First argument is a string A.
 * Second argument is a string B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest common subsequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abbcdgf"
 *  B = "bbadcgf"
 * Input 2:
 *
 *  A = "aaaaaa"
 *  B = "ababab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest common subsequence is "bbcgf", which has a length of 5.
 * Explanation 2:
 *
 *  The longest common subsequence is "aaa", which has a length of 3.
 */
package com.advanced.dsa.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    int[][] dp;
    public int solve(String A, String B) {
        int n = A.length(),  m = B.length();
        dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return lcs(A,B,n-1,m-1);

    }

    private int lcs(String s1, String s2, int i, int j) {
        if(i==-1 || j==-1)
            return 0;
        if(dp[i][j] == -1){
            if(s1.charAt(i) == s2.charAt(j))
                dp[i][j] = 1 + lcs(s1,s2,i-1,j-1);
            else{
                dp[i][j] = Math.max(lcs(s1,s2,i,j-1),lcs(s1,s2,i-1,j));
            }
        }
        return dp[i][j];
    }
}
