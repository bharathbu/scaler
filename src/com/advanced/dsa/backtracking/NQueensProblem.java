/**
 * NQueens
 *
 * Problem Description
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer A, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First argument is an integer n denoting the size of chessboard
 *
 *
 *
 * Output Format
 * Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 4
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Output 1:
 *
 * [
 *  [Q]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * There exist only two distinct solutions to the 4-queens puzzle:
 * Explanation 1:
 *
 * There exist only one distinct solutions to the 1-queens puzzle:
 */
package com.advanced.dsa.backtracking;

import java.util.ArrayList;

public class NQueensProblem {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    ArrayList<String> soln;

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        int[][] mat = new int[A][A];
        queens(0,A,mat);
        return result;
    }

    private void queens(int i,int n,int[][] mat) {
        if(i==n){
            addAnsList(mat);
            return;
        }
        for (int j = 0; j < n; j++) {
            if(check(mat,i,j)){
                mat[i][j] = 1;
                queens(i+1,n,mat);
                mat[i][j] = 0;
            }
        }
    }

    private void addAnsList(int[][] mat) {
        ArrayList<String> currList = new ArrayList<>();

        for(int i=0; i<mat.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<mat.length; j++) {
                int val = mat[i][j];
                if(val == 0) {
                    sb.append(".");
                } else if(val == 1) {
                    sb.append("Q");
                }
            }
            currList.add(sb.toString());
        }
        result.add(currList);
    }

    private boolean check(int[][] mat , int i, int j) {
        // Step 1: check column
        for (int row = 0; row < i; row++)
            if(mat[row][j] == 1) return false;

        //Step 2: Check Left diagonal
        int r=i, c=j, N = mat[0].length;
        while(r>=0 && c>=0){
            if(mat[r][c] == 1)
                return false;
            r--; c--;
        }

        //Step 3: check Right diagonal
        r=i; c=j;
        while(r>=0 && c<N){
            if(mat[r][c] == 1)
                return false;
            r--; c++;
        }

        return true;
    }
}
