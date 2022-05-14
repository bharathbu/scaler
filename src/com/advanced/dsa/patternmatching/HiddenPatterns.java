/**
 *  Hidden Pattern
 *
 *  Problem Description
 *
 * Given two strings - a text A and a pattern B, having lower-case alphabetic characters. You have to determine the number of occurrences of pattern B in text A as its substring. i.e. the number of times B occurs as a substring in A.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |B| <= |A| <= 105
 *
 *
 *
 * Input Format
 *
 * First argument is a string A
 *
 * Second argument is a string B
 *
 *
 *
 * Output Format
 *
 * Return the number of occurrences.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "abababa"
 *  B = "aba"
 * Input 2:
 *
 *  A = "mississipi"
 *  B = "ss"
 * Input 3:
 *
 *  A = "hello"
 *  B = "hi"
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 * Output 3:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A has 3 substrings equal to B - A[1, 3], A[3, 5] and A[5, 7]
 * Explanation 2:
 *
 *  B occurs two times in A - A[3, 4], A[6, 7].
 * Explanation 3:
 *
 *  B does not occur in A as a substring.
 */
package com.advanced.dsa.patternmatching;

public class HiddenPatterns {

    public static void main(String[] args){
        /*
        To solve the problem, we know that we need to compare each substring of A having length	B	of A, with B efficiently.
        We can solve the problem using the technique of “Rolling hash function” through Rabin-Karp algorithm.

        We want to solve the problem of comparing strings efficiently. The brute force way of doing so is just to compare the letters of both strings, which has a time complexity of O(min(n1,n2)), if n1 and n2 are the sizes of the two strings. We want to do better.
        The idea behind strings is the following:
        We convert each string into an integer and compare those instead of the strings.
        Comparing two strings is then an O(1) operation.

        For the conversion, we need a so-called hash function. The goal of it is to convert a string into an integer, the so-called hash of the string.
        The following condition has to hold:
        if two strings s and t are equal (s = t), then also their hashes have to be equal (hash(s)=hash(t)).
        Otherwise, we will not be able to compare strings.

        We can define hash of string s having length n as:

        hash(s) = (s[n - 1] + s[n - 2] * p + s[n - 3] * p^2 + ...+ s[0] * p ^ (n - 1)) mod m

                      ,where p and m are some chosen, positive numbers.
        Generally, the values used for p and mod are : p = 31 and mod = 1e9 + 9

        Now, as we know how to get hash value for a string, we can traverse through string A, and to find hash value of substring having length |B| and ending at index ‘i’, in O(1) time,
        we can use the hash value of substring having length |B| and ending at ‘i - 1’ , using the fact that only the leftmost character at index ‘i-m’ was removed and character
        at index ‘i’ was added to form the current string from previous one.
         */
        System.out.println(solve("oxdirdjdufvditgjrbxywyxtbywsqhgdoqysbsdpytprtbhgnowgxjurvigvjyxqmsckkyvbkjycniftwunlzkheptilffzqpfncbrrcbjmzksdrrwbeqrgsrvebkrnokwct" ,
                "kkk"));
    }

    public static  int solve(final String A, final String B) {
        int n = A.length();
        int m = B.length();

        int ans = 0;

        long p = 31;
        int mod = 1000000009;

        long hashB = 0;

        for (int i = 0; i < m; i++)
            hashB = (((hashB * p) % mod ) + (B.charAt(i) - 'a' + 1)) % mod;

        long curHashA = 0;
        long pp = 1;

        for (int i = 0; i < m - 1;i++)
            pp = (pp * p) % mod;


        for (int i = 0; i < m; i++)
            curHashA = ((curHashA * p) % mod + (A.charAt(i) - 'a' + 1)) % mod;


        if(curHashA == hashB)
            ans++;


        for (int i = m; i < n; i++){
            long prvHashA = curHashA;
            curHashA = ((((prvHashA - (A.charAt(i - m) - 'a' + 1) * pp) % mod) * p) % mod + (A.charAt(i) - 'a' + 1)) % mod;
            if(curHashA < 0) curHashA += mod;
            if(curHashA == hashB){
                ans++;
            }
        }

        return ans;
    }

}
