/**
 * Maximum Absolute Difference
 *
 * Problem Description
 *
 * You are given an array of N integers, A1, A2, …. AN.
 *
 * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum value of f(i, j).
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 3, -1]
 * Input 2:
 *
 *
 * A = [2]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 5
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 * Explanation 2:
 *
 * Only possibility is i = 1 and j = 1. That gives answer = 0.
 *
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxAbsoluteDifferenceTest {
    public static void main(String args[]) {
        int[] ints = {-98, -5, 37, -97, 38, 22, 70, 42, 61, 84};
        ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(ints).boxed().collect(Collectors.toList());
        //A.add(2);A.add(3);A.add(1);A.add(2);
        //A.add(10);A.add(-1);A.add(2);A.add(3);A.add(-4);A.add(100);
        //A.add(1);A.add(2);A.add(5);A.add(-9);
        /*A.add(10);A.add(-1);A.add(1);A.add(3);A.add(9);A.add(11);
        A.add(9);A.add(-5);A.add(6);A.add(7);A.add(-4);A.add(100);*/
        System.out.println(maxArr(A));
    }

    public static int maxArr(ArrayList<Integer> A) {
        int result=0,n=A.size(),case1Max=0,case2Max=0,temp=0,xMax=Integer.MIN_VALUE,xMin=Integer.MAX_VALUE,yMax=Integer.MIN_VALUE,yMin=Integer.MAX_VALUE;
        /*
        Case 1:
            Ai <= Aj
            f(i,j) = (Aj-Ai)+(j-i)
                   = (Aj+j)-(Ai-i)
            Xi = Ai + i;
            case1Max = Xmax-Xmin

        Case 2:
            Ai > Aj
            f(i,j) = (Ai-Aj)+(i-j)
                   = (Ai-i)-(Aj-j)
            Yk = Ak - k;
            case2Max = Ymax-Ymin
         */


        for(int i=0;i<n;i++){
            temp = A.get(i)+i;
            if(temp>xMax)
                xMax = temp;
            if(temp < xMin)
                xMin = temp;

            temp = A.get(i)-i;
            if(temp>yMax)
                yMax = temp;
            if(temp < yMin)
                yMin = temp;
        }
        case1Max = xMax-xMin;
        case2Max = yMax-yMin;
        if(case1Max>case2Max)
            result=case1Max;
        else
            result = case2Max;
        return result;
    }
}
