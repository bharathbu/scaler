/**
 * Compute nCr % p
 *
 * Problem Description
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
 *
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 *
 * NOTE: For this problem, we are considering 1 as a prime.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 106
 * 1 <= B <= A
 * A <= C <= 109+7
 *
 *
 * Input Format
 * The first argument given is the integer A ( = n).
 * The second argument given is the integer B ( = r).
 * The third argument given is the integer C ( = p).
 *
 *
 *
 * Output Format
 * Return the value of nCr % p.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = 2
 *  C = 13
 * Input 2:
 *
 *  A = 6
 *  B = 2
 *  C = 13
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  nCr( n=5 and r=2) = 10.
 *  p=13. Therefore, nCr%p = 10.
 */
package com.advanced.dsa.math;

public class NcRModP {
    public static void main(String[] args){
        System.out.println(solve(8458,506,540907));
    }

    public static int solve(int A, int B, int C) {
        /*
            nCr % m = (n!/((n-r)!*r!))% m
            n!= (n%m * n-1%m * n-2%m * 3%m * 2%m * 1%m)%m
         */
        long nFact,rFact,nrFact;

        /*
        As per Fermat's little theorem,
        a^-1 mod p = a^p-2 mod p

         nCr%p = (n!/((n-r)!*r!))%p
             = n!%p * [(n-r)!]^-1 %p * [r!]^-1 %p
             = n!%p * [(n-r)!]^p-2 %p * (r!)^p-2 %p
             = n!%p * [(n-r)!%p]^p-2 %p * (r!%p)^p-2 %p
         ----------------------------------------------------------------------------------
         This problem can be solved using Fermat’s Little theorem.

            a^p = a (mod p) where p is a prime number.

            a^(p-1) = 1 (mod p)

            Multiply by an inverse on both sides

            a^(p-2) = a^(-1) (mod p).
            Using the above result, nCr can be calulated as ( fact[n]%p ) * inversemodulo( fact[n-r] %p ) * inversemodulo( fact[r] %p ).
         */
        nFact = computeFact(A,C);
        rFact = computeFact(B,C);
        nrFact = computeFact(A-B,C);

        rFact = pow(rFact,C-2,C);
        nrFact = pow(nrFact,C-2,C);

        long result = (nFact%C*rFact%C)%C;
        result = (result*nrFact%C)%C;

        return (int) result;

    }

    private static long computeFact(int n, int p) {
        /*
        n!= (n%m * n-1%m * n-2%m * 3%m * 2%m * 1%m)%m
         */
        long fact=1;
        for (int i = n; i >=1 ; i--) {
            fact = (fact*i)%p;
        }
        return fact;
    }

    public static int pow(long A, long B, int C) {
        //if(A==0) return 0;
        if(B==0) return 1;
        long halfPow = pow(A,B/2,C);
        long halfAns = (((halfPow%C)*(halfPow%C))%C);
        if(B%2==0) return (int) ((halfAns%C+C)%C);
        else return (int) (((halfAns%C*A%C)%C+C)%C);
    }
}
