/**
 * Fibonacci Number
 *
 * Problem Description
 * Given a positive integer A, write a program to find the Ath Fibonacci number.
 *
 * In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
 *
 * NOTE: 0th term is 0. 1th term is 1 and so on.
 *
 * Problem Constraints
 * 0 <= A <= 44
 *
 * Input Format
 * First and only argument is an integer A.
 *
 * Output Format
 * Return an integer denoting the Ath Fibonacci number.
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 * Input 2:
 *
 *  A = 6
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  8
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 *  0th term is 0 So, 4th term of Fibonacci series is 3.
 * Explanation 2:
 *
 *  6th term of Fibonacci series is 8.
 */
package com.advanced.dsa.dp;

import java.util.Calendar;
import java.util.Scanner;
/*
Approach 1:

A simple approach is to use the recursive implementation of the recursive relation given.

For ex: Calculate 4th term.

               fib(4)
             /        \
         fib(3)      fib(2)
        /    \       /    \
  fib(2)   fib(1)  fib(1) fib(0)
  /     \
fib(1) fib(0)
We can see that the 2nd term is calculated multiple times.

If we try to find large Fibonacci numbers, there will be more and more repetitions that are bad.

Time complexity of above: T(n) = T(n-1) + T(n-2) is exponential.

To avoid this, try to store the term which is calculated once and before calculating any other term check if it is already calculated or not.

If we already have that term use that. This will save us a lot of repetitions.

In this we are only calculating each term once, So, time complexity will be linear.

Approach 2

We can easily generate the Fibonacci series iteratively in linear time.

Initialise: fib[0] = 0, fib[1] = 1

for i from 2 to A.
    fib[i] = fib[i-1] + fib[i-2].
fib[A] will be our answer.

Try to write a solution without using any extra memory.
 */
public class Fibonacci {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        /*Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();*/
        System.out.println(fibItrOptimised(5));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,7);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);

        System.out.println(cal.getTime());

    }

    private static int fibItrOptimised(int A) {
        int a = 0, b = 1;
        int c = 0;
        if(A<=1) return A;
        for (int i = 2; i <= A ; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
