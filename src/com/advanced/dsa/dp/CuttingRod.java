/**
 * Cutting a Rod
 *
 * Problem Description
 * Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
 *
 * Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 0 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 4, 1, 6, 2]
 * Input 2:
 *
 *  A = [1, 5, 2, 5, 6]
 *
 *
 * Example Output
 * Output 1:
 *
 *  15
 * Output 2:
 *
 *  11
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
 * Explanation 2:
 *
 *  Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
 */
package com.advanced.dsa.dp;

import java.util.ArrayList;

/*
For the naive solution, We can get the best price by making a cut at different positions and comparing the values obtained after a cut.
We can recursively call the same function for a piece obtained after a cut.

Let’s optimize it.

Consider val[i] denotes the maximum price we can get by selling the rod (can sell by cutting any how) of length i.
->for all j from 0 to i-1, val[i] = max(val[i],A[j] + val[i-j-1]).

val[n] will be the output.

This is bottom up approach
 */
public class CuttingRod {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] dp = new int[n+1];
        dp[0]=0;

        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                maxVal = Math.max(maxVal,A.get(j)+dp[i-j-1]);
            dp[i] = maxVal;
        }
        return dp[n];
    }
}
