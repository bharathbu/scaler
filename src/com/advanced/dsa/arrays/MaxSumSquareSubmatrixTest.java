/**
 * Maximum Sum Square SubMatrix
 *
 * Problem Description
 * Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 103.
 *
 * 1 <= B <= N
 *
 * -102 <= A[i][j] <= 102.
 *
 *
 *
 * Input Format
 * First arguement is an 2D integer matrix A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum sum of submatrix of size B x B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *         [1, 1, 1, 1, 1]
 *         [2, 2, 2, 2, 2]
 *         [3, 8, 6, 7, 3]
 *         [4, 4, 4, 4, 4]
 *         [5, 5, 5, 5, 5]
 *      ]
 *  B = 3
 * Input 2:
 *
 *  A = [
 *         [2, 2]
 *         [2, 2]
 *     ]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  48
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *     Maximum sum 3 x 3 matrix is
 *     8 6 7
 *     4 4 4
 *     5 5 5
 *     Sum = 48
 * Explanation 2:
 *
 *  Maximum sum 2 x 2 matrix is
 *   2 2
 *   2 2
 *   Sum = 8
 *
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;

public class MaxSumSquareSubmatrixTest {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> d1 = new ArrayList<Integer>();
        d1.add(1);d1.add(1);d1.add(1);d1.add(1);d1.add(1);
        ArrayList<Integer> d2 = new ArrayList<Integer>();
        d2.add(2);d2.add(2);d2.add(2);d2.add(2);d1.add(2);
        ArrayList<Integer> d3 = new ArrayList<Integer>();
        d3.add(3);d3.add(8);d3.add(6);d3.add(7);d1.add(3);
        ArrayList<Integer> d4 = new ArrayList<Integer>();
        d4.add(4);d4.add(4);d4.add(4);d4.add(4);d1.add(4);
        ArrayList<Integer> d5 = new ArrayList<Integer>();
        d5.add(5);d5.add(5);d5.add(5);d5.add(5);d5.add(5);
        A.add(d1);
        A.add(d2);
        A.add(d3);
        A.add(d4);
        A.add(d5);
        System.out.println(solve(A,3))
        ;
    }
    public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int result=-1;

        return result;
    }
}
