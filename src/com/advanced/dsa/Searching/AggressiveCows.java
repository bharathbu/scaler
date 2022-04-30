/**
 *  Aggressive cows
 *
 *  Problem Description
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 *
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 *
 *
 *
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return the largest minimum distance possible among the cows.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 * Explanation 2:
 *
 *  The minimum distance will be 1.
 */
package com.advanced.dsa.Searching;

public class AggressiveCows {

    public static void main(String[] args){
        /*
        We’ll do the binary search to find the best possible maximum difference.

        Since the maximum difference ranges between 0 to the max of array.
        If we sort the array, the binary search starts with l = 0 and r = A[n-1], and we’ve to find the maximum distance.
        For mid in binary search, we will check whether there are B stalls such that the minimum distance is greater than equal to mid.
        Finally, store the maximum value we can get.
         */
        int[] a = new int[]{1,2,4,8,9};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a,3));
    }
    public static int solve(int[] A, int B) {
        int n=A.length;
        int ansMin=0, ansMax=A[n-1]-A[0], mid=0,ans=0;
        int l=1,h=ansMax-ansMin;
        while(l<=h){
            mid = (l+h)/2;
            if(check(A,B,mid)){
                ans=mid;
                l=mid+1;
            }else{
                h = mid-1;
            }
        }
        return ans;
    }

    private static boolean check(int[] a, int b, int d) {
        int lastPlaced = a[0];
        int cowPlaced=1,n=a.length;
        for (int i = 1; i < n; i++) {
            if( (a[i]-lastPlaced) >=d ){
                lastPlaced = a[i];
                cowPlaced++;
            }
            if(cowPlaced == b)
                return true;
        }
        return false;
    }
}
