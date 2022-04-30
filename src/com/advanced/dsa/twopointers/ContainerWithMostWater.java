/**
 * Container With Most Water
 *
 * Problem Description
 *
 * Given n non-negative integers A[0], A[1], …, A[n-1] , where each represents a point at coordinate (i, A[i]).
 *
 * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
 *
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= N <= 105
 *
 * 1 <= A[i] <= 105
 *
 *
 *
 * Input Format
 *
 * Single Argument representing a 1-D array A.
 *
 *
 *
 * Output Format
 *
 * Return single Integer denoting the maximum area you can obtain.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 5, 4, 3]
 * Input 2:
 *
 * A = [1]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 * 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
 * So total area = 3 * 2 = 6
 * Explanation 2:
 *
 *
 * No container is formed.
 */
package com.advanced.dsa.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args){
        /*
        Description of approach 1:

        Note 1: When you consider a1 and aN, then the area is (N-1) * min(a1, aN).
        Note 2: The base (N-1) is the maximum possible.
        This implies that if there was a better solution possible, it will definitely have height greater than min(a1, aN).

        B * H > (N-1) * min(a1, aN)
        We know that, B < (N-1)
        So, H > min(a1, aN)

        This means that we can discard min(a1, aN) from our set and look to solve this problem again from the start.
        If a1 < aN, then the problem reduces to solving the same thing for a2, aN.
        Else, it reduces to solving the same thing for a1, aN-1
         */
        int[] a = new int[]{1,5,4,3};
        System.out.println(maxArea(a));

    }
    public static int maxArea(int[] A) {
        int res = 0,n=A.length,p1=0,p2=n-1;

        while(p1<p2){
            int width = p2-p1;
            int height = Math.min(A[p1],A[p2]);

            int area = width*height;
            if(area > res)
                res=area;
            if(A[p1] <= A[p2])
                p1++;
            else if(A[p1] > A[p2])
                p2--;

        }

        return res;

    }
}
