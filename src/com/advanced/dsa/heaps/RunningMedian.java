/**
 * Running Median
 *
 * Problem Description
 * Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
 * Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
 *
 * Find and return the array C.
 *
 * NOTE:
 *
 * If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
 * If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer array C, C[i] denotes the median of the first i elements.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 5, 4, 3]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 1, 2, 2, 3]
 * Output 2:
 *
 *  [5, 5, 17, 11]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  stream          median
 *  [1]             1
 *  [1, 2]          1
 *  [1, 2, 5]       2
 *  [1, 2, 5, 4]    2
 *  [1, 2, 5, 4, 3] 3
 * Explanation 2:
 *
 *  stream          median
 *  [5]              5
 *  [5, 17]          5
 *  [5, 17, 100]     17
 *  [5, 17, 100, 11] 11
 */
package com.advanced.dsa.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.offer(A.get(0));
        ans.add(A.get(0));
        for (int i = 1; i < n; i++) {
            int ele = A.get(i);
            if(ele < maxHeap.peek())
                //element belongs to first half only
                maxHeap.offer(ele);
            else minHeap.offer(ele);
            if(maxHeap.size() < minHeap.size()){
                //Transfer min element from 2nd bucket to first bucket
                int minEle = minHeap.poll();
                maxHeap.offer(minEle);
            }else if(maxHeap.size()-minHeap.size()>1){
                int maxEle = maxHeap.poll();
                minHeap.offer(maxEle);
            }
            int s = i+1;
            ans.add(maxHeap.peek());
        }
        return ans;
    }
}
