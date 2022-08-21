/**
 * Dijsktra
 *
 * Problem Description
 * Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 *
 * You have to find an integer array D of size A such that:
 *
 * => D[i] : Shortest distance form the C node to node i.
 *
 * => If node i is not reachable from C then -1.
 *
 * Note:
 *
 * There are no self-loops in the graph.
 *
 * No multiple edges between two pair of vertices.
 *
 * The graph may or may not be connected.
 *
 * Nodes are numbered from 0 to A-1.
 *
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1e5
 *
 * 0 <= B[i][0],B[i][1] < A
 *
 * 0 <= B[i][2] <= 1e3
 *
 * 0 <= C < A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A, representing the number of nodes.
 *
 * The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].
 *
 * The third argument given is an integer C.
 *
 *
 *
 * Output Format
 * Return the integer array D.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 6
 * B = [   [0, 4, 9]
 *         [3, 4, 6]
 *         [1, 2, 1]
 *         [2, 5, 1]
 *         [2, 4, 5]
 *         [0, 3, 7]
 *         [0, 1, 1]
 *         [4, 5, 7]
 *         [0, 5, 1] ]
 * C = 4
 * Input 2:
 *
 * A = 5
 * B = [   [0, 3, 4]
 *         [2, 3, 3]
 *         [0, 1, 9]
 *         [3, 4, 10]
 *         [1, 3, 8]  ]
 * C = 4
 *
 *
 * Example Output
 * Output 1:
 *
 * D = [7, 6, 5, 6, 0, 6]
 * Output 2:
 *
 * D = [14, 18, 13, 10, 0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All Paths can be considered from the node C to get shortest path
 * Explanation 2:
 *
 *  All Paths can be considered from the node C to get shortest path
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Initialize a distance array of integers(denoting distance of source to node i) with infinity.
Initialize d[source]=0 (distance from source to source is 0).
Insert {d[source],source} into a min heap based on distance.
extract first element from the heap:
if this element is mark visited then again start extract top element fro heap
else mark this as vis and expore adjacent nodes of the top node of the heap:
if distance[adjacentnode]>distance[curr]+weight of the edge between curr and adjacent node
update distacne[adjacentnode] = distance[curr]+weight of the edge between curr and adjacent node
insert this node alongwith weight into minheap.
 */
public class DijkstraAlgo {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        List<Integer[]>[] g = new ArrayList[A+1];
        int edges = B.size();
        for (int i = 0; i < edges; i++) {
            if(g[B.get(i).get(0)] == null)
                g[B.get(i).get(0)] = new ArrayList<>();
            Integer[] info = new Integer[2];
            info[0] = B.get(i).get(1);
            info[1] = B.get(i).get(2);
            g[B.get(i).get(0)].add(info);
            if(g[B.get(i).get(1)] == null)//For undirected graph, add both edges
                g[B.get(i).get(1)] = new ArrayList<>();
            info = new Integer[2];
            info[0] = B.get(i).get(0);
            info[1] = B.get(i).get(2);
            g[B.get(i).get(1)].add(info);
        }
        ArrayList<Integer> time = new ArrayList<>();
        for (int i = 0; i < A ; i++)
            time.add(Integer.MAX_VALUE);
        time.set(C,0);
        PriorityQueue<Integer[]> mh = new PriorityQueue<>(Comparator.comparing( (Integer[] p) -> p[0]));
        Integer[] timeNode = new Integer[2];
        timeNode[0] = 0;
        timeNode[1] = C;
        mh.offer(timeNode);
        while(!mh.isEmpty()){
            timeNode = mh.poll();
            int u = timeNode[1];
            int t = timeNode[0];
            if(t > time.get(u)) //Node is already blasted
                continue;
            for (int i = 0; g[u]!=null && i < g[u].size(); i++) {
                Integer[] pair = g[u].get(i);
                int v = pair[0];
                int w = pair[1];
                if(t+w < time.get(v)){
                    time.set(v,t+w);
                    mh.offer(new Integer[]{time.get(v),v});
                }
            }
        }
        for (int i = 0; i < A; i++) {
            if(time.get(i) == Integer.MAX_VALUE)
                time.set(i,-1);
        }
        return time;
    }
}
