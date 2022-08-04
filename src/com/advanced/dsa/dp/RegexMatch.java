/**
 * Regular Expression Match
 *
 * Problem Description
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 *
 * ' ? ' : Matches any single character.
 * ' * ' : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 104
 *
 *
 *
 * Input Format
 * The first argument of input contains a string A.
 * The second argument of input contains a string B.
 *
 *
 *
 * Output Format
 * Return 1 if the patterns match else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aaa"
 *  B = "a*"
 * Input 2:
 *
 *  A = "acz"
 *  B = "a?a"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 *  So, the pattern matches we return 1.
 * Explanation 2:
 *
 *  '?' matches any single character. First two character in string A will be match.
 *  But the last character i.e 'z' != 'a'. Return 0.
 */
package com.advanced.dsa.dp;

import java.util.Arrays;

public class RegexMatch {
    byte[][] dp;
    public int isMatch(final String A, final String B) {
        int n = A.length(),  m = B.length();
        dp = new byte[n][m];
        for (byte[] row: dp)
            Arrays.fill(row, (byte) -1);

        if(regexMatch(A,B,n-1,m-1)) return 1;
        return 0;
    }

    private boolean regexMatch(String s1, String s2, int i, int j) {
        if(i==-1 && j==-1) return true; //Complete match
        if(j==-1) return false; // text is left
        if(i==-1){
            for (int k = 0; k <= j; k++)
                if(s2.charAt(k)!='*') return false;
            return true;
        }
        char pattern = s2.charAt(j);
        if(dp[i][j] == -1){
            if(s1.charAt(i) == pattern || pattern == '?')
                dp[i][j] = (byte) (regexMatch(s1,s2,i-1,j-1)==true?1:0);
            else if(pattern == '*'){
                dp[i][j] = (byte) ((regexMatch(s1,s2,i-1,j) || regexMatch(s1,s2,i,j-1))==true?1:0);
            }
            else dp[i][j] = 0;
        }
        return (dp[i][j]==1?true:false);
    }
}
