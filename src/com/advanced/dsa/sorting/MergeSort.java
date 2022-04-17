/**
 * Merge Sort
 *
 * Problem Description
 * Given an integer array A, sort the array using Merge Sort.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 * Output Format
 * Return the sorted array.
 *
 *
 * Example Input
 * Input 1:-
 * A = [1, 4, 10, 2, 1, 5]
 * Input 2:-
 * A = [3, 7, 1]
 *
 *
 * Example Output
 * Output 1:-
 * [1, 1, 2, 4, 5, 10]
 * Output 2:-
 * [1, 3, 7]
 *
 *
 * Example Explanation
 * Explanation 1:
 * Return the sorted array.
 */
package com.advanced.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args){
        Integer[] a = new Integer[]{5,2,4,3,7,9};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve( A));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
       //ArrayList<Integer> result = new ArrayList<Integer>();
        int n = A.size();
        mergeSort(A,0,n-1);
        return A;
    }

    private static void mergeSort(ArrayList<Integer> a, int l, int r) {
        if(l == r) return;
        int mid = (l+r)/2;
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        merge(a,l,mid,r);
    }

    private static void merge(ArrayList<Integer> A, int l, int mid, int r) {
        int[] C = new int[r-l+1];
        int a=l,b=mid+1,c=0;
        while(a<=mid && b<=r){
            if(A.get(a)<A.get(b))
                C[c]=A.get(a++);
            else C[c] = A.get(b++);
            c++;
        }
        while(a<=mid){
            C[c++] = A.get(a++);
        }
        while(b<=r)
            C[c++] = A.get(b++);
        for (int i = 0; i < r-l+1; i++) {
            A.set(l+i,C[i]);
        }

    }
}
