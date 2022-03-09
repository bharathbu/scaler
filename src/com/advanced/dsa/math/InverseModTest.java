/**
 * Prime Modulo Inverse
 *
 * Problem Description
 *
 * Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
 *
 * A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 109
 * 1<= B <= 109
 * B is a prime number
 *
 *
 *
 * Input Format
 *
 * First argument is an integer A.
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the modulor inverse
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 3
 *  B = 5
 * Input 2:
 *
 *  A = 6
 *  B = 23
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Let's say A-1 mod B = X, then (A * X) % B = 1.
 *  3 * 2 = 6, 6 % 5 = 1.
 * Explanation 2:
 *
 *  Similarly, (6 * 4) % 23 = 1.
 */
package com.advanced.dsa.math;

public class InverseModTest {
    public static void main(String args[]){

        System.out.println(solve(12,55557209));
    }

    public static int solve(int A, int B) {
        // As per fermat's theorem, a^m-1 % m = 1 mod m
        // a^-1 %m = a^m-2%m
        int result=0;
        result = PowerFunTest.pow(A,B-2,B);
        return result;
    }

    public static int pow(int A, int B, int C) {
        if(A==0) return 0;
        if(B==0) return 1;

        long halfPow = pow(A,B/2,C);
        long halhAns = (long)halfPow * halfPow;
        if(B%2 == 0)
            return (int)((halhAns%C+C)%C);
        else
            return (int)(((halhAns%C*A%C)%C+C)%C);

    }
}
