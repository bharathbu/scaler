/**
 * All GCD Pair
 *
 * Problem Description
 * Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
 *
 * Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Find and return the original numbers which are used to calculate the GCD array in any order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
 * Input 2:
 *
 *  A = [5, 5, 5, 15]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 8, 10]
 * Output 2:
 *
 *  [5, 15]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 *  2 is the gcd between 2 and 8, 2 and 10.
 *  8 and 10 are the gcds pair with itself.
 *  Therefore, [2, 8, 10] is the original array.
 * Explanation 2:
 *
 *  Initially, array A = [5, 5, 5, 15].
 *  5 is the gcd between 5 and 15.
 *  15 is the gcds pair with itself.
 *  Therefore, [5, 15] is the original array.
 */
package com.advanced.dsa.math;

import java.util.*;

public class AllGCDPairTest {
    public static void main(String[] args){
        int[] A = {1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11};
        System.out.println(solve(A));
    }
    public static int[] solve(int[] A) {
        int n = A.length;
        int m = (int) Math.sqrt(n);
        int[] result = new int[m];
        Map<Integer,Integer> map = new HashMap<>();
        /*
        1. Sort the array in decreasing order.
        2. Highest element will always be one of the original numbers. Keep that number and remove it from the array.
        3. Compute GCD of the element taken in the previous step with the current element starting from the greatest and discard the GCD value from the given array.
         */
        Arrays.sort(A);
        result[0] = A[n-1];
        int j=1,freq=0,gcd=0;
        for(int i=n-2;i>=0;i--){
            freq = map.getOrDefault(A[i],0);
            if(freq > 0)
                map.put(A[i],freq-1);
            else if(j<m){
                for(int k=0;k<j;k++){
                    gcd = gcd(A[i],result[k]);
                    map.put(gcd,map.getOrDefault(gcd,0)+2);
                }
                result[j] = A[i];
                j++;
            }
        }

        return result;
    }

    public static int gcd(int A, int B) {
        if(B==0)
            return A;
        return gcd(B,A%B);
    }
}
