/**
 * Alternate positive and negative elements
 *
 * Problem Description
 * Given an array of integers A, arrange them in an alternate fashion such that every non-negative number is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance. The number of non-negative and negative numbers need not be equal.
 *
 * If there are more non-negative numbers, they appear at the end of the array. If there are more negative numbers, they also appear at the array's end.
 *
 * Note: Try solving with O(1) extra space.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 7000
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the modified array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [-1, -2, -3, 4, 5]
 * Input 2:
 *
 *  A = [5, -17, -100, -11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [-1, 4, -2, 5, -3]
 * Output 2:
 *
 *  [-17, 5, -100, -11]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A = [-1, -2, -3, 4, 5]
 * Move 4 in between -1 and -2, A => [-1, 4, -2, -3, 5]
 * Move 5 in between -2 and -3, A => [-1, 4, -2, 5, -3]
 */
package com.advanced.dsa.sorting;

public class AlternatePosNegTest {

    public static void main(String[] args){
        int[] A = new int[]{3, 11, -1, 5};
        System.out.println(solve( A));
    }
    public static int[] solve(int[] A) {
        /*
        If extra memory is allowed, we first separate the positive and negative numbers.
        After that, we can merge them by taking elements from both alternatively.

        The above problem can be easily solved if O(n) extra space is allowed. It becomes interesting due to the limitations that O(1) extra space and order of appearances.
        The idea is to process the array from left to right. While processing, find the first out-of-place element in the remaining unprocessed array. An element is out of place if it is negative and at an odd index, positive and even index. Once we find an out-of-place element, we find the first element after it with the opposite sign. We right rotate the subarray between these two elements (including these two).
        // Bonus
        The idea is to process the array and shift all negative values to the end in O(n) time.
        After all negative values are shifted to the end, we can easily rearrange the array in alternating positive & negative items.
        We swap the next positive element at an even position from the next negative element in this step.
         */
        int i = 0;
        int j;

        while (i < A.length) {
            j = i + 1;
            if (i % 2 == 0) {
                if (A[i] >= 0) {
                    while (j < A.length && A[j] >= 0) {
                        j++;
                    }
                    if (rotate(A, i, j)) {
                        break;
                    }
                }
            } else {
                if (A[i] < 0) {
                    while (j < A.length && A[j] < 0) {
                        j++;
                    }
                    if (rotate(A, i, j)) {
                        break;
                    }
                }
            }
            i++;
        }
        return A;
    }

    private static boolean rotate(int[] A, int i, int j) {
        if (j > A.length - 1) {
            return true;
        }
        while (j > i) {
            int tmp = A[j];
            A[j] = A[j - 1];
            A[j - 1] = tmp;
            j--;
        }
        return false;
    }
}
