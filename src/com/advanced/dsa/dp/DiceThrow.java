/**
 * Dice throw
 *
 * Problem Description
 *
 * Given sum A, number of ways you can get that sum with dice roll[1-6].
 *
 * As the number of ways can be large return its modulo by 1e9 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 10 2
 *
 *
 * Input Format
 *
 * The first argument is the integer A.
 *
 *
 * Output Format
 *
 * Return an integer .
 *
 *
 * Example Input
 *
 * Input 1:
 * A = 3
 * Input 2:
 *
 * A = 4
 *
 *
 * Example Output
 *
 * Output 1:
 * 4
 * Output 2:
 *
 * 8
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The four possible ways to obtain 3 are: [1, 1, 1], [1, 2], [2, 1] and [3].
 *
 *
 *
 *
 * Explanation 2:
 *
 * The eight possible ways to obrain 8 are: [1, 1, 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [1, 3], [3, 1], [2, 2], [4].
 */
package com.advanced.dsa.dp;
/*
Try to find the overlapping and optimal subproblems in the recursion tree of the bruteforce recursive solution.

The problem can be solved using dp as it has overlapping and optimal subproblems.

Lets define dp[N] as the total number of ways you can get that sum with dice roll[1-6] for sum N.

Then the recursive equation is

    dp[N] = ddp[N-1] + dp[N-2] + dp[N-3] + dp[N-4] + dp[N-5] + dp[N-6]
Remenber to do modulo by 1e9+7 after each operations.
 */
public class DiceThrow {
    public int solve(int A) {
        int MOD = (int) (1e9+7);
        long s =0;
        int[] dp = new int[A+1];
        dp[0] = 1;
        for (int i = 1; i <= A ; i++) {
            s=0;
            for (int j = 1; j <= 6 && j<=i ; j++)
                s += dp[i-j];
            dp[i] = (int) (s%MOD);
        }
        return dp[A]%MOD;
    }
}
