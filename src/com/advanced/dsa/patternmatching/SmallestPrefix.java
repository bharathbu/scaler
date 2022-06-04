/**
 * Smallest Prefix String
 *
 * Problem Description
 * Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
 * Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 100000
 *
 *
 *
 * Input Format
 * The first argument is a string A of size N.
 * The second argument is a string B of size M.
 *
 *
 *
 * Output Format
 * Return lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abba"
 *  B = "cdd"
 * Input 2:
 *
 *  A = "acd"
 *  B = "bay"
 *
 *
 * Example Output
 * Output 1:
 *
 *  "abbac"
 * Output 2:
 *
 *  "ab"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
 *  The lexicographically smallest string will be "abbac".
 * Explanation 2:
 *
 *  We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
 *  The lexicographically smallest string will be "ab".
 */
package com.advanced.dsa.patternmatching;

/*
The first character of both the first and second strings will be in the answer string.
But how many characters of the first string should be appended before taking the first character of the second string?
Formally, what length prefix of the first string should be appended to the answer string to make it lexicographically smallest
before adding the first character of the second string.

Adding to the hint, we keep appending characters from the first string till the current character is less than the first character of the second string.
After that, we add the first character of the second string, and we have our answer.
(Since we want the lexicographically smallest string)

Time Complexity:- O(	A	)
 */
public class SmallestPrefix {
    public String smallestPrefix(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A.charAt(0));
        int i=1,n=A.length();
        char bVal = B.charAt(0);
        while(i<n && A.charAt(i) <= bVal){
            sb.append(A.charAt(i));
            if(A.charAt(i)==bVal)
                return sb.toString();
            i++;
        }
        sb.append(bVal);
        return sb.toString();
    }
}
