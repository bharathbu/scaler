/**
 *  Perfect Numbers
 *
 * Problem Description
 * Given an integer A, you have to find the Ath Perfect Number.
 *
 * A Perfect Number has the following properties:
 *
 * It comprises only 1 and 2.
 *
 * The number of digits in a Perfect number is even.
 *
 * It is a palindrome number.
 *
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 *
 *
 *
 * Input Format
 * The only argument given is an integer A.
 *
 *
 *
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  22
 * Output 2:
 *
 *  1111
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Explanation 2:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 */
package com.advanced.dsa.queues;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public String solve(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("11");
        if(A==1) return q.peek();
        q.add("22");
        if(A==2){
            q.remove();
            return q.peek();
        }
        for (int i = 3; i <=A; i++) {
            StringBuilder sb = new StringBuilder();
            String str = q.remove();
            int n=str.length();
            sb.append(str.substring(0,n/2-1)).append("11").append(str.substring(n/2,n));
            if(i==A) return sb.toString();
            q.add(sb.toString());

            i++;
            sb = new StringBuilder();
            sb.append(str.substring(0,n/2-1)).append("22").append(str.substring(n/2,n));
            if(i==A) return sb.toString();
            q.add(sb.toString());
        }
        return "";
    }
}
