/**
 * Pubg
 *
 * Problem Description
 * There are N players, each with strength A[i]. when player i attack player j, player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game, and the game continues in the same manner among other players until only 1 survivor remains.
 *
 * Can you tell the minimum health last surviving person can have?
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 *
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * First and only argument of input contains a single integer array A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting minimum health of last person.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [6, 4]
 * Input 2:
 *
 *  A = [2, 3, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Given strength array A = [6, 4]
 *  Second player attack first player, A =  [2, 4]
 *  First player attack second player twice. [2, 0]
 * Explanation 2:
 *
 *  Given strength array A = [2, 3, 4]
 *  First player attack third player twice. [2, 3, 0]
 *  First player attack second player. [2, 1, 0]
 *  Second player attack first player twice. [0, 1, 0]
 */
package com.advanced.dsa.math;

public class PubGTest {

    public static void main(String[] args){
        int[] A = {6,4};
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        /*
        Let’s consider if there were only 2 people with strength A and B (A<=B). then A would attack B, leading to A, B-A.
        It would continue until it gets smaller than A or A, B%A. Then the process would repeat as A%(B%A), B%A, and so on…

        You can see this is exactly what is done in Euclid GCD algorithm. So, the answer is always gcd of numbers.
         */
        int gcd=0,n=A.length;

        for(int i=0;i<n;i++){
            gcd = gcd(gcd,A[i]);
        }

        return gcd;
    }

    public static int gcd(int A, int B) {
        if(B==0)
            return A;
        return gcd(B,A%B);
    }
}
