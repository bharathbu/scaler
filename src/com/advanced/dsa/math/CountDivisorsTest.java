/**
 * Count of divisors
 *
 * Problem Description
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 *
 * NOTE: The order of the resultant array should be the same as the input array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the count of divisors of each element of the array in the form of an array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 3, 4, 5]
 * Input 2:
 *
 *  A = [8, 9, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 2, 3, 2]
 * Output 1:
 *
 *  [4, 3, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 *  So the count will be [2, 2, 3, 2].
 * Explanation 2:
 *
 *  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 *  So the count will be [4, 3, 4].
 */
package com.advanced.dsa.math;

public class CountDivisorsTest {

    public static void main(String args[]){
        int[] A = {2, 3, 4, 5};
        System.out.println(solve(A));
    }
    public static int[] solve(int[] A) {
        int n = A.length,count=0,max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(A[i]>max)
                max=A[i];
        }
        int[] spf = new int[max+1];
        for (int i = 1; i <= max; i++) {
            spf[i] = i;
        }
        for (int i = 2; i*i < max; i++) {
            if(spf[i] == i){
                for(int j=i*i;j<=max;j+=i){
                    spf[j] = Math.min(spf[j],i);
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = getDivisorCount(A[i],spf);
        }

        return result;
        /*int n = A.length,count=0,temp;
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            temp = A[i];
            count=0;
            for(int j=1;j*j<=temp;j++){
                if(temp%j == 0){
                    //count++;
                    if(temp/j == j)
                        count++;
                    else count=count+2;
                }
            }
            result[i] = count;
        }
        return result;*/
    }

    private static int getDivisorCount(int N, int[] spf) {
        int total=1,temp,c;
        while(N>1){
            c=0;
            temp=spf[N];
            while(N%temp == 0){
                c++;
                N=N/temp;
            }
            total=total*(c+1);
        }
        return total;
    }
}
