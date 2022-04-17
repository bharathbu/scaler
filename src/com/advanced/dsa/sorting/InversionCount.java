/**
 *  Inversion count in an array
 *
 *  Problem Description
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the number of inversions of A modulo (109 + 7).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [3, 2, 1]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All pairs are inversions.
 * Explanation 2:
 *
 *  No inversions.
 */
package com.advanced.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionCount {
    static int mod= (int) (1e9+7);
    public static void main(String[] args){
        Integer[] a = new Integer[]{5,2,4,3,7,9};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve( A));
    }

    public static int solve(ArrayList<Integer> A) {
        int n = A.size();
        return mergeSort(A,0,n-1);
    }

    private static int mergeSort(ArrayList<Integer> a, int l, int r) {
        if(l == r) return 0;
        int mid = (l+r)/2;
        int A = mergeSort(a,l,mid);
        int B = mergeSort(a,mid+1,r);
        int C = merge(a,l,mid,r);
        return ((A%mod+B%mod+C%mod)%mod+mod)%mod;
    }

    private static int merge(ArrayList<Integer> A, int l, int mid, int r) {
        int[] C = new int[r-l+1];
        int a=l,b=mid+1,c=0,count=0;
        while(a<=mid && b<=r){
            if(A.get(a)>A.get(b)) {
                count+=(mid-a+1);
                C[c] = A.get(b);
                b++;
            }else{
                C[c] = A.get(a);
                a++;
            }
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
        return count;
    }
}
