/**
 * Cycle in Undirected Graph
 *
 * Problem Description
 *
 * Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.
 *
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 *
 * NOTE:
 *
 * The cycle must contain atleast three nodes.
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 *
 * Problem Constraints
 *
 * 1 <= A, M <= 3*105
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 *
 *
 * Input Format
 *
 * The first argument given is an integer A representing the number of nodes in the graph.
 *
 * The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
 *
 *
 *
 * Output Format
 *
 * Return 1 if cycle is present else return 0.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 5
 *  B = [  [1. 2]
 *         [1, 3]
 *         [2, 3]
 *         [1, 4]
 *         [4, 5]
 *      ]
 * Input 2:
 *
 *  A = 3
 *  B = [  [1. 2]
 *         [1, 3]
 *      ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1
 * Explanation 2:
 *
 *  No cycle present in the graph so we will return 0.
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an undirected graph of N nodes and E edges, check for cycle -- (If E>= N return 1)
Else, calculate the no. of components using DFS. Here, no cycle will be there if E<=(n-c)
 */
public class CyclicUndirectedGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int edges = B.size();
        if(edges >= A) return 1;
        int components = findComp(A,B);
        if(edges <= (A-components)) return 0;
        return 1;
    }

    /*
    Union find algorithm to find the no. of components
     */
    private int findComp(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] vis = new boolean[A+1];
        List<Integer>[] g = new ArrayList[A+1];
        int edges = B.size();
        for (int i = 0; i < edges; i++) {
            if(g[B.get(i).get(0)] == null)
                g[B.get(i).get(0)] = new ArrayList<>();
            g[B.get(i).get(0)].add(B.get(i).get(1));
            if(g[B.get(i).get(1)] == null)//For undirected graph, add both edges
                g[B.get(i).get(1)] = new ArrayList<>();
            g[B.get(i).get(1)].add(B.get(i).get(0));
        }
        int ans=0;
        for (int i = 1; i <= A; i++) {
            if(vis[i] == false){
                dfs(g,vis,i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(List<Integer>[] g, boolean[] vis, int s) {
        if(vis[s] == true) return;

        vis[s] = true;
        for (int i = 0; g[s]!=null && i < g[s].size(); i++) {
            int v = g[s].get(i);
            dfs(g,vis,v);
        }
    }

}
