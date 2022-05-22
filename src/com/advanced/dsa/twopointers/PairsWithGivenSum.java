/**
 * Pairs with given sum II
 *
 * Problem Description
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 *
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 1]
 * B = 2
 * Input 2:
 *
 *
 * A = [1, 1]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Any two pairs sum up to 2.
 * Explanation 2:
 *
 *  only pair (1, 2) sums up to 2.
 */
package com.advanced.dsa.twopointers;

import java.util.Arrays;

public class PairsWithGivenSum {
    public static void main(String[] args){
        /*
        Let us formulate a two pointer approach to the this problem.
        We will first sort the given array and use two pointers i and j with i = 0, j = Length of Array - 1.
        We will have three conditions:

        1. A[i] + A[j] < sum  --> We will increase the pointer i.
        2. A[i] + A[j] > sum  --> We will decrease the pointer j.
        3. A[i] + A[j] = sum  --> We will count the frequency of A[i] and A[j] and multiply them and add to the answer.

        Note, that if A[i] and A[j] are equal in value, then we will have to change the formula instead:
        freq(A[i]) * freq(A[i])  --> freq(A[i]) * (freq(A[i]) - 1) / 2
        to avoid overcounting pairs.

        Refer to the complete solution for more details.
         */
        int[] a = new int[]{8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a, 3));

    }

    public static int solve(int[] A, int B) {
        int n=A.length,p1=0,p2=n-1,count=0;
        while(p1<p2){
            int sum= A[p1]+A[p2];
            if(sum == B){
                //resetting values of p and q as it would have been changed in the previous loop.
                long p=1;
                long q=1;
                //storing the values at the two pointers
                int  a_i = A[p1];
                int  a_j = A[p2];

                //if the next element on left is == to the current then increment p and i.
                while( p1+1<p2 && a_i==A[p1+1]){
                    p++;
                    p1++;
                }

                //after the above loop the p will contain the count of a_i

                //similarly for right
                while( p1<p2-1 && a_j==A[p2-1] ){
                    q++;
                    p2-=1;
                }

                //after the above loop the q will contain the count of a_j

                //if the element at two pointer are same for ex. [1,1,1,1] and B=2
                //p will hold the count excluding a_j
                //increment p by 1;
                //now out of p elements , pick two to form a pair uce nCr

                if(p>1 && a_j == a_i){
                    p++;
                    count+=  ((p)*(p-1))/2;
                }
                //else simply multiply pq
                else
                    count+=(p*q);

                count = count%1000000007;
                // incrementing the value of i and j to move on…
                p1++;
                p2--;
            }else if(sum>B)
                p2--;
            else
                p1++;
        }
        return count%1000000007;
    }
}
