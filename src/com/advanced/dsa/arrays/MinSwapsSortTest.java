/**
 * Minimum Swaps
 *
 * Problem Description
 *
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 *
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * -109 <= A[i], B <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the minimum number of swaps.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  B = 8
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 20
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 *  After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 *  Now, all elements less than or equal to 8 are together.
 * Explanation 2:
 *
 *  A = [5, 17, 100, 11]
 *  After swapping 100 and 11, A => [5, 17, 11, 100].
 *  Now, all elements less than or equal to 20 are together.
 */
package com.advanced.dsa.arrays;

public class MinSwapsSortTest {
    public static void main(String[] args){
        int[] A = {5, 17, 100, 11};
        int B = 20;
        System.out.println(solve(A,B));
    }

    public static int solve(int[] A, int B) {
        /*
        First, we will find the number of elements that are less than or equal to B. Let the count comes out to be X.

        We know that we need at most X-1 swaps to make all X elements to be consecutive.
        Maintain a window of X and check how many elements we need to swap so that all X elements come in that window.

        We store the minimum of all that and return that.
         */
        int n=A.length,ans=0,count=0;
        for(int i=0;i<n;i++){
            if(A[i]<=B)
                count++;
        }

        if(count<=1){
            return 0; //No swaps are required here.
        }else{
            int r=0,l=0,x=0;//x has bad number count
            while(r<count){
                if(A[r]>B)
                    x++;
                r++;
            }
            ans=x;

            //sliding window starts here
            while(r<n){
                if(A[r]>B)
                    x++;
                if(A[l]>B)
                    x--;
                ans=Math.min(ans,x);
                r++;
                l++;
            }
        }

        return ans;
    }
}
