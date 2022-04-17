/**
 *  B Closest Points to Origin
 *
 *  Problem Description
 * We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
 *
 * Here, the distance between two points on a plane is the Euclidean distance.
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
 *
 *
 *
 * Problem Constraints
 * 1 <= B <= length of the list A <= 105
 * -105 <= A[i][0] <= 105
 * -105 <= A[i][1] <= 105
 *
 *
 *
 * Input Format
 * The argument given is list A and an integer B.
 *
 *
 *
 * Output Format
 * Return the B closest points to the origin (0, 0) in any order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [1, 3],
 *        [-2, 2]
 *      ]
 *  B = 1
 * Input 2:
 *
 *  A = [
 *        [1, -1],
 *        [2, -1]
 *      ]
 *  B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  [ [-2, 2] ]
 * Output 2:
 *
 *  [ [1, -1] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 *  So one closest point will be [-2,2].
 * Explanation 2:
 *
 *  The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 *  So one closest point will be [1,-1].
 */
package com.advanced.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BClosestPoints {
    public static void main(String[] args){
        int[][] A = {{1, 3},
                {-2, 2}};
        System.out.println(solve(A,1));
    }
    public static int[][] solve(int[][] A, int B) {
        /*
        Sort the list of these points with respect to the distance from the origin.
        We can do this with the help of a comparator function, which takes two elements of the array as input
        and returns which one will be smaller than the other. So basically, it takes care of the comparison process.

        After the list is sorted, take the first B elements from the list and create a new list and return it.
        Think of calculating the Euclidean distance and storing it efficiently.

        Time Complexity - O(N log N)
        Space Complexity - O(N)
         */
        int n=A.length,m=A[0].length;
        int[][] res = new int[B][m];
        if(n==B)
            return A;
        else{
            Arrays.sort(A, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    long a=0,b=0;
                    a = (o1[0]*o1[0])+(o1[1]*o1[1]);
                    //a = (long) Math.pow(a,0.5);
                    b = (o2[0]*o2[0])+(o2[1]*o2[1]);
                    //b = (long) Math.pow(b,0.5);
                    return (int) (a-b);
                }
            });

            for (int i = 0; i < B; i++) {
                res[i] = A[i];
            }
        }

    return res;

    }

}
