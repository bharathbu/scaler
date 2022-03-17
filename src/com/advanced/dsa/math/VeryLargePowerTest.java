/**
 * Very Large Power
 * Problem Description
 * Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
 *
 * "^" means power,
 *
 * "%" means "mod", and
 *
 * "!" means factorial.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 5e5
 *
 *
 *
 * Input Format
 * First argument is the integer A
 *
 * Second argument is the integer B
 *
 *
 *
 * Output Format
 * Return one integer, the answer to the problem
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 1
 * B = 1
 * Input 2:
 *
 * A = 2
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1! = 1. Hence 1^1 = 1.
 * Explanation 2:
 *
 *  2! = 2. Hence 2^2 = 4.
 */
package com.advanced.dsa.math;

public class VeryLargePowerTest {
    public static void main(String[] args){

        System.out.println(solve(2,27));
    }

    public static int solve(int A, int B) {
        long MOD= (long) (1e9+7);
        long fact=1;// = factorial(B);
        // calculating factorial of B
        for(long i = 2; i <= B; i += 1) {
            fact = (fact * i) % (MOD - 1);      // (mod-1) is used accoring to Fermat Little theorem.
        }
        /*
            As per fermat's theorem, p -> prime number
            A^B! =~ A^x % p
            x = B! % (p-1)

         */
        int ans = (int) pow(A,fact,MOD);
        //int ans = (int) Math.pow(A,fact);
        return (int) (ans%MOD);
    }

    public static long pow(int A, long B, long C) {
        if(A==0) return 0;
        if(B==0) return 1;

        long halfPow = pow(A,B/2,C);
        long halhAns = (long)halfPow * halfPow;
        if(B%2 == 0)
            return ((halhAns%C+C)%C);
        else
            return (((halhAns%C*A%C)%C+C)%C);
    }

    private static int factorial(int b) {
        if(b==0)
            return 1;
        return (int) ((int) (b*factorial(b-1))%(1e9+6));
    }
}
