/**
 * Double Character Trouble
 *
 * Problem Description
 * You are given a string A.
 *
 * An operation on the string is defined as follows:
 *
 * Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
 *
 * Therefore the string after this operation will be "acd".
 *
 * Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is string A.
 *
 *
 *
 * Output Format
 * Return the final string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = abccbc
 * Input 2:
 *
 *  A = ab
 *
 *
 * Example Output
 * Output 1:
 *
 *  "ac"
 * Output 2:
 *
 *  "ab"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Remove the first occurrence of same consecutive characters. eg for a string "abbc",
 * the first occurrence of same consecutive characters is "bb".
 * Therefore the string after this operation will be "ac".
 * Explanation 2:
 *
 *  No removals are to be done.
 */
package com.advanced.dsa.stacks;

import java.util.Stack;

public class DoubleCharTrouble {
    /*
    Consider an example string abba.
    When we remove the “bb”, the remaining string is “aa” which has to be removed as well.
    So we need to keep track of the characters before the first occurrence of similar consecutive characters.
    We can do this using a stack.
    We keep pushing the characters in a stack, if the current character is equal to the top of the stack,
    we pop from the stack since they represent
    a pair of similar characters.
    Finally, we print the stack in reverse.
     */
    public String solve(String A) {
        Stack<Character> stk = new Stack<>();
        int n=A.length();
        if(n<=1) return A;
        else{
            stk.push(A.charAt(0));
            for (int i = 1; i < n; i++) {
                char tmp = A.charAt(i);
                if(!stk.isEmpty() && stk.peek()==tmp)
                    stk.pop();
                else stk.push(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
            sb.append(stk.pop());
        sb.reverse();
        return sb.toString();
    }
}
