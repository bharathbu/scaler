/**
 *  Longest Increasing Subsequence
 *
 * Problem Description
 * Find the longest increasing subsequence of a given array of integers, A.
 *
 * In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
 *
 * In this case, return the length of the longest increasing subsequence.
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A) <= 2500
 * 0 <= A[i] <= 2500
 *
 *
 *
 * Input Format
 * The first and the only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer representing the length of the longest increasing subsequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 1, 5]
 * Input 2:
 *
 *  A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest increasing subsequence: [1, 2, 5]
 * Explanation 2:
 *
 *  The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
package com.advanced.dsa.dp;

import java.util.List;

/*
Let dp[i] denotes the length of longest increasing subsequence ending at index i with first i elements.

How can we calculate dp[i], if we know dp[j] for all j < i ?

Just run a loop for 0<=j<=i-1, if A[j] < A[i] Update dp[i] = max(dp[i], 1 + dp[j]).

Fill all the dp states. Time complexity will be O(N2) as we are running two loops one for i and one for j.

Final answer = max(dp[i] for all i from 1 to N).

Bonus: Try to solve in NlogN time complexity.
 */
public class LongestIncreasingSubseq {
    public int lis(final List<Integer> A) {
        int n = A.size();
        int[] dp = new int[n];
        dp[0] = 1;
        int v =0, ans = -1;
        for (int i = 1; i < n; i++) {
            v = 0;
            for (int j = 0; j < i; j++) {
                if(A.get(j) < A.get(i))
                    v = Math.max(v,dp[j]);
            }
            dp[i] = v+1;
        }
        for (int i = 0; i < n; i++) {
            if(dp[i] > ans)
                ans = dp[i];
        }
        return ans;
    }
}
