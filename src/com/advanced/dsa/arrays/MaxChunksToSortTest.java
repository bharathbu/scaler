/**
 * Max Chunks To Make Sorted
 *
 * Problem Description
 *
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, …, (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 *
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 *
 * Return the maximum number of chunks that we could have made.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 0]
 * Input 2:
 *
 *  A = [2, 0, 1, 3]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A = [1, 2, 3, 4, 0]
 *  To get the 0 in the first index, we have to take all elements in a single chunk.
 * Explanation 2:
 *
 *  A = [2, 0, 1, 3]
 *  We can divide the array into 2 chunks.
 *  First chunk is [2, 0, 1] and second chunk is [3].
 *
 *
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxChunksToSortTest {
    public static void main(String args[]) {
        int[] ints = {6, 50, 16, 30, 37, 12, 43, 52, 24, 2, 53, 28, 31, 36, 10, 32, 51, 60, 64, 38, 3, 46, 7,
                4, 55, 72, 75, 66, 73, 68, 54, 22, 25, 65, 5, 49, 0, 8, 47, 78, 35, 57, 83, 90, 27, 9, 19, 26,
                76, 41, 39, 40, 1, 11, 67, 61, 71, 56, 58, 108, 110, 102, 15, 70, 59, 14, 42, 23, 29, 20, 118,
                13, 106, 17, 69, 18, 21, 34, 44, 62, 33, 80, 45, 87, 48, 63, 74, 131, 134, 111, 77, 79, 81, 139,
                132, 124, 82, 84, 85, 86, 88, 89, 91, 92, 93, 130, 94, 98, 95, 96, 151, 97, 99, 100, 109, 101, 142,
                103, 143, 104, 105, 146, 107, 112, 113, 138, 114, 115, 116, 117, 160, 119, 120, 148, 145, 121, 122,
                123, 125, 126, 127, 135, 128, 153, 129, 133, 144, 136, 137, 140, 141, 147, 149, 150, 152, 154, 155, 156, 157, 158, 159};
       // int[] ints = {1,2,0,4,6,5,3,7,8};
        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int chunks=0,max=0,n=A.size(),temp;
        for(int i=0;i<n;i++){
            temp=A.get(i);
            if(temp>max)
                max=temp;
            if(i==max){
                chunks++;
                max=0;
            }
        }
        return chunks;
    }

}
