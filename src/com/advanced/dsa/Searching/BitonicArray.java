package com.advanced.dsa.Searching;

public class BitonicArray {
    public static void main(String[] args){
        int[] a = new int[]{5, 6, 7, 8, 9, 10, 3, 2, 1};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a,30));

    }

    public static int solve(int[] A, int B) {
        int result=-1,n=A.length,low=0,high=n-1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(A[mid] == B) return mid;
            else if(A[mid] > B){
                if(A[mid] < A[mid+1])
                    high = mid-1;
                else{
                    high=n-1;
                    low=mid+1;
                }

            }
            else {
                if(A[mid] < A[mid+1])
                    low=mid+1;
                else{
                    high=n-1;
                    low=mid+1;
                }
            }
        }
        return result;
    }
}
