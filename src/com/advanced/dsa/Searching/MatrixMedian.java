/**
 * Matrix Median
 *
 * Problem Description
 * Given a matrix of integers A of size N x M in which each row is sorted.
 *
 * Find and return the overall median of matrix A.
 *
 * NOTE: No extra memory is allowed.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 10^5
 *
 * 1 <= N*M <= 10^6
 *
 * 1 <= A[i] <= 10^9
 *
 * N*M is odd
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the overall median of matrix A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 3, 5],
 *         [2, 6, 9],
 *         [3, 6, 9]   ]
 * Input 2:
 *
 * A = [   [5, 17, 100]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  17
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * Explanation 2:
 *
 * Median is 17.
 */
package com.advanced.dsa.Searching;

import java.util.ArrayList;

/*
We cannot use extra memory, so we can’t store all elements in an array and sort the array.
But since rows are sorted, it must be of some use, right?

Note that in a row, you can binary search to find how many elements are smaller than a value X in O(log M).
This is the base of our solution.

Say k = N*M/2. We need to find (k + 1)^th smallest element.
(THE MEDIAN IS >= (n*m)/2+) ELEMENTS in A) -- The main intution behind the logic

We can use binary search on the answer. In O(N log M), we can count how many elements are smaller than X in the matrix.

So, we use binary search on the interval [1, INT_MAX]. So, the total complexity is O(30 * N log M).

Note:
This problem can be solved by using a min-heap, but extra memory is not allowed.
 */
public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size(),l=0,r=0;
        int mid;
        int req = (n*m)/2+1; // This is important observation
        for (int i = 0; i < n; i++)
            r = Math.max(r, A.get(i).get(m-1));

        int ans = -1;
        while(l<=r){
            mid = l + (r-l)/2;
            int cnt = 0;
            for (ArrayList<Integer> row: A) {
                int p = count(row, mid);
                cnt += p;
            }
            if(cnt >= req){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return ans;
    }

    /*
    This method will count the no. of elements in row list that are <= mid
     */
    private int count(ArrayList<Integer> row, int x) {
        int i=0,j=row.size()-1;
        int ans=-1;
        while(i<=j){
            int m = i+(j-i)/2;
            if(row.get(m)>x){
                ans = m;
                j = m-1;
            }else i=m+1;
        }
        if(ans == -1)
            ans = row.size();
        return ans;
    }
}
