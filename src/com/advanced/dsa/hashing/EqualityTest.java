/**
 *  Equal
 *
 *  Problem Description
 * Given an array A of N integers, find the index of values that satisfy P + Q = R + S, where P, Q, R & S are integers values in the array
 *
 * Expected time complexity O(N2)
 *
 * NOTE:
 *
 * 1) Return the indices `A1 B1 C1 D1`, so that
 *   A[A1] + A[B1] = A[C1] + A[D1]
 *   A1 < B1, C1 < D1
 *   A1 < C1, B1 != D1, B1 != C1
 *
 * 2) If there are more than one solutions,
 *    then return the tuple of values which are lexicographical smallest.
 *
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices in the array )
 * S2 : A2 B2 C2 D2
 *
 * S1 is lexicographically smaller than S2 if:
 *   A1 < A2 OR
 *   A1 = A2 AND B1 < B2 OR
 *   A1 = A2 AND B1 = B2 AND C1 < C2 OR
 *   A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 * If no solution is possible, return an empty list.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 0 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A of length N.
 *
 *
 *
 * Output Format
 * Return an array of size four which contains indices of values P, Q, R, and S.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 4, 7, 1, 2, 9, 8]
 * Input 2:
 *
 *  A = [2, 5, 1, 6]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [0, 2, 3, 5]
 * Output 2:
 *
 *  [0, 1, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  A[0] + A[2] = A[3] + A[5]
 *  Note: indexes returned should be 0-based.
 * Explanation 2:
 *
 *  A[0] + A[1] = A[2] + A[3]
 */
package com.advanced.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class EqualityTest {

    public static void main(String[] args){
        /*
        Loop i = 1 to N :
            Loop j = i + 1 to N :
                calculate sum
                If in the hash table any index already exists for sum, then
                    try to find out whether it is a valid solution or not. If yes, then update the solution
                update hash table
            EndLoop;
        EndLoop;
         */
        int[] a = new int[]{ 0, 0, 1, 0, 2, 1 };
        System.out.println(equal(a));
    }
    public static int[] equal(int[] A) {
        int[] result = new int[0];
        int n=A.length;
        Map<Integer,int[]> map = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = A[i]+A[j];
                int[] indices = map.get(sum);
                if(indices == null){
                    indices = new int[4];
                    indices[0] = i;
                    indices[1] = j;
                    indices[2] = -1;
                    indices[3] = -1;

                }else if(i!=indices[1] && (( i>indices[0] && j> indices[1] && indices[2]==-1 && indices[3] == -1) ||
                        ( i>indices[0] && j> indices[1] && indices[2]>i && indices[3] > j))){
                    indices[2] = i;
                    indices[3] = j;
                }
                map.put(sum,indices);
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i]+A[j];
                int[] indices = map.get(sum);
                if(indices != null && indices[2]!=-1 && indices[3]!=-1){
                    int[] result1 = new int[4];
                    result1[0] = indices[0];
                    result1[1] = indices[1];
                    result1[2] = indices[2];
                    result1[3] = indices[3];
                    return result1;
                }
            }
        }
        return result;
    }
}
