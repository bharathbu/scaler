/**
 * Lucky Numbers
 *
 * Problem Description
 * A lucky number is a number that has exactly 2 distinct prime divisors.
 *
 * You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 50000
 *
 *
 *
 * Input Format
 * The first and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 8
 * Input 2:
 *
 *  A = 12
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Between [1, 8] there is only 1 lucky number i.e 6.
 *  6 has 2 distinct prime factors i.e 2 and 3.
 * Explanation 2:
 *
 *  Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
package com.advanced.dsa.math;

import java.util.HashSet;
import java.util.Set;

public class LuckyNumbersTest {
    public static void main(String[] args){
        System.out.println(solve(12));
    }

    public static  int solve(int A) {
        /*
        Approach is to create integer SPF array [Smallest Prime Factor, that holds spf value for non-prime numbers]
        Using spf array, list the prime factor and increment count if size is exactly 2.
         */
        int[] spf = new int[A+1];
        for (int i = 1; i <= A; i++) {
            spf[i] = i;
        }
        for (int i = 2; i*i < A; i++) {
            if(spf[i] == i){
                for(int j=i*i;j<=A;j+=i){
                    spf[j] = Math.min(spf[j],i);
                }
            }
        }
        Set pf ;
        int x=1,result=0,temp;
        for (int i = 6; i <= A; i++) {
            pf = new HashSet();
            temp=i;
            while(temp>1){
                x=spf[temp];
                pf.add(x);
                temp=temp/x;
            }
            if(pf.size() == 2)
                result++;
        }
        return result;
    }
}
