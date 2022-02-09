/**
 * Pair Sum divisible by M
 *
 * Problem Description
 *
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 106
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 2
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 28
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 *  So total 4 pairs.
 */
package com.advanced.dsa.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PairSumModuloTest {

    public static void main(String args[]){
        //int[] ints = {1, 2, 3, 4, 5};
        int[] ints = {5, 17, 100, 11};
        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(ints).boxed().collect(Collectors.toList());

        System.out.println(solve(A,28));
    }
    public static int solve(ArrayList<Integer> A, int B) {
        int result=0;
        int n=A.size(),modTemp,freq;
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<n;i++){
            modTemp = A.get(i)%B;
            freq = freqMap.getOrDefault(modTemp,0);
            freqMap.put(modTemp,freq+1);

        }
        result += (long)calcNC2(freqMap.getOrDefault(0,0));
        int i=1,j=B-1;
        while(i<j){
            result+=(long)(freqMap.getOrDefault(i,0)*freqMap.getOrDefault(j,0));
            i++;j--;
        }
        if((B&1) == 0){ //or i==j. To check if B is even or not
            result+= (long)calcNC2(freqMap.getOrDefault(i,0));
        }
        result = result%1000000007;

        return result;
    }

    private static long calcNC2(Integer n) {
        return (long)n*(n-1)/2;
    }

}
