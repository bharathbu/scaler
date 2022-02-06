/**
 *  Sum of all Submatrices
 *
 * Problem Description
 *
 * Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible submatrices.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <=30
 *
 * 0 <= A[i][j] <= 10
 *
 *
 *
 * Input Format
 *
 * Single argument representing a 2-D array A of size N x N.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the sum of all possible submatrices in the given matrix.
 *
 *
 *
 * Example Input
 *
 * A = [ [1, 1]
 *       [1, 1] ]
 *
 *
 * Example Output
 *
 * 16
 *
 *
 * Example Explanation
 *
 * Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
 * Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
 * Number of submatrices with 3 elements = 0
 * Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
 * Total Sum = 4+8+4 = 16
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;

public class SumOfAllSubmatricesTest {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> d1 = new ArrayList<Integer>();
        d1.add(9);d1.add(6);
        ArrayList<Integer> d2 = new ArrayList<Integer>();
        d2.add(5);d2.add(4);
        A.add(d1);
        A.add(d2);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int totalSum=0,n=A.size(),m=A.get(0).size(),contribution=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                contribution = (i+1)*(j+1)*(n-i)*(m-j)*A.get(i).get(j);
                totalSum += contribution;
            }
        }
        return totalSum;
    }
}
