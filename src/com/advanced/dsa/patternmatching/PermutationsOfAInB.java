/**
 * Permutations of A in B
 *
 * Problem Description
 * You are given two strings, A and B, of size N and M, respectively.
 *
 * You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
 *
 *
 *
 * Problem Constraints
 * 1 <= N < M <= 105
 *
 *
 *
 * Input Format
 * Given two arguments, A and B of type String.
 *
 *
 *
 * Output Format
 * Return a single integer, i.e., number of permutations of A present in B as a substring.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abc"
 *  B = "abcbacabc"
 * Input 2:
 *
 *  A = "aca"
 *  B = "acaa"
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. abc
 *     2. cba
 *     3. bac
 *     4. cab
 *     5. abc
 *     So ans is 5.
 * Explanation 2:
 *
 *  Permutations of A that are present in B as substring are:
 *     1. aca
 *     2. caa
 */
package com.advanced.dsa.patternmatching;

public class PermutationsOfAInB {

    public int solve(String A, String B) {
        int [] a_count = new int[26];
        int [] b_count = new int[26];

        int count = 26;
        int res = 0;
        int len = A.length();

        for(int i = 0; i < len; i++){
            a_count[A.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;

        while(right < B.length()){
            b_count[B.charAt(right) - 'a']++;

            if( right - left + 1 == len){
                for(int i = 0; i < 26; i++){
                    if(a_count[i] != b_count[i]){
                        count--;
                    }
                }
                if(count == 26){
                    res++;
                }
                b_count[B.charAt(left) - 'a']--;
                left++;
            }
            right++;
            count = 26;
        }
        return res;
    }
}
