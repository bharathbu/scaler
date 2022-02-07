/**
 * Max Non Negative SubArray
 *
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 *
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 *
 * Find and return the required subarray.
 *
 * NOTE:
 *
 *     1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 *     2. If there is still a tie, then return the segment with minimum starting index.
 *
 *
 * Input Format:
 *
 * The first and the only argument of input contains an integer array A, of length N.
 * Output Format:
 *
 * Return an array of integers, that is a subarray of A that satisfies the given conditions.
 * Constraints:
 *
 * 1 <= N <= 1e5
 * -INT_MAX < A[i] <= INT_MAX
 * Examples:
 *
 * Input 1:
 *     A = [1, 2, 5, -7, 2, 3]
 *
 * Output 1:
 *     [1, 2, 5]
 *
 * Explanation 1:
 *     The two sub-arrays are [1, 2, 5] [2, 3].
 *     The answer is [1, 2, 5] as its sum is larger than [2, 3].
 *
 * Input 2:
 *     A = [10, -1, 2, 3, -4, 100]
 *
 * Output 2:
 *     [100]
 *
 * Explanation 2:
 *     The three sub-arrays are [10], [2, 3], [100].
 *     The answer is [100] as its sum is larger than the other two.
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class MaxNonNegativeSubarraySumTest {
    public static void main(String args[]){
        ArrayList<Integer> A = new ArrayList<Integer>();
        //A.add(10);A.add(-1);A.add(2);A.add(3);A.add(-4);A.add(100);
        //A.add(1);A.add(2);A.add(5);A.add(-9);A.add(2);A.add(3);
        A.add(0);A.add(0);A.add(-1);A.add(0);
        System.out.println(maxset(A));
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int aLeft =-1,aRight=-1,left=0,right=0,n=A.size(),temp=0;
        long sum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            temp=A.get(i);
            if(temp>=0){
                sum+=temp;
                if(sum>maxSum || (sum==maxSum && aRight-aLeft<right-left)){
                    aLeft=left;
                    aRight=right;
                    maxSum = sum;
                }
            }else{
                sum = 0;
                left=i+1;
            }
            right++;
        }
        if(aLeft>-1){
            for(int i=aLeft;i<=aRight;i++){
                result.add(A.get(i));
            }
        }
        return result;
    }
}
