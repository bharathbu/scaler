/**
 * Min Sum Path in Matrix
 *
 * Problem Description
 * Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Return the minimum sum of the path.
 *
 * NOTE: You can only move either down or right at any point in time.
 *
 *
 *
 * Problem Constraints
 * 1 <= M, N <= 2000
 *
 * -1000 <= A[i][j] <= 1000
 *
 *
 *
 * Input Format
 * First and only argument is a 2-D grid A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum sum of the path.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [1, 3, 2]
 *        [4, 3, 1]
 *        [5, 6, 1]
 *      ]
 * Input 2:
 *
 *  A = [
 *        [1, -3, 2]
 *        [2, 5, 10]
 *        [5, -5, 1]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  8
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The path will be: 1 -> 3 -> 2 -> 1 -> 1.
 * Input 2:
 *
 *  The path will be: 1 -> -3 -> 5 -> -5 -> 1.
 */
package com.advanced.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPath {
/*
Let DP[i][j] store the minimum sum of numbers along the path from top left to (i,j). where 0<=i<=n-1 and 0<=j<=m-1.

Basically, DP[i][j] = A[i][j] + min(DP[i-1][j],DP[i][j-1]).

You only need to figure out the base conditions and boundary conditions now.

The answer to the problem would be simply Dp[n-1][m-1]. where n is the no. of rows and m is the no. of columns.
 */
    int[][] dp;
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m= A.get(0).size();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0] = A.get(0).get(0);
        return minSum(n-1,m-1,A);
    }

    private int minSum(int i, int j, ArrayList<ArrayList<Integer>> mat) {
        if(i<0 || j<0)
            return Integer.MAX_VALUE;
        Integer dpVal = dp[i][j];
        if(dpVal != Integer.MAX_VALUE)
            return dpVal;

        int down = minSum(i-1,j,mat);
        int right = minSum(i,j-1,mat);

        dpVal = mat.get(i).get(j) + Math.min(down,right);
        dp[i][j] = dpVal;
        return dp[i][j];
    }


}
