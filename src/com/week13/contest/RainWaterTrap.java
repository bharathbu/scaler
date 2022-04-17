/**
 *  Rain Water Trapped
 *
 *  Problem Description
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the vector A
 *
 *
 *
 * Output Format
 * Return one integer, the answer to the question
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [0, 1, 0, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 *
 * No water is trapped.
 */
package com.week13.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrap {

    public static void main(String[] args){
        Integer[] a = new Integer[]{0, 1, 0, 2};
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(trap( A));
    }
    public static int trap(final List<Integer> A) {
        /*
        Take a close look at any particular bin. How high can this hold water? If you can compute the answer to the above question for every bin, you are done.
        Every bin will store water which will depend on some prefix and suffix quantity. Can you figure it out now?

        Instead of calculating area by height*width, we can think it in a cumulative way.
        In other words, we can sum the water amount of each bin(width=1). Search from left to right and maintain a max height of
        left and right separately, which is like a one-side wall of a partial container. Fix the higher one and flow water
        from the lower part. For example, if the current height of the left is lower, we fill water in the left bin. Until the left meets right,
        we filled the whole container.
         */
        int n = A.size(),max = Integer.MIN_VALUE,wi=0,result=0;
        List<Integer> lMax = new ArrayList<Integer>();
        int[] rMax = new int[n];
        //List<Integer> water = new ArrayList<Integer>();

        for(int i=0;i<n;i++) {
            if(A.get(i)>max)
                max = A.get(i);
            lMax.add(max);
        }
        max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--) {
            if(A.get(i)>max)
                max = A.get(i);
            rMax[i]=max;
        }
        for(int i=0;i<n;i++) {
            wi = Math.min(lMax.get(i), rMax[i]);
            //water.add(wi-A.get(i));
            result+=(wi-A.get(i));
        }
        return result;
    }
}
