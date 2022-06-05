/**
 * Boring substring
 *
 * Problem Description
 * You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
 *
 * A boring substring has the following properties:
 *
 * Its length is 2.
 * Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
 * Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * The only argument given is a string A.
 *
 *
 *
 * Output Format
 * Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abcd"
 * Input 2:
 *
 *  A = "aab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  String A can be rearranged into "cadb" or "bdac"
 * Explanation 2:
 *
 *  No arrangement of string A can make it free of boring substrings.
 */
package com.advanced.dsa.hashing;

import java.util.Arrays;

public class BoringSubstring {

    /*
    Think in terms of parity of ASCII values of the characters.

    All odd parity needs to stay together.
    Similarly, all even parity characters need to stay together.

    No specific knowledge is required to solve this question.
    You need to observe and find an existing pattern hidden in the parities of ASCII value of characters.

    ‘a’ could be present near ‘c’ , similarly ‘c’ could be near ‘e’ as we can see odd characters can be put aside each other, and there will be no boring substring in it.

    Like: “acegik…” No boring substring is present in this string.

    Similarly for even characters.

    Now traverse in the string and form two strings, one containing the odd characters and the other even characters.
    Sort both of them and check if placing them together doesn’t make a boring substring at their join point.

    For example:
    A = “abcdefg”
    So ,
    odd = “aceg”
    even= “bdf”

    Check the string s = odd+even or s=even+odd doesn’t contain any boring substring.

    Time Complexity: O(	A	)
     */
    public static void main(String[] args){
        System.out.println(solve("jchghcejb"));
    }
    public static int solve(String A) {
        int n=A.length();
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if(c%2==0)
                odd.append(c);
            else even.append(c);
        }

        char[] ar = odd.toString().toCharArray();
        Arrays.sort(ar);
        odd = new StringBuilder(String.valueOf(ar));

        ar = even.toString().toCharArray();
        Arrays.sort(ar);
        even = new StringBuilder(String.valueOf(ar));

        if(check(String.valueOf(odd)+String.valueOf(even)) )
            return 1;
        else if(check(String.valueOf(even)+String.valueOf(odd)))
            return 1;
        return 0;
    }

    public static boolean check(String s) {
        boolean ok = true;
        for (int i = 0; i + 1 < s.length(); ++i)
            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
        return ok;
    }
}
