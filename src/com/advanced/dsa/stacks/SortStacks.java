/**
 * Sort stack using another stack
 *
 * Problem Description
 * Given a stack of integers A, sort it using another stack.
 *
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 5000
 *
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument is a stack given as an integer array A.
 *
 *
 *
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 4, 3, 2, 1]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 3, 4, 5]
 * Output 2:
 *
 *  [5, 11, 17, 100]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Just sort the given numbers.
 * Explanation 2:
 *
 *  Just sort the given numbers.
 */
package com.advanced.dsa.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStacks {

    public static void main (String[] args){
        Integer[] a = new Integer[]{66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12 };
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve( A));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        return mergeSort(A);
    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> A) {
        int n = A.size(),i=0,j=0;
        if(n<=1) return A;

        ArrayList<Integer> s1 = new ArrayList<>();
        ArrayList<Integer> s2 = new ArrayList<>();

        for (i = 0; i < n/2; i++)
            s1.add(A.get(i));

        for(j=i;j<n;j++)
            s2.add(A.get(j));

        s1 = mergeSort(s1);
        s2 = mergeSort(s2);
        return merge(s1,s2);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> s1, ArrayList<Integer> s2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n=s1.size(),m=s2.size(),i=0,j=0;
        while(i<n && j<m){
            if(s1.get(i)>s2.get(j))
                ans.add(s2.get(j++));
            else
                ans.add(s1.get(i++));
        }
        while(i<n)
            ans.add(s1.get(i++));
        while (j<m)
            ans.add(s2.get(j++));
        return ans;
    }
}
