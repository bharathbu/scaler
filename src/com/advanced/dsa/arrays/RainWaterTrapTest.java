/**
 * Q1. Rain Water Trapped
 *
 * Problem Description

 Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



 Problem Constraints

 1 <= |A| <= 100000



 Input Format

 First and only argument is the vector A



 Output Format

 Return one integer, the answer to the question



 Example Input

 Input 1:

 A = [0, 1, 0, 2]
 Input 2:

 A = [1, 2]


 Example Output

 Output 1:

 1
 Output 2:

 0


 Example Explanation

 Explanation 1:

 1 unit is trapped on top of the 3rd element.
 Explanation 2:

 No water is trapped.
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bharath
 *
 */
public class RainWaterTrapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);A.add(2);A.add(4);A.add(3);A.add(0);A.add(2);A.add(1);A.add(3);
        System.out.println(trap(A));

    }

    public static int trap(final List<Integer> A) {
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
