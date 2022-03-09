/**
 * Equilibrium index of an array
 *
 * Problem Description
 *
 * You are given an array A of integers of size N.
 *
 * Your task is to find the equilibrium index of the given array
 *
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 *
 * NOTE:
 *
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 *
 *
 * Input Format
 *
 * First arugment is an array A .
 *
 *
 * Output Format
 *
 * Return the equilibrium index of the given array. If no such index is found then return -1.
 *
 *
 * Example Input
 *
 * Input 1:
 * A=[-7, 1, 5, 2, -4, 3, 0]
 * Input 2:
 *
 * A=[1,2,3]
 *
 *
 * Example Output
 *
 * Output 1:
 * 3
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * Explanation 1:
 *
 * There is no such index.
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;

public class EquilibriumIndexTest {
    public static void main(String[] args){
        ArrayList<Integer> d1 = new ArrayList<Integer>();
        d1.add(-7);d1.add(1);d1.add(5);d1.add(2);d1.add(-4);d1.add(3);d1.add(0);
        System.out.println(solve(d1));
    }

    public static int solve(ArrayList<Integer> A) {
        /*int result = -1,n=A.size();
        ArrayList<Integer> lps = new ArrayList<Integer>();
        ArrayList<Integer> rps = new ArrayList<Integer>();
        lps.add(A.get(0));
        for(int i=1;i<n;i++)
            lps.add(lps.get(i-1)+A.get(i));
        rps.add(A.get(n-1));
        for(int i=n-2;i>=0;i--)
            rps.add(rps.get(n-i-2)+A.get(i));
        for(int i=0;i<n-1;i++){
            if(lps.get(i) == rps.get(n-i-1)){
                result=i;
                break;
            }
        }
        return result;*/

        int result = -1,n=A.size();
        ArrayList<Integer> ps = new ArrayList<Integer>();
        ps.add(A.get(0));
        for(int i=1;i<n;i++)
            ps.add(ps.get(i-1)+A.get(i));
        for(int i=1;i<n-1;i++){
            if(ps.get(n-1)-ps.get(i) == ps.get(i-1)){
                result=i;
                break;
            }
        }
        if(result == -1)
            if( ps.get(n-2) == 0)
                result=n-1;
            else if(ps.get(n-1)-ps.get(0) == 0)
                result=0;
        return result;
    }
}
