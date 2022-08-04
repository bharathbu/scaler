package com.advanced.dsa.dp;

import java.util.ArrayList;

public class UnboundedKnapsack {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int n = B.size();

        int[][] dp = new int[2][A+1];

        for (int i = 0; i <=A ; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= A ; j++) {
                int a = dp[(i-1)%2][j];
                if(j >= C.get(i-1))
                    a = Math.max(a,dp[(i)%2][j-C.get(i-1)] + B.get(i-1));
                dp[i%2][j] = a;
            }
        }
        return dp[n%2][A];
    }
}
