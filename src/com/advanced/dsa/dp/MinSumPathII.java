/**
 *  Minimum Falling Path Sum II
 *
 * Problem Description
 *
 * Given a square grid of integers A, a falling path with non-zero shifts is a choice of exactly one element from each row of A, such that no two elements chosen in adjacent rows are in the same column.
 *
 * Return the minimum sum of a falling path with non-zero shifts.
 *
 * Problem Constraints
 *
 * 1 <= |A| == |A[i]| <= 200
 * -99 <= A[i][j] <= 99
 *
 *
 * Input Format
 *
 * First argument is a 2D array of integers.
 *
 * Output Format
 *
 * Return an integer denoting the minimum sum.
 *
 * Example Input
 *
 * Input 1:
 *
 *  A =  [ [1, 2, 3],
 *         [4, 5, 6],
 *         [7, 8, 9] ]
 * Input 2:
 *
 *  A =  [ [17, 14, 19],
 *         [12, 18, 9],
 *         [20, 10, 1] ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  13
 * Output 2:
 *
 *  27
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The possible falling paths are:
 *  [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 *  [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 *  [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 *  The falling path with the smallest sum is [1,5,7], so the answer is 13.
 * Explanation 2:
 *
 *  The possible falling paths are:
 *  The falling path with the smallest sum is [14,12,1], so the answer is 27.
 */
package com.advanced.dsa.dp;

import java.util.ArrayList;
/*
This problem has an optimal substructure, meaning that the solutions to sub-problems can be used to solve larger instances of this.

Let dp[i][j] denotes the minimum sum to reach ith row and jth column from the first row.

dp[i][j] = A[i][j] + min( dp[i-1][k] for all k != j)

We can use the above equetion to fill the dp states.
so, our answer = min(dp[N-1][j] for all j) will be the minimum sum of a falling path with the given condition.

TC=O(N2)
sc=O(2N)
 */
public class MinSumPathII {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] dp = new int[2][n];
        int minVal = Integer.MAX_VALUE;
        int min1 = -1;
        for (int i = 0; i < n; i++)
            dp[0][i] = A.get(0).get(i);

        for (int i = 1; i < n; i++) {
            minVal= Integer.MAX_VALUE;
            for (int j = 0; j < n; j++)
                if(dp[(i-1)%2][j] < minVal){
                    minVal = dp[(i-1)%2][j];
                    min1 = j;
                }
            for (int j = 0; j < n; j++)
                if(j!=min1)
                    dp[i%2][j] = minVal+A.get(i).get(j);

            minVal= Integer.MAX_VALUE;
            for (int j = 0; j < n; j++)
                if(j!=min1 )
                    minVal = Math.min(minVal,dp[(i-1)%2][j]);

            dp[i%2][min1] = minVal+A.get(i).get(min1);

        }
        minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            minVal = Math.min(minVal,dp[n%2][i]);
        return minVal;
    }
}
