/**
 * Possibility of Finishing
 *
 * Problem Description
 * There are a total of A courses you have to take, labeled from 1 to A.
 *
 * Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 *
 * So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 6*104
 *
 * 1 <= length(B) = length(C) <= 105
 *
 * 1 <= B[i], C[i] <= A
 *
 *
 *
 * Input Format
 * The first argument of input contains an integer A, representing the number of courses.
 *
 * The second argument of input contains an integer array, B.
 *
 * The third argument of input contains an integer array, C.
 *
 *
 *
 * Output Format
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = [1, 2]
 *  C = [2, 3]
 * Input 2:
 *
 *  A = 2
 *  B = [1, 2]
 *  C = [2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  It is possible to complete the courses in the following order:
 *     1 -> 2 -> 3
 * Explanation 2:
 *
 *  It is not possible to complete all the courses.
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class PossibilityOfFinishing {
    int finish=0;
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int edges = B.size();
        List<Integer>[] g = new ArrayList[A+1];
        for (int i = 0; i < edges; i++){
            if(g[B.get(i)] == null)
                g[B.get(i)] = new ArrayList<>();
            g[B.get(i)].add(C.get(i)); // For directed graph
        }
        int[] vis = new int[A+1];

        for (int i = 1; i <= A; i++) {
            if(vis[i] == 0){
                finish=0;
                dfs(g,vis,i);
                if(finish == 1)
                    break;
            }
        }
        finish = 1 - finish;
        return finish;
    }

    private void dfs(List<Integer>[] g, int[] vis, int s) {

        vis[s] = 1;
        for (int i = 0; g[s]!=null && i < g[s].size(); i++) {
            int v = g[s].get(i);
            if(vis[v] == 0)
                dfs(g,vis,v);
            else if(vis[v] == 1)
                finish =1;
        }
        vis[s] = 2;
    }
}
