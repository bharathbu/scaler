/**
 * Q1. Square Root of Integer
 *
 * Problem Description
 * Given an integer A.
 *
 * Compute and return the square root of A.
 *
 * If A is not a perfect square, return floor(sqrt(A)).
 *
 * DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.
 *
 * NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 1010
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer A.
 *
 *
 *
 * Output Format
 * Return floor(sqrt(A))
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  11
 * Input 2:
 *
 *  9
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation:
 *
 *  When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 *  When A = 9 which is a perfect square of 3, so we return 3.
 */
package com.advanced.dsa.Searching;

public class SQRT {
    public static void main(String[] args){
        /*
        Think in terms of binary search.

        Let us say S is the answer.

        We know that 0 <= S <= x.

        Consider any random number r.

        If r*r <= x, S >= r

        If r*r > x, S < r.

        Maybe try to run a binary search for S.
         */
        System.out.println(sqrt(930675566));
    }

    public static int sqrt(int A) {
        int l=1,h=A/2,mid,ans=1;
        long temp;

        if(A==1) return 1;

        while(l<=h){
            mid=(l+h)/2;
            temp=(long)mid*mid;
            if( temp == A) return mid;
            else if( temp < A){
                ans=mid;
                l=mid+1;
            }else
                h=mid-1;
        }

        return ans;
    }
}
