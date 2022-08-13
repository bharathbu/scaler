/**
 * Path in Directed Graph
 *
 * Problem Description
 * Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
 *
 * B[i][0] to node B[i][1].
 *
 * Find whether a path exists from node 1 to node A.
 *
 * Return 1 if path exists else return 0.
 *
 * NOTE:
 *
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 *
 * Problem Constraints
 * 2 <= A <= 105
 *
 * 1 <= M <= min(200000,A*(A-1))
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 *
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 *
 *
 * Output Format
 * Return 1 if path exists between node 1 to node A else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = [  [1, 2]
 *         [4, 1]
 *         [2, 4]
 *         [3, 4]
 *         [5, 2]
 *         [1, 3] ]
 * Input 2:
 *
 *  A = 5
 *  B = [  [1, 2]
 *         [2, 3]
 *         [3, 4]
 *         [4, 5] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The given doens't contain any path from node 1 to node 5 so we will return 0.
 * Explanation 2:
 *
 *  Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Either Breadth First Search (BFS) or Depth First Search (DFS) can be used to find path between two vertices.
Take the first vertex as source in BFS (or DFS), follow the standard BFS (or DFS). If the second vertex is found in our traversal, then return 1 else return 0.

Approach:
Either Breadth First Search (BFS) or Depth First Search (DFS) can be used to find path between two vertices.
Take the first vertex as source in BFS (or DFS), follow the standard BFS (or DFS). If the second vertex is found in our traversal, then return 1 else return 0.

Algorithm:
The author implementation iss using BFS.

Create a queue and a visited array initially filled with 0, of size V where V is number of vertices.
Insert the starting node in the queue, i.e. push u in the queue and mark u as visited.
Run a loop until the queue is not empty.
Dequeue the front element of the queue. Iterate all its adjacent elements. If any of the adjacent element is the destination return 1. Push all the adjacent and unvisted vertices in the queue and mark them as visited.
Return 0 as the destination is not reached in BFS.
Complexity Analysis:

Time Complexity: O(A + M) where A is number of vertices in the graph and M is number of edges in the graph.
Space Compelxity: O(A).
There can be atmost A elements in the queue. So the space needed is O(A).

Trade-offs between BFS and DFS: Breadth-First search can be useful to find the shortest path between nodes, and depth-first search may traverse one adjacent node very deeply before ever going into immediate neighbours.
 */
public class PathDirectedGraph {
    public int solve(int A, int[][] B) {
        int src = 1, dest  =A, edges = B.length;
        List<Integer>[] g = new ArrayList[A+1];
        for (int i = 0; i < edges; i++){
            if(g[B[i][0]] == null)
                g[B[i][0]] = new ArrayList<>();
            g[B[i][0]].add(B[i][1]); // For directed graph
        }


        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[A+1];
        q.add(src);
        visited[src] = true;
        while(!q.isEmpty()){
            int curr = q.poll();

            for (int i = 0;  g[curr]!=null && i <g[curr].size(); i++) {
                int cv = g[curr].get(i);
                if(visited[cv] == false){
                    visited[cv] = true;
                    q.add(cv);
                }
            }
        }
        return visited[dest]==true?1:0;
    }
}
