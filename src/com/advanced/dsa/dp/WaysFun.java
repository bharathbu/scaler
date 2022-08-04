/**
 * Ways to have fun
 *
 * Problem Description
 *
 * Find the number of ways you can have fun in A days, given you can sleep every day, Pizza can be eaten every alternate day and you can watch Tv shows every two days.
 *
 * Since the answer could be large, return answer % 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer A denoting the number of days.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the number of ways you can have fun in A days.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  15
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  There will be 7 ways to have fun:
 *  (SS), (SP), (ST), (PS), (PT), (TS), (TP).
 * Explanation 2:
 *
 *  There will be 15 ways to have fun.
 */
package com.advanced.dsa.dp;

public class WaysFun {
    public int solve(int A) {
        /*
            dp[i][0] = number of ways when you can have fun by sleeping today
            dp[i][1] = number of ways when you can have fun by eating pizza today
            dp[i][2] = number of ways when you can have fun by watching TV shows today
         */
        long[][] dp = new long[A+1][3];
        int MOD = (int) (1e9+7);

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= A; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) %MOD; // can sleep everyday
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] - 2*dp[i-2][2] +MOD)%MOD;
        }
        int res = (int) ((dp[A][0] + dp[A][1] + dp[A][2]) %MOD);
        return res;
    }
}
