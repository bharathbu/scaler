/**
 *  Delete one
 *
 *  Problem Description
 *
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
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
 * Return an integer denoting the maximum value of GCD.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [12, 15, 18]
 * Input 2:
 *
 *  A = [5, 15, 30]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  15
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 *  If you delete 12, gcd will be 3.
 *  If you delete 15, gcd will be 6.
 *  If you delete 18, gcd will 3.
 *  Maximum vallue of gcd is 6.
 * Explanation 2:
 *
 *  If you delete 5, gcd will be 15.
 *  If you delete 15, gcd will be 5.
 *  If you delete 30, gcd will be 5.
 */
package com.advanced.dsa.math;

public class DeleteOneGCDTest {

    public static void main(String[] args){
        int[] A = {5,15,30};
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        /*
        We can maintain two arrays for prefix and suffix gcd; likewise, we do for prefix sum and suffix sum.
        Then,for each index, i:1 to N calculate gcd(prefix[i-1],suffix[i+1]) and return the maximum among all.
         */
        int n = A.length,gcd=0,result=Integer.MIN_VALUE;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i=0;i<n;i++){
            gcd = gcd(gcd,A[i]);
            prefix[i]=gcd;
        }
        gcd=0;
        for(int i=0;i<n;i++){
            gcd = gcd(gcd,A[n-i-1]);
            suffix[n-i-1]=gcd;
        }
        result=suffix[1];
        for(int i=1;i<n-1;i++){
            gcd = gcd(prefix[i-1],suffix[i+1]);
            if(gcd>result)
                result=gcd;
        }
        if(prefix[n-2]>result)
            result=prefix[n-2];
        return  result;
    }

    public static int gcd(int A, int B) {
        if(B==0)
            return A;
        return gcd(B,A%B);
    }
}
