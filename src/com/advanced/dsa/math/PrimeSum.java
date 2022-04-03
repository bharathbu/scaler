/**
 * Prime Sum
 *
 * Problem Description
 * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
 *
 * If there is more than one solution possible, return the lexicographically smaller solution.
 *
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 * [a, b] < [c, d], If a < c OR a==c AND b < d.
 * NOTE: A solution will always exist. Read Goldbach's conjecture.
 *
 *
 *
 * Problem Constraints
 * 4 <= A <= 2*107
 *
 *
 *
 * Input Format
 * First and only argument of input is an even number A.
 *
 *
 *
 * Output Format
 * Return a integer array of size 2 containing primes whose sum will be equal to given number.
 *
 *
 *
 * Example Input
 *  4
 *
 *
 * Example Output
 *  [2, 2]
 *
 *
 * Example Explanation
 *  There is only 1 solution for A = 4.
 */
package com.advanced.dsa.math;

public class PrimeSum {
    public static void main(String[] args){
        System.out.println(primesum(40));
    }

    public static int[] primesum(int A) {
        /*
        Approach is to create bool SPF array [Smallest Prime Factor, that marks true if prime, else false]
        return result if i and A-i is marked true in SPF array.
         */
        boolean[] spf = new boolean[A+1];
        int[] result = new int[2];
        for (int i = 0; i <=A; i++)
            spf[i] = true;
        for (int i = 2; i*i <=A; i++)
            if(spf[i])
                for (int j = i*i; j <=A; j+=i)
                    spf[j] = false;

        for (int i = 2; i <A ; i++) {
            if(spf[i] && spf[A-i]){
                result[0] = i;
                result[1] = A-i;
                break;
            }
        }
        return result;
    }
}
