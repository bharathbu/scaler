/**
 * Max Sum Contiguous Subarray
 *
 * Problem Description
 * Find the contiguous non empty subarray within an array, A of length N which has the largest sum.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer array, A.
 *
 *
 *
 * Output Format
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, -10]
 * Input 2:
 *
 *  A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * Explanation 2:
 *
 *  The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSumSubarrayTest {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        //A.add(1);A.add(2);A.add(4);A.add(3);A.add(0);A.add(2);A.add(1);A.add(9);
        A.add(0);A.add(3);A.add(9);A.add(9);
        System.out.println(maxSubArray(A));

    }

    public static int maxSubArray(final List<Integer> A) {
        //Implemented using Kadane's algorithm. TC=O(N)
        int ans = Integer.MIN_VALUE, n=A.size(),sum=0,temp;
        for(int i=0;i<n;i++){
            temp = A.get(i);
            sum += temp;
            ans = Math.max(sum,ans);
            if(sum<0)
                sum=0;

        }
        return ans;
    }
}
