/**
 * Q2. Enumerating GCD
 *
 * Problem Description
 * You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
 * As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.
 *
 * You have to return the value of GCD found.
 *
 * The greatest common divisor of 2 numbers, A and B, is the largest number, D that divides both A and B perfectly.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= B <= 10100
 *
 *
 *
 * Input Format
 * First argument is a string denoting A.
 *
 * Second argument is a string denoting B.
 *
 *
 *
 * Output Format
 * Return a string which contains the digits of the integer which represents the GCD. The returned string should not have any leading zeroes.
 *
 *
 *
 * Example Input
 * A = "1"
 * B = "3"
 *
 *
 * Example Output
 * 1
 *
 *
 * Example Explanation
 * Greatest divisor that divides both 1 and 3 is 1.
 */
package com.advanced.dsa.math;

public class EnumeratingGCDTest {
    public static void main(String[] args){
        System.out.println(solve("10","6"));
    }

    public static String solve(String A, String B) {
        /*
        Case 1: P == Q
        When P and Q are the same, it is obvious that the greatest divisor is the number itself.

        Case 2: P ≠ Q
        When P and Q are not the same, our answer is GCD(P, P+1, P+2, ...., Q)
        But, we know that GCD(P, P+1) is always 1

        Proof:  We know that if a number D divides both A and B, it will also divide abs(A-B)
                Now, if B = A+1, let's assume D to be a number that divides both A and B.
                D should also divide abs(A-B) = abs(A - (A+1)) = 1
                But the only number to perfectly divide 1 is 1 itself. Hence D has to be 1.

        Therefore, if P ≠ Q, the answer is 1.
         */
        if (A.equals(B))
            return A;
        else return "1";
    }
}
