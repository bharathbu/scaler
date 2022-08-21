/**
 * Check Bipartite Graph
 *
 * Problem Description
 * Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].
 *
 * Find whether the given graph is bipartite or not.
 *
 * A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B
 *
 * Note:
 *
 * There are no self-loops in the graph.
 *
 * No multiple edges between two pair of vertices.
 *
 * The graph may or may not be connected.
 *
 * Nodes are Numbered from 0 to A-1.
 *
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 *
 * 1 <= M <= min(A*(A-1)/2,200000)
 *
 * 0 <= B[i][0],B[i][1] < A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is the matrix B.
 *
 *
 *
 * Output Format
 * Return 1 if the given graph is bipartide else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 2
 * B = [ [0, 1] ]
 * Input 2:
 *
 * A = 3
 * B = [ [0, 1], [0, 2], [1, 2] ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Put 0 and 1 into 2 different subsets.
 * Explanation 2:
 *
 *
 * It is impossible to break the graph down to make two different subsets for bipartite matching
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
You can use and approach either BFS or DFS to check whether the graph can be colored using two colors or not.

Start from any node that hase not been colored yet:
a. Assign color1 to this nodes
b. check its adjacent nodes
a. if this is colored in color1 then the graph can’t be bipartite ,return 0.
b. else if this is colored in color1 do nothing.
c. else color it with color 2 and push it into queue.
Repet step1 until no nodes is left for coloring.
 */
public class BipartiteGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        List<Integer>[] g = new ArrayList[A];
        int edges = B.size();
        for (int i = 0; i < edges; i++) {
            if(g[B.get(i).get(0)] == null)
                g[B.get(i).get(0)] = new ArrayList<>();
            g[B.get(i).get(0)].add(B.get(i).get(1));
            if(g[B.get(i).get(1)] == null)//For undirected graph, add both edges
                g[B.get(i).get(1)] = new ArrayList<>();
            g[B.get(i).get(1)].add(B.get(i).get(0));
        }
        int res = isBipartite(g,A) == true?1:0;
        return res;
    }

    private boolean isBipartite(List<Integer>[] g, int n) {
        int[] color = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < n ; j++) {
            if(color[j] == 0){
                color[j] = 1;
                q.offer(j);
                while(!q.isEmpty()){
                    int u = q.poll();
                    for (int i = 0; g[u]!=null && i < g[u].size(); i++) {
                        int v = g[u].get(i);
                        if(color[u] == color[v])
                            return false; //not a bipartite graph
                        //Node is not colored
                        if(color[v] == 0){
                            color[v] = 3 - color[u];
                            q.offer(v);
                        }
                    }
                }
            }
        }
        return true;
    }
}
