/**
 * Search in Bitonic Array!
 *
 * Problem Description
 * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.
 *
 * NOTE:
 *
 * A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
 *
 *
 * Problem Constraints
 * 3 <= N <= 105
 *
 * 1 <= A[i], B <= 108
 *
 * Given array always contain a bitonic point.
 *
 * Array A always contain distinct elements.
 *
 *
 *
 * Input Format
 * First argument is an integer array A denoting the bitonic sequence.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 9, 10, 20, 17, 5, 1]
 *  B = 20
 * Input 2:
 *
 *  A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 *  B = 30
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  B = 20 present in A at index 3
 * Explanation 2:
 *
 *  B = 30 is not present in A
 */
package com.advanced.dsa.Searching;

public class BitonicArray {
    public static void main(String[] args){
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a,12));

    }

    public static int solve(int[] A, int B) {
        int res=-1,n=A.length,l=0,r=n-1,mid=0;

        int localMaxima = find(A);
        int indexAsc = bsAsc(A,0,localMaxima-1,B);
        int indexDsc = bsDsc(A,localMaxima,n-1,B);
        if(indexAsc == -1) return indexDsc;
        else return indexAsc;
    }

    private static int bsDsc(int[] A, int l, int r, int t) {
        int res=-1,mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(A[mid] == t) return mid;
            else if(A[mid] >t) l=mid+1;
            else r=mid-1;
        }
        return res;
    }

    private static int bsAsc(int[] A, int l, int r, int t) {
        int res=-1,mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(A[mid] == t) return mid;
            else if(A[mid] >t) r=mid-1;
            else l=mid+1;
        }
        return res;
    }

    private static int find(int[] A) {
        int n = A.length;
        if(n==1 || A[0] >A[1]) return 0;
        if(A[n-1] > A[n-1]) return n-1;
        int l=1,r=n-2,mid=0;
        while(l<=r){
            mid = l+(r-l)/2;
            if(A[mid] > A[mid+1] && A[mid]>A[mid-1])
                return mid;
            else if(A[mid] < A[mid+1])
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
}
