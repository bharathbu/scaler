package com.advanced.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePairs {

    static int count=0;
    public static void main(String[] args){
        Integer[] a = new Integer[]{1, 2, 3, 3, 1};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve( A));
    }

    public static int solve(ArrayList<Integer> A) {
        int n = A.size();
        mergeSort(A,0,n-1);
        return count;
    }

    private static void mergeSort(ArrayList<Integer> a, int l, int r) {
        if(l == r) return;
        int mid = (l+r)/2;
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        merge(a,l,mid,r);
        return;
    }

    private static void merge(ArrayList<Integer> A, int l, int mid, int r) {
        int[] C = new int[r-l+1];
        int a=l,b=mid+1,c=0;
        while(a<=mid && b<=r){
            if(A.get(a)>A.get(b)) {
                if(A.get(a)>(2*A.get(b))) {
                    count+=(mid-a+1);
                }
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
        return;
    }
}
