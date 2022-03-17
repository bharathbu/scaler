/**
 * Euclid's algorithm:
 *
 * Let's say g is gcd(m, n) and m > n.
 *
 * m = g * m1
 * n = g * m2
 *
 * m - n = g * (m1 - m2)
 *
 * gcd (m, n) = gcd(m-n, n)
 *
 *            = gcd(m - 2n, n) if m >= 2n
 *            = gcd(m - 3n, n) if m >= 3n
 *              .
 *              .
 *              .
 *            = gcd(m - k*n, n) if m >= k*n
 *
 *        In other words, we keep subtracting n till the result is greater than 0. Ultimately we will end up with m % n.
 *
 *               So gcd(m, n)  = gcd(m % n, n) 
 */
package com.advanced.dsa.math;

public class GCDTest {

    public static void main(String[] args){
        System.out.println(gcd(10,6));
    }

    /*public static int gcd(int A, int B) {
        if(A<B){
            A=A^B;
            B=A^B;
            A=A^B;
        }
        if(B==0)
            return A;
        return gcd(A-B,B);
    }*/
    public static int gcd(int A, int B) {
        if(A==0)
            return B;
        return gcd(B%A,A);
    }
}
