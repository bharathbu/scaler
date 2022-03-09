/**
 * Sub-matrix Sum Queries
 *
 * Problem Description
 *
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.
 *
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 *
 * NOTE:
 *
 * Rows are numbered from top to bottom and columns are numbered from left to right.
 * Sum may be large so return the answer mod 109 + 7.
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * 1 <= Q <= 100000
 * 1 <= B[i] <= D[i] <= N
 * 1 <= C[i] <= E[i] <= M
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A.
 * The second argument given is the integer array B.
 * The third argument given is the integer array C.
 * The fourth argument given is the integer array D.
 * The fifth argument given is the integer array E.
 * (B[i], C[i]) represents the top left corner of the i'th query.
 * (D[i], E[i]) represents the bottom right corner of the i'th query.
 *
 *
 *
 * Output Format
 *
 * Return an integer array containing the submatrix sum for each query.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [   [1, 2, 3]
 *          [4, 5, 6]
 *          [7, 8, 9]   ]
 *  B = [1, 2]
 *  C = [1, 2]
 *  D = [2, 3]
 *  E = [2, 3]
 * Input 2:
 *
 *  A = [   [5, 17, 100, 11]
 *          [0, 0,  2,   8]    ]
 *  B = [1, 1]
 *  C = [1, 4]
 *  D = [2, 2]
 *  E = [2, 4]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [12, 28]
 * Output 2:
 *
 *  [22, 19]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 *  For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
 * Explanation 2:
 *
 *  For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 *  For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 *
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;

public class SubMatrixSumQueryTest {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);B.add(1);
        ArrayList<Integer> C = new ArrayList<Integer>();
        C.add(1);C.add(4);
        ArrayList<Integer> D = new ArrayList<Integer>();
        D.add(2);D.add(2);
        ArrayList<Integer> E = new ArrayList<Integer>();
        E.add(2);E.add(4);

        ArrayList<Integer> d1 = new ArrayList<Integer>();
        d1.add(-5);d1.add(-17);d1.add(-100);d1.add(-11);
        ArrayList<Integer> d2 = new ArrayList<Integer>();
        d2.add(0);d2.add(0);d2.add(-2);d2.add(-5548);

        A.add(d1);
        A.add(d2);
        System.out.println(solve(A,B,C,D,E));

    }
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Long>> ps = new ArrayList<ArrayList<Long>>();
        int n = A.size();
        int m=A.get(0).size();
        long temp=0;
        ps.add(new ArrayList<Long>());
        ps.get(0).add(Long.valueOf(A.get(0).get(0)));
        for(int i=1;i<=m;i++)
            ps.get(0).add(ps.get(0).get(i-1)+A.get(0).get(i-1));
        for(int i=1;i<=n;i++){
            ps.add(new ArrayList<Long>());
            ps.get(i).add(ps.get(i-1).get(0)+A.get(i-1).get(0));
        }

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++){
                temp = ps.get(i-1).get(j)+ps.get(i).get(j-1)-ps.get(i-1).get(j-1)+A.get(i-1).get(j-1);
                ps.get(i).add(temp);
            }
        int r1,r2,c1,c2,q=B.size(),res=0;


        for(int i=0;i<q;i++){
            r2 = D.get(i);
            c2 = E.get(i);
            temp = ps.get(r2).get(c2);
            r1=B.get(i);
            c1=C.get(i);

                temp = temp - ps.get(r1-1).get(c2) - ps.get(r2).get(c1-1) + ps.get(r1-1).get(c1-1);

            res = (int) (temp%(1E9+7));
            if(res<0)
                res+=1E9+7;
            result.add(res);
            temp=0;
        }
        return result;
    }
}
