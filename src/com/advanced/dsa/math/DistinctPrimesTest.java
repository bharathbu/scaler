/**
 *  Distinct Primes
 *
 *  You have given an array A having N integers. Let say G is the product of all elements of A.
 *
 * You have to find the number of distinct prime divisors of G.
 *
 *
 *
 * Input Format
 *
 * The first argument given is an Array A, having N integers.
 * Output Format
 *
 * Return an Integer, i.e number of distinct prime divisors of G.
 * Constraints
 *
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e5
 * For Example
 *
 * Input:
 *     A = [1, 2, 3, 4]
 * Output:
 *      2
 *
 * Explanation:
 *     here G = 1 * 2 * 3 * 4 = 24
 *     and distinct prime divisors of G are [2, 3]
 */
package com.advanced.dsa.math;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimesTest {

    public static void main(String args[]){
        int[] A = {63, 52, 28, 72, 9, 62, 79, 71, 43, 15, 82, 21, 10, 12, 38, 96, 58, 99, 59, 100, 10, 38, 92, 30, 24, 3, 49, 17, 2, 63, 54, 18, 71, 7, 65, 87, 82, 31, 48, 39, 100, 82, 15, 60, 44, 84, 43, 5, 63, 17, 100, 94, 62, 26, 35, 29};
        System.out.println(solve(A));
    }
    /*static int mn = (int) (1e5 + 5);
    static int[] primes = new int[mn];

    static void pre_compute() {
        if(!primes[2].empty()) return;
        for(ll i = 2; i < mn; i += 1) {
            if(primes[i].empty()) {
                primes[i].push_back((int)i);
                for(ll j = i+i; j < mn; j += i) {
                    primes[j].push_back((int)i);
                }
            }
        }
    }*/

    public static int solve(int[] A) {



        int n = A.length,count=0,max=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(A[i]>max)
                max=A[i];
        }
        boolean[] spf = new boolean[max+1];
        for (int i = 0; i <=max; i++)
            spf[i] = true;
        for (int i = 2; i*i <=max; i++)
            if(spf[i])
                for (int j = i*i; j <=max; j+=i)
                    spf[j] = false;

        Set set = new HashSet();
        for (int i = 0; i < n; i++) {
            if(A[i]>1 && spf[A[i]])
                set.add(A[i]);
            for (int j = 2; j <A[i] ; j++) {
                if(spf[j] && A[i]%j == 0)
                    set.add(j);

            }
        }
        return set.size();
    }

}
