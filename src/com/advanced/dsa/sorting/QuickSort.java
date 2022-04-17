/**
 * QuickSort
 *
 * Problem Description
 *
 * Given an integer array A, sort the array using QuickSort.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 *
 * Return the sorted array.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 4, 10, 2, 1, 5]
 * Input 2:
 *
 *  A = [3, 7, 1]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 1, 2, 4, 5, 10]
 * Output 2:
 *
 *  [1, 3, 7]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Return the sorted array.
 */
package com.advanced.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        Integer[] a = new Integer[]{5,2,4,3,7,9};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        /*
        There are many sorting algorithms, but for this problem we will use QuickSort of sort the array.
        QuickSort is a Divide and Conquer Algorithm. It picks an element as pivot and partitions the given array around the picked pivot.

        There are many different versions of quickSort that pick pivot in different ways:

        -> Always pick first element as pivot.
        -> Always pick last element as pivot (implemented below)
        -> Pick a random element as pivot.
        -> Pick median as pivot.

        The key process in quickSort is partition().
        Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x.
        All this should be done in linear time.

        Average Case Time Complexity : O(NlogN)
        Worst Case : O(N2)
         */
        quickSort(A,0,A.size()-1);
        return A;
    }

    public static int partition(ArrayList<Integer> A,int s, int e){
        int l=s+1,r=e,a=0,b=0;
        while(l<=r){

            if(A.get(l)<=A.get(s))
                l++;
            else if(A.get(r)>A.get(s))
                r--;
            else{
                a=A.get(l);
                b=A.get(r);
                A.set(l,b);
                A.set(r,a);
                l++;
                r--;
            }
        }
        a=A.get(s);
        b=A.get(r);
        A.set(s,b);
        A.set(r,a);
        return r;
    }

    public static void quickSort(ArrayList<Integer> A, int s , int e){
        if(s>=e){
            return;
        }
        int p = partition(A, s, e);
        quickSort(A,s,p-1);
        quickSort(A,p+1,e);
    }
}
