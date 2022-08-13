/**
 * Number of islands
 *
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
 *
 * More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
 *
 * (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
 * (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
 * (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
 * (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
 * (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
 * (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
 * (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
 * (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
 * Return the number of islands.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 100
 *
 * 0 <= A[i] <= 1
 *
 *
 *
 * Input Format
 * The only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the number of islands.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [0, 1, 0]
 *        [0, 0, 1]
 *        [1, 0, 0]
 *      ]
 * Input 2:
 *
 *  A = [
 *        [1, 1, 0, 0, 0]
 *        [0, 1, 0, 0, 0]
 *        [1, 0, 0, 1, 1]
 *        [0, 0, 0, 0, 0]
 *        [1, 0, 1, 0, 1]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The 1's at position A[0][1] and A[1][2] forms one island.
 *  Other is formed by A[2][0].
 * Explanation 2:
 *
 *  There 5 island in total.
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;

/*
Whenever a cell with unvisited value ‘1’ is encountered we explore all the nodes that are reachable from it and continue exploring until no more nodes are left to explore.

While exploring we mark them visited so that no nodes can be explored twice.

After completion of traversal increament the count of islands.

Find for the 1 which is not visited yet.
 */
public class NumIslands {
    int[] x = {-1,1,0,0,-1,-1,1,1};
    int[] y = {0,0,-1,1,-1,1,-1,1};
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int c = 0,n=A.size(),m=A.get(0).size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(A.get(i).get(j) == 1){
                    c++;
                    dfs(i,j,A,n,m);
                }
            }
        }
        return c;
    }

    private void dfs(int i, int j, ArrayList<ArrayList<Integer>> A,int n,int m) {
        if(i<0 || j<0 || i>=n || j>=m || A.get(i).get(j)==0) return;
        A.get(i).set(j,0);
        for (int k = 0; k < 8; k++) {
            int a = i+x[k];
            int b = j+y[k];
            dfs(a,b,A,n,m);
        }
    }
}
