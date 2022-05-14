/**
 * Cyclic Permutations
 *
 * Problem Description
 * Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.
 *
 * NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
 *
 *
 *
 * Problem Constraints
 * 1 ≤ length(A) = length(B) ≤ 105
 *
 *
 *
 * Input Format
 * The first argument is a string A.
 * The second argument is a string B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the required answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "1001"
 *  B = "0011"
 * Input 2:
 *
 *  A = "111"
 *  B = "111"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".
 *  There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.
 * Explanation 2:
 *
 *  All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */
package com.advanced.dsa.patternmatching;

public class CyclicPermutations {

    public static void main(String[] args){
        /**
         * We know that the Xor of two elements is zero only when both the elements are equal.
         *
         * We have to check if the A == B or not. To overcome the cyclic permutation problem, we can append the string A[0:len(A)-1] to A
         *
         * For example : if A = “abc”, After appending the string A[0:len(A)-1] to A, A becomes “abcab”.
         *
         * Now, we have to find the number of occurrences of the string B in string A. We can use any string matching algorithm like the KMP Z algorithm to find the number of occurrences
         */
        System.out.println(solve("111","111"));
    }
    public static int solve(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A).append('$').append(B).append(B);
        int[] lps = LPS.constructLPS(sb.toString());
        int n=lps.length,sizeB=B.length(),count=0;
        for (int i = 0; i < n; i++) {
            if(lps[i] == sizeB)
                count++;
        }
        int ans=count;
        if(A.equals(B))
            ans=ans-1;
        return ans;
    }
}
