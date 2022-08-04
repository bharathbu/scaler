/**
 * Coin Sum Infinite
 *
 * Problem Description
 * You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
 *
 * NOTE:
 *
 * Coins in set A will be unique. Expected space complexity of this problem is O(B).
 * The answer can overflow. So, return the answer % (106 + 7).
 *
 *
 * Problem Constraints
 * 1 <= A <= 500
 * 1 <= A[i] <= 1000
 * 1 <= B <= 50000
 *
 *
 *
 * Input Format
 * First argument is an integer array A representing the set.
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of ways.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 *  B = 4
 * Input 2:
 *
 *  A = [10]
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The 4 possible ways are:
 *  {1, 1, 1, 1}
 *  {1, 1, 2}
 *  {2, 2}
 *  {1, 3}
 * Explanation 2:
 *
 *  There is only 1 way to make sum 10.
 */
package com.advanced.dsa.dp;

import java.util.ArrayList;
/*
We can approach the problem by dividing the problem into smaller subproblems. We can break this into 2 parts for a particular coin:

we use this coin.
we do not use this coin.
Think of using Dynamic Programming.

Let’s suppose dp[i] denotes the number of ways to make sum i.

Assume we have calculated all the value of dp[k] for k < i.
To calculate dp[i], if the coin we are considering is A[j] then the number of ways is simply is dp[i-A[j]].

Base Case: dp[0] = 1 as sum 0 can be made without taking any coins.

Algorithm:

Run a loop on the coins
    For each coin c_i, loop over all sum s_j from 0 to B:
        For each s_j dp[s_j] += dp[s_j - c_i]
dp[B] will be our answer. Remember to take modulo 1000007.

public int coinchange2(int[] A, int B) {
    int[] num_ways = new int[B + 1];
    int Mod = 1000000 + 7;
    int i, j, m = A.length;
    Arrays.fill(num_ways, 0);
    num_ways[0] = 1;

    for (i = 0; i < m; i++) {
        for (j = A[i]; j <= B; j++) {
            num_ways[j] += num_ways[j - A[i]];
            num_ways[j] %= Mod;

        }
    }
    return num_ways[B];
}
 */
public class CoinSumInfinite {
    public int coinchange2(ArrayList<Integer> A, int B) {
        int MOD = (int) (1e6+7);
        int n = A.size();
        long[][] dp = new long[2][B+1];
        for(int i=1;i<=B;i++){
            dp[0][i]=0;
        }

        for(int i=0;i<=1;i++){
            dp[i][0]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= B ; j++) {

                if(j>=A.get(i-1)){
                    dp[i%2][j] = (dp[(i-1)%2][j]+dp[i%2][j-A.get(i-1)])%MOD;
                }else
                    dp[i%2][j] = dp[(i-1)%2][j];
            }
        }
        return (int)dp[n%2][B]%MOD;
    }
}
