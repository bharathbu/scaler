/**
 *  Length of LISOptimised
 * Unsolved
 * character backgroundcharacter
 * Stuck somewhere?
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 * You are given an array A. You need to find the length of the Longest Increasing Subsequence in the array.
 *
 * In other words, you need to find a subsequence of array A in which the elements are in sorted order, (strictly increasing) and as long as possible.
 *
 *
 *
 * Problem Constraints
 * 1 ≤ length(A), A[i] ≤ 105
 *
 *
 *
 * Input Format
 * The first and only argument of the input is the array A.
 *
 *
 *
 * Output Format
 * Output a single integer, the length of the longest increasing subsequence in array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A: [2, 1, 4, 3]
 * Input 2:
 *
 * A: [5, 6, 3, 7, 9]
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 4] and [1, 3] are the longest increasing sequences of size 2.
 * Explanation 2:
 *
 * The longest increasing subsequence we can get is [5, 6, 7, 9] of size 4.
 */
package com.advanced.dsa.dp;

import java.util.ArrayList;
import java.util.List;

public class LISOptimised {
    public int findLIS(ArrayList<Integer> A) {
        int n = A.size();
        List<Integer> dp = new ArrayList<>();
        dp.add(A.get(0));
        for (int i = 1; i < n; i++) {
            int val = A.get(i);
            if(val>dp.get(dp.size()-1))
                dp.add(val);
            else{
                int idx = binarySearch(0,dp.size()-1,dp,val);
                dp.set(idx, val);
            }
        }
        return dp.size();
    }

    private int binarySearch(int low, int high, List<Integer> dp, int target) {
        int mid = 0,res = 0;
        while(low<=high){
            mid = low+(high-low)/2;
            if(dp.get(mid) == target) return mid;
            else if(dp.get(mid) < target) low = mid+1;
            else{
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }
}
