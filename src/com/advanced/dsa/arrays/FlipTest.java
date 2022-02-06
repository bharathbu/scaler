/**
 * Flip
 *
 * Problem Description
 *
 * You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, …, AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, …, AR. By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 *
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
 * If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= size of string <= 100000
 *
 *
 *
 * Input Format
 *
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 *
 * Return an array of integers denoting the answer.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = "010"
 * Input 2:
 *
 * A = "111"
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [1, 1]
 * Output 2:
 *
 * []
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * A = "010"
 *
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | "110"
 * [1 2]          | "100"
 * [1 3]          | "101"
 * [2 2]          | "000"
 * [2 3]          | "001"
 *
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 * Explanation 2:
 *
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;

public class FlipTest {
    public static void main(String args[]){
        //String A = "100100111101";
        String A = "010";
        //String A = "0111000100010"; //5,11
        //String A = "1101010001"; //3,9
        System.out.println(flip(A));
    }

    public static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = A.length(),temp=0,ltemp=0,r=0,l=0,count=0,maxCount=Integer.MIN_VALUE;
        //Apply Kadane's algorithm
        for(int i=0;i<n;i++){
            temp = A.charAt(i)-'0';
            if(temp == 0)
                count++;
            else count--;

            if(count>maxCount){
                maxCount = count;
                l = ltemp;
                r = i;
            }
            if(count<0){
                count=0;
                ltemp = i+1;
            }

        }
        if(maxCount>0){
            result.add(l+1);
            result.add(r+1);
        }

        return result;
    }
}
