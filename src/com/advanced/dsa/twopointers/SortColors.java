/**
 * Sort by Color
 *
 * Problem Description
 * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.
 *
 * Note: Using the library sort function is not allowed.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 0 <= A[i] <= 2
 *
 *
 * Input Format
 * First and only argument of input contains an integer array A.
 *
 *
 * Output Format
 * Return an integer array in asked order
 *
 *
 * Example Input
 * Input 1 :
 *     A = [0 1 2 0 1 2]
 * Input 2:
 *
 *     A = [0]
 *
 *
 * Example Output
 * Output 1:
 *     [0 0 1 1 2 2]
 * Output 2:
 *
 *     [0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *     [0 0 1 1 2 2] is the required order.
 */
package com.advanced.dsa.twopointers;

public class SortColors {

    /*
    There are multiple approaches possible here. We need to make sure we do not allocate extra memory.

    Approach 1:

    Count the number of red, white, and blue balls.
    Then, in another pass, set the initial redCount number of cells as 0, next whiteCount cell as 1, and next blueCount cells as 2.
    Requires two passes of the array.

    Approach 2:

    Swap the 0s to the start of the array maintaining a pointer, and 2s to the end of the array.
    1s will automatically be in their right position.
     */
    public int[] sortColors(int[] A) {
        int n=A.length,l=0,r=n-1,i=0;
        for (i = 0; i <= r;) {
            if(A[i] == 0){
                int tmp = A[l];
                A[l]=0;
                A[i]=tmp;
                l++;
                i++;

            }else if(A[i] == 2){
                int tmp = A[r];
                A[r]=2;
                A[i]=tmp;
                r--;
            }else i++;
        }
        return A;
    }
}
