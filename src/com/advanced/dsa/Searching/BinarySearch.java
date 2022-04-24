package com.advanced.dsa.Searching;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args){
        /*
        You need to return the index of least element >= x.
        You can do this by binary search.
        Note that this is classic binary search. Instead of looking for the element x,
        you are looking for the least elements >= x.
        You can do this by binary search.
        Look for its implementation. There are multiple ways to do this.
        Remember that index starts from 0.
         */
    }

    public int searchInsert(ArrayList<Integer> A, int B) {
        int n=A.size();
        int low=0,high=n-1,mid=0;
        int res=n;
        while(low<=high){
            mid=(low+high)/2;
            if(A.get(mid) == B) return mid;
            else if(A.get(mid) > B) {
                res = Math.min(res, mid);
                //h = mid - 1;
                high = mid-1;
            }
            else low = mid+1;
        }
        /*if(mid == n-1) res=n;
        else if(A.get(mid) < B)  res = mid+1;
        else res=mid;*/
        return res;
    }
}
