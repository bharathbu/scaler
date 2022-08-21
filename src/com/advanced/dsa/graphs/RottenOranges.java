/**
 *  Rotten Oranges
 * Unsolved
 * character backgroundcharacter
 * Stuck somewhere?
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 *
 * Each cell can have three values:
 *
 * The value 0 representing an empty cell.
 *
 * The value 1 representing a fresh orange.
 *
 * The value 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 *
 * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 *
 * 0 <= A[i][j] <= 2
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 *
 * If this is impossible, return -1 instead.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [2, 1, 1]
 *         [1, 1, 0]
 *         [0, 1, 1]   ]
 * Input 2:
 *
 *
 * A = [   [2, 1, 1]
 *         [0, 1, 1]
 *         [1, 0, 1]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
 * Explanation 2:
 *
 *  Task is impossible
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Every turn, the rotting spreads from each rotting orange to other adjacent oranges.
Initially, the rotten oranges have ‘depth’ 0, and every time they rot a neighbor,
the neighbors have 1 more depth. We want to know the largest possible depth.

Use multi-source BFS to achieve this with all cells containing rotten oranges as starting nodes.
At the end check if there are fresh oranges left or not.
 */
public class RottenOranges {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    class Pair{
        int x;
        int y;
        Pair(int i, int j){
            x = i;
            y = j;
        }
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size(),m=A.get(0).size();
        Queue<Pair> q = new LinkedList<>();
        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(A.get(i).get(j) == 2){
                    Pair p = new Pair(i,j);
                    q.offer(p);
                    time[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int a = p.x + x[i];
                int b = p.y + y[i];
                if(a>=0 && b>=0 && b<m && a<n && A.get(a).get(b) == 1){
                    A.get(a).set(b,2);
                    time[a][b] = time[p.x][p.y]+1;
                    q.offer(new Pair(a,b));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(A.get(i).get(j) == 1){
                    return -1;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(res < time[i][j])
                    res = time[i][j];
            }
        }
        return res;
    }
}
