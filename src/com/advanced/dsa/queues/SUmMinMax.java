/**
 * Sum of min and max
 *
 * Problem Description
 * Given an array A of both positive and negative integers.
 *
 * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
 *
 * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of array A <= 105
 *
 * -109 <= A[i] <= 109
 *
 * 1 <= B <= size of array
 *
 *
 *
 * Input Format
 * The first argument denotes the integer array A.
 * The second argument denotes the value B
 *
 *
 *
 * Output Format
 * Return an integer that denotes the required value.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 5, -1, 7, -3, -1, -2]
 *  B = 4
 * Input 2:
 *
 *  A = [2, -1, 3]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  18
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Subarrays of size 4 are :
 *     [2, 5, -1, 7],   min + max = -1 + 7 = 6
 *     [5, -1, 7, -3],  min + max = -3 + 7 = 4
 *     [-1, 7, -3, -1], min + max = -3 + 7 = 4
 *     [7, -3, -1, -2], min + max = -3 + 7 = 4
 *     Sum of all min & max = 6 + 4 + 4 + 4 = 18
 * Explanation 2:
 *
 *  Subarrays of size 2 are :
 *     [2, -1],   min + max = -1 + 2 = 1
 *     [-1, 3],   min + max = -1 + 3 = 2
 *     Sum of all min & max = 1 + 2 = 3
 */
package com.advanced.dsa.queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
We will use Deque(Double-Ended Queue) and the concept of the sliding window.

We create two empty double-ended queues of size B (‘S’ , ‘G’) that only store indexes of elements of the current window that are not useless.
An element is useless if it can not be the maximum or minimum of the next subarrays.
-> In deque ‘G’, we maintain decreasing order of values from front to rear.
-> In deque ‘S’, we maintain increasing order of values from front to rear.

Maintain both Dequeue such that the front element gives maximum and minimum element respectively for each window.
Add that element to the sum variable.
Return the sum%10^9+7.
Note that the sum%10^9+7 will be in the range (0,10^9+6).
 */
public class SUmMinMax {
    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> maxList = getSubArrayMax(A,B);
        ArrayList<Integer> minList = getSubArrayMin(A,B);
        int n=maxList.size(),sum=0,MOD=(int)1e9+7;
        for (int i = 0; i < n; i++) {
            long temp = (maxList.get(i)+minList.get(i))%MOD;
            sum= (int) ((sum+temp)%MOD);
            sum %= MOD;
        }
        return (sum+MOD)%MOD;
    }

    private ArrayList<Integer> getSubArrayMin(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deq = new LinkedList<>();
        int start=0,n=A.size();
        for (int i = 0; i < B; i++) {
            while(deq.size()>0 && A.get(i)<A.get(deq.peekLast()) )
                deq.removeLast();
            deq.addLast(i);
        }
        result.add(A.get(deq.getFirst()));
        start++;
        for (int i = B; i < n; i++) {
            while(deq.size()>0 && A.get(i)<A.get(deq.peekLast()) )
                deq.removeLast();
            deq.addLast(i);
            if(start>deq.getFirst())
                deq.removeFirst();
            result.add(A.get(deq.getFirst()));
            start++;
        }
        return result;
    }

    private ArrayList<Integer> getSubArrayMax(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deq = new LinkedList<>();
        int start=0,n=A.size();
        for (int i = 0; i < B; i++) {
            while(deq.size()>0 && A.get(i)>A.get(deq.peekLast()) )
                deq.removeLast();
            deq.addLast(i);
        }
        result.add(A.get(deq.getFirst()));
        start++;
        for (int i = B; i < n; i++) {
            while(deq.size()>0 && A.get(i)>A.get(deq.peekLast()) )
                deq.removeLast();
            deq.addLast(i);
            if(start>deq.getFirst())
                deq.removeFirst();
            result.add(A.get(deq.getFirst()));
            start++;
        }
        return result;
    }
}
