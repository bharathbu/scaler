/**
 * Single Element in a Sorted Array
 *
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
 *
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the single element that appears only once.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 7]
 * Input 2:
 *
 * A = [2, 3, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  7 appears once
 * Explanation 2:
 *
 *  2 appears once
 */
package com.advanced.dsa.Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElement {

    public static void main(String[] args){
        int[] a = new int[]{13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a));

    }

    public static int solve(int[] A) {
        /*
        You need to return the index of 1-time occurring element >= x.
        You can do this by binary search.
        Note that this is a classic binary search. Instead of looking for the element x,
        you are looking for the least elements >= x.
        You can do this by binary search.
        Look for its implementation. There are multiple ways to do this.
        Remember that the index starts from 0.
         */
        int n=A.length, low=0,high=n-1,mid=0;
        if(A[0] != A[1])
            return A[0];
        if(A[high-1] != A[high])
            return A[high];
        while(low<=high){
            mid=(low+high)/2;
            if(A[mid]!=A[mid-1] && A[mid] != A[mid+1]) return A[mid];
            else if((mid%2==0 && A[mid]==A[mid+1]) ||
                    (mid%2==1 && A[mid]==A[mid-1]))
                low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}
