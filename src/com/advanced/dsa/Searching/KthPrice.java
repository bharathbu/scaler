/**
 * KthPrice
 *
 * Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).
 *
 * NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.
 *
 * Example:
 *
 * A : [2 1 4 3 2]
 * k : 3
 *
 * Answer : 2
 * Constraints :
 *
 * 1 <= number of elements in the price list <= 1000000
 * 1 <= k <= number of elements in the price list
 */
package com.advanced.dsa.Searching;

import java.util.List;

public class KthPrice {
    public int solve(final List<Integer> A, int B) {
        int n = A.size(), ans =0;
        int start = A.get(0), end = A.get(0);
        for(int i=1;i < n; i++){
            start = Math.min(start,A.get(i));
            end = Math.max(end,A.get(i));
        }
        int numSmaller = 0,mid;
        while(start <= end){
            mid = start + (end-start)/2;
            numSmaller =0;
            for(int i=0;i < n; i++)
                if(A.get(i) <= mid)
                    numSmaller++;
            if(numSmaller >= B){
                end = mid-1;
                ans = mid;
            }else
                start=mid+1;
        }
        return ans;
    }
}
