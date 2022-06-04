/**
 * Largest Rectangle in Histogram
 *
 * Problem Description
 * Given an array of integers A.
 *
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 *
 * Find the area of the largest rectangle formed by the histogram.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000000
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 *
 *  A = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 *
 * Largest rectangle has area 2.
 */
package com.advanced.dsa.stacks;

import java.util.Stack;

/*
Lets consider 2 consecutive histogram bars H[i] and H[i+1]. Lets assume H[i+1] < H[i]
In such a case, for all histogram bars X with index > i + 1 when traversing left for L, there is no point looking at H[i] after looking at H[i+1]. If H[i+1] > X, obviously H[i] > X as we already know H[i] > H[i+1]

Then, what is the next entry we would want to look at? We want to look at the first histogram bar left of H[i+1] with a height less than H[i+1].

We already know from our previous observation that when I traverse left, I only need entries in decreasing order.

We traverse all histograms from left to right and maintain a stack of histograms. Every histogram is pushed to stack once. A histogram is popped from the stack when a histogram of smaller height is seen. We calculate the area with the popped histogram as the smallest histogram when a histogram is popped. How do we get left and right indexes of the popped histogram – the current index tells us the ‘right index’ R, and the index of the previous item in the stack is the ‘left index’ L. Following is a rough pseudocode.

max_rectangle = 0
stack = an instance of empty stack
for index = 0 to all_histograms.length
    if stack.empty OR H[index] > H[stack.top]
        Push index to the stack
    if H[index] < H[stack.top]
        while !stack.empty && H[stack.top] > H[index]
            h = H[stack.pop]
            # Calculate the area with h as the smallest height.
            R = index
            L = stack.top
            max_rectangle = MAX(max_rectangle, (R - L - 1) * h)
        Push index to the stack
if stack is not empty
    Repeat removing entries one by one from the stack and calculating the max_rectangle as done earlier.
 */
public class Histogram {
    public int largestRectangleArea(int[] A) {
        int n=A.length,ans=Integer.MIN_VALUE,h,x1,x2,w;
        int[] nsil, nsir; //nsil: nearest smaller index of A[i] on left
                          //nsir: nearest smaller index of A[i] on right

        nsil = prevSmaller(A);
        nsir = rightSmaller(A);

        for (int i = 0; i < n; i++) {
            h=A[i];
            x1=nsil[i];
            x2=nsir[i];
            w=x2-x1-1;
            ans=Math.max(ans,h*w);
        }
        return ans;
    }

    public int[] prevSmaller(int[] A) {
        int n=A.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i]=-1;

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(stk.size()>0 && A[i] <= A[stk.peek()])
                stk.pop();
            if(stk.size()>0) ans[i]=stk.peek();
            stk.push(i);
        }
        return ans;
    }

    public int[] rightSmaller(int[] A) {
        int n=A.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i]=n;

        Stack<Integer> stk = new Stack<>();
        for (int i = n-1; i >=0; i--) {
            while(stk.size()>0 && A[i] <= A[stk.peek()])
                stk.pop();
            if(stk.size()>0) ans[i]=stk.peek();
            stk.push(i);
        }
        return ans;
    }

}
