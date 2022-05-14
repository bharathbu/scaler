/**
 * Family of Strings
 *
 * Problem Description
 *
 * You are given a family of strings. Where S0 = "0". Each successive string is derived from previous string using the following recursive relation.
 *
 * Si = Si-1 + "0" + (Si-1)'. Where (S)' means compliment of that string.
 *
 * For example:
 *
 * S0 = "0"
 * S1 = "001"
 * S2 = "0010110"
 * ….
 * Given A and B your task is to find the Bth character in SA.
 * Note: B is 0 based indexing
 *
 *
 * Problem Constraints
 *
 * 0 <= A <= 50
 *
 * 0 <= K <= min(109,2(A+1)-1))
 *
 *
 * Input Format
 *
 * First argument contains integer A
 *
 * Second argument contains integer B
 *
 *
 * Output Format
 *
 * Return a single integer 0 or 1 to answer the question.
 *
 *
 * Example Input
 *
 * Input1:
 * A = 2
 * B = 3
 *
 * Input2:
 *
 * A = 3
 * B = 4
 *
 *
 * Example Output
 *
 * Output1:
 *     0
 *
 * Output2:
 *
 *     1
 *
 *
 * Example Explanation
 *
 * Explaination1:
 * S2 = "0010110"
 * Hence using 0 based indexing S2[3] = "0"
 *
 * Explaination2:
 *
 * S3 = "001011001101001"
 * Hence using 0 based indexing S2[4] = "1"
 */
package com.advanced.dsa.hashing;

public class FamilyStrings {

    public static void main(String[] args){
        /*
        Since each string contains 0 in the middle. And left part of each string is same as the previous string, so if we jump to the
        middle character of left part it will be the same as current middle character. And an opposite trend is observed on the
        right side.
        Hence we can perform a binary search to look for the Bth character.
        We start with ans = 0.
        If we go to the left we do not change the current ans and if we go to right we make ans = ans^1.
         */
        System.out.println(solve(37,897517431));
    }
    public static int solve(int A, int B) {
        int l=0;
        int h= (int) (Math.pow(2,A+1)-2),mid=0;
        int ans=0;
        while(l<=h){
            mid = (l+(h-l)/2);
            if(mid==B)
                return ans;
            else if(mid<B){
                ans=(1-ans);
                l= (int) (mid+1);
            }else
                h=mid-1;
        }
        return ans;
    }
}
