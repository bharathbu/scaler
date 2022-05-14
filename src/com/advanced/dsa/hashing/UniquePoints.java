/**
 *  Unique 2D points
 *
 *  Problem Description
 * Given a 2D array A of integer points on a 2D plane. Find and return the number of unique points in the array.
 * The ith point in the array is (A[i][0], A[i][1])
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 105
 * -109 <= A[i][0], A[i][1] <= 109
 *
 *
 * Input Format
 * The first argument is a 2D integer array A.
 *
 *
 * Output Format
 * Return an integer that is the number of unique points.
 *
 *
 * Example Input
 * Input:
 * A = [[5, 6],
 *      [2, 8],
 *      [-1, -1],
 *      [2, -3],
 *      [2, 8],
 *      [7, 7],
 *      [2, -3]]
 *
 *
 * Example Output
 * Output:
 * 5
 *
 *
 * Example Explanation
 * Explanation:
 * There are 5 unique points in the given array.
 */
package com.advanced.dsa.hashing;

import java.util.HashSet;
import java.util.Set;

public class UniquePoints {

    public static void main(String[] args){
        /*

         */
        int[][] a = new int[][]{{5,6},
                {2,8},{-1,-1},{2,-3},{2,8},{7,7},{2,-3}};
        int[] b = new int[]{1, 2, 1, 2, 1};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a));

    }
    public static int solve(int[][] A) {
        int n=A.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(A[i][0]+","+A[i][1]);

        return set.size();
    }
}
