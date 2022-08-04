/**
 * Edit Distance
 *
 * Problem Description
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 450
 *
 *
 *
 * Input Format
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 *
 *
 *
 * Output Format
 * Return an integer, representing the minimum number of steps required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abad"
 *  B = "abac"
 * Input 2:
 *
 *  A = "Anshuman"
 *  B = "Antihuman
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Exlanation 1:
 *
 *  A = "abad" and B = "abac"
 *  After applying operation: Replace d with c. We get A = B.
 *
 * Explanation 2:
 *
 *  A = "Anshuman" and B = "Antihuman"
 *  After applying operations: Replace s with t and insert i before h. We get A = B.
 */
package com.advanced.dsa.dp;

import java.util.Arrays;

public class EditDistance {
    int[][] dp;
    public int minDistance(String A, String B) {
        int n = A.length(),  m = B.length();
        dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return editDistance(A,B,n-1,m-1);
    }

    private int editDistance(String s1, String s2, int i, int j) {
        if(i==-1 && j==-1)
            return 0;
        if(i == -1) return j+1;
        if(j == -1) return i+1;

        if(dp[i][j] == -1){
            if(s1.charAt(i) == s2.charAt(j))
                dp[i][j] = editDistance(s1,s2,i-1,j-1);
            else{
                dp[i][j] = 1+Math.min(Math.min(editDistance(s1,s2,i,j-1), editDistance(s1,s2,i-1,j)),editDistance(s1,s2,i-1,j-1));
            }
        }
        return dp[i][j];
    }
}
