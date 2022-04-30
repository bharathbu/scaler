/**
 * Pairs with Given Difference
 *
 * Problem Description
 * Given an one-dimensional integer array A of size N and an integer B.
 *
 * Count all distinct pairs with difference equal to B.
 *
 * Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 104
 *
 * 0 <= A[i], B <= 105
 *
 *
 *
 * Input Format
 * First argument is an one-dimensional integer array A of size N.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the count of all distinct pairs with difference equal to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 5, 3, 4, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [8, 12, 16, 4, 0, 20]
 *  B = 4
 * Input 3:
 *
 *  A = [1, 1, 1, 2, 2]
 *  B = 0
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  5
 * Output 3:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
 * Explanation 2:
 *
 *  There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
 * Explanation 3:
 *
 *  There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
package com.advanced.dsa.twopointers;

import java.util.Arrays;

public class PairsWithGivenDeiff {

    public static void main(String[] args){
        /*
        Let us formulate a two pointer approach to the this problem.
        We will first sort the given array and use two pointers i and j with i = 0, j = 1.
        We will have three conditions:

        1. A[j] - A[i] < B --> We will increase the pointer j.
        2. A[j] - A[i] > B --> We will increase the pointer i.
        3. A[j] - A[-] = B --> We will increase both the pointers and add 1 to the answer.

        Refer to the complete solution for more details.
         */
        int[] a = new int[]{8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a, 3));

    }

    public static int solve(int[] A, int B) {
        int res = 0,n=A.length;
        int p1=0,p2=1;
        Arrays.sort(A);
        while(p2<n){
            int diff = A[p2]-A[p1];
            if(diff == B){
                res++;
                while((p2+1)<n && A[p2] == A[p2+1])
                    p2+=1;
                p2++;
            }else if(diff<B)
                p2++;
            else{
                p1++;
                if(p1==p2)
                    p2++;
            }
        }
        return res;
    }
}
