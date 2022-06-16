/**
 * MAX and MIN
 *
 * Problem Description
 * Given an array of integers A.
 *
 * value of a array = max(array) - min(array).
 *
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1]
 * Input 2:
 *
 *  A = [4, 7, 3, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  26
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only 1 subarray exists. Its value is 0.
 * Explanation 2:
 *
 * value ( [4] ) = 4 - 4 = 0
 * value ( [7] ) = 7 - 7 = 0
 * value ( [3] ) = 3 - 3 = 0
 * value ( [8] ) = 8 - 8 = 0
 * value ( [4, 7] ) = 7 - 4 = 3
 * value ( [7, 3] ) = 7 - 3 = 4
 * value ( [3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3] ) = 7 - 3 = 4
 * value ( [7, 3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
 * sum of values % 10^9+7 = 26
 */
package com.advanced.dsa.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class MaxMinTest {
    public int solve(ArrayList<Integer> A) {
        int n=A.size(),mod= (int) (1e9+7);
        long ans=0;
        ArrayList<Integer> NGL = nextGreaterLeft(A);
        ArrayList<Integer> NGR = nextGreaterRight(A);
        ArrayList<Integer> NSL = nextSmallerLeft(A);
        ArrayList<Integer> NSR = nextSmallerRight(A);

        for (int i = 0; i < n; i++) {
            long max = (1L*(i-NGL.get(i))*(NGR.get(i)-i))%mod;
            max = (max*A.get(i))%mod;
            long min = (1L*(i-NSL.get(i))*(NSR.get(i)-i))%mod;
            min = (min*A.get(i))%mod;
            ans= (ans%mod)+((max-min)%mod);
            ans = ans%mod;
        }
        if(ans<0)
            ans = (ans+mod)%mod;
        return (int) (ans%mod);
    }

    public ArrayList<Integer> nextGreaterRight(ArrayList<Integer> A) {
        Stack<Integer> stk = new Stack<>();
        int n=A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ans.add(n);

        for (int i = n-1; i >=0 ; i--) {
            while(stk.size()>0 && A.get(i)>=A.get(stk.peek()))
                stk.pop();
            if(stk.size()>0)
                ans.set(i,stk.peek());
            stk.push(i);
        }
        return ans;
    }

    public ArrayList<Integer> nextGreaterLeft(ArrayList<Integer> A) {
        Stack<Integer> stk = new Stack<>();
        int n=A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ans.add(-1);

        for (int i = 0; i < n; i++) {
            while(stk.size()>0 && A.get(i)>=A.get(stk.peek()))
                stk.pop();
            if(stk.size()>0)
                ans.set(i,stk.peek());
            stk.push(i);
        }
        return ans;
    }

    public ArrayList<Integer> nextSmallerRight(ArrayList<Integer> A) {
        Stack<Integer> stk = new Stack<>();
        int n=A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ans.add(n);

        for (int i = n-1; i >=0 ; i--) {
            while(stk.size()>0 && A.get(i)<=A.get(stk.peek()))
                stk.pop();
            if(stk.size()>0)
                ans.set(i,stk.peek());
            stk.push(i);
        }
        return ans;
    }

    public ArrayList<Integer> nextSmallerLeft(ArrayList<Integer> A) {
        int n=A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ans.add(-1);

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(stk.size()>0 && A.get(i) <= A.get(stk.peek()))
                stk.pop();
            if(stk.size()>0)
                ans.set(i,stk.peek());
            stk.push(i);
        }
        return ans;
    }
}
