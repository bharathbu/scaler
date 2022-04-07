/**
 *  Prime Subsequences
 *
 *  Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.
 *
 * A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.
 *
 *
 *
 * Input Format
 *
 * The first argument given is an Array A, having N integers.
 * Output Format
 *
 * Return an integer X, i.e number of Prime subsequences.
 * As X can be very large print X % (1000000007), here % is modulus operator.
 * Constraints
 *
 * 1 <= N <= 1e3
 * 1 <= A[i] <= 1e6
 * For Example
 *
 * Input:
 *     A = [1, 2, 3]
 * Output:
 *      3
 *
 * Explanation:
 *     no. Subsequences      Prime subsequences
 *     1.  [1]                     No
 *     2.  [1, 2]                  No
 *     3.  [1, 3]                  No
 *     4.  [1, 2, 3]               No
 *     5.  [2]                     Yes
 *     6.  [2, 3]                  Yes
 *     7.  [3]                     Yes
 *     8.  []                      No
 *
 *     here we have 3 subsequences(5, 6, 7) those have only prime number(s).
 */
package com.advanced.dsa.math;

public class PrimeSubsequences {
    public static void main(String[] args){
        int[] A = {1,2,3};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int n = A.length,count=0,ans=0,mod = 1000000007,max=Integer.MIN_VALUE;
        boolean flag=true;
        for (int i = 0; i < n; i++) {
            if(A[i]>max)
                max=A[i];
        }
        boolean[] spf = new boolean[max+1];
        for (int i = 2; i <=max; i++)
            spf[i] = true;
        for (int i = 2; i*i <=max; i++)
            if(spf[i])
                for (int j = i*i; j <=max; j+=i)
                    spf[j] = false;
        /*
        Let M be the number of prime integers in an array, then the number of Prime Subsequences will be ((2 ^ M) - 1).
        Can you prove this?
         */
        for (int j = 0; j < n; j++) {
            if(spf[A[j]]){
                ans = (int) ((ans%mod+ Math.pow(2, count)%mod)%mod);
                //System.out.println(A[j]);
                count++;
            }
        }
        return ans;
    }

}
