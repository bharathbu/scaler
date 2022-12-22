/**
 * Closest pair from sorted arrays
 * Solved
 * character backgroundcharacter
 * Stuck somewhere?
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 *
 * Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.
 *
 * More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
 *
 * If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.
 *
 * Return an array with two elements {A[i], B[j]}.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of both the arrays <= 100000
 *
 * 1 <= A[i], B[i] <= 109
 *
 * 1 <= C <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * The third argument given is integer C.
 *
 *
 *
 * Output Format
 *
 * Return an array of size 2 denoting the pair which has sum closest to C.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = [2, 4, 6, 8]
 *  C = 9
 * Input 2:
 *
 *  A = [5, 10, 20]
 *  B = [1, 2, 30]
 *  C = 13
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 8]
 * Output 2:
 *
 *  [10, 2]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 *  Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
 * Explanation 2:
 *
 *  [10, 2] is the only pair such abs(10+2-13) is minimum.
 */
package com.advanced.dsa.twopointers;

import java.util.ArrayList;

/*
This problem can be solved by using two pointer approach.

Let say l = 0 i.e. it points at the start of array A and r = len(B) - 1 i.e. it points to end of array B.
Also maintain a variable, let say, dif, which stores the minimum of abs(A[i]+B[j]-C).

Now, If abs(A[l]+B[r]-C) < dif then update the value of dif and the value of two A[i] and A[j] and there indices.

If abs(A[l]+B[r]-C) == dif then we need to update the indices such that l and r are minimum as possible in case of multiple solution.

Also, increment l and decrement r accordingly.
 */
public class ClosestPair {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size(), m = B.size();
        int i=0,j=m-1,diff;
        res.add(A.get(i));
        res.add(B.get(j));
        diff = Integer.MAX_VALUE;
        while(i<n && j>=0) {
            int a = A.get(i);
            int b = B.get(j);
            int temp = Math.abs(a+b-C);
            if(temp < diff){
                diff=temp;
                res.set(0,a);
                res.set(1,b);
            }else if(temp == diff && res.get(0) == res.get(i))
                res.set(1,b);
            if(A.get(i)+B.get(j) >= C)
                j--;
            else i++;
        }

        return res;
    }
}
