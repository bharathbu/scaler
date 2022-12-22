/**
 * All Subarrays
 * Solved
 * character backgroundcharacter
 * Stuck somewhere?
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 * Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.
 *
 * Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
 *
 * Find and return the maximum value of XOR among all subarrays.
 *
 *
 *
 * Problem Constraints
 * 2 <= N <= 105
 *
 * 1 <= A[i] <= 107
 *
 *
 *
 * Input Format
 * The only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer, i.e., the maximum value of XOR of maximum and 2nd maximum element among all subarrays.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 3, 1, 4]
 * Input 2:
 *
 *  A = [1, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Outnput 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All subarrays of A having size greater than 1 are:
 *  Subarray            XOR of maximum and 2nd maximum no.
 *  1. [2, 3]           1
 *  2. [2, 3, 1]        1
 *  3. [2, 3, 1, 4]     7
 *  4. [3, 1]           2
 *  5. [3, 1, 4]        7
 *  6. [1, 4]           5
 *  So maximum value of Xor among all subarrays is 7.
 * Explanation 2:
 *
 *  Only subarray is [1, 3] and XOR of maximum and 2nd maximum is 2.
 */
package com.advanced.dsa.stacks;

import java.util.Stack;
/*
The subarray can only be reflected on its maximum element and second maximum element, so apparently,
there must be a lot of meaningless subarrays which we needn’t check them at all.
Can we use a stack to maintain the maximum and 2nd maximum of all subarrays?

The subarray can only be reflected on its maximum element and second maximum element, so apparently,
there must be a lot of meaningless subarrays which we needn’t check them at all. But how can we skip them?
Maintain a monotone-decreasing-stack can help us.
While a new element came into the view, pop the top element in the stack, and check the corresponding interval, until the new element is greater than the top element in the stack.
We can easily see it is correct since we won’t lost the answer as long as it exists.
 */
public class AllSubarrays {
    public int solve(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<A.length; i++)
        {
            if(stack.isEmpty())
            {
                stack.push(A[0]);
            }
            else
            {
                while(!stack.isEmpty() && stack.peek()<=A[i])
                {
                    max = Math.max(max, stack.peek()^A[i]);
                    stack.pop();
                }
                if( !stack.isEmpty() )
                    max = Math.max(max, stack.peek()^A[i]);

                stack.push(A[i]);
            }
        }
        return max;
    }
}
