/**
 * Special Integer
 *
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the maximum value of K (sub array length).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 * B = 130
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 *
 * Constraints are satisfied for maximal value of 3.
 */
package com.advanced.dsa.Searching;

public class SpecialInteger {

    public static void main(String[] args){
        /*
        You need to find the maximal K.
        Think of a way to do this by binary search.
        You can use binary seacrh to find if a certain K is allowed or not.
        if it is, you try finding a bigger answer
        if not, try finding a smaller answer.
        int l = 1, r = a.length;
        while(l <= r) {
        int m = (l + r) » 1;
        if(check(a, b, m)) l = m + 1;
        else r = m - 1;
        }
        return l-1;
         */
        int[] a = new int[]{1,2,3,4,5};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a,10));
    }

    public static int solve(int[] A, int B) {
        int n=A.length;
        int l=0,h=n,mid=0,ans=0;
        long k = 0;
        while(l<=h){
            mid = (l+h)/2;
            k = subArraySumMax(A,n,mid);
            if(k<=B){
                ans=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }

    public static long subArraySumMax(int[] A, int n, int k){
        long max=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<k;i++){
            sum+=A[i];
        }
        if(sum>max)
            max=sum;
        for(int i=1;i<n-k+1;i++){
            sum-=A[i-1];
            sum+=A[i+k-1];
            if(sum>max)
                max=sum;
        }
        return max;
    }
}
