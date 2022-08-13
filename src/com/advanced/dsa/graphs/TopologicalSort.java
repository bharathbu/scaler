/**
 *  Topological Sort
 *
 * Problem Description
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 *
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 *
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 *
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
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
 * 2 <= A <= 104
 *
 * 1 <= M <= min(100000,A*(A-1))
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
 * Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 6
 *  B = [  [6, 3]
 *         [6, 1]
 *         [5, 1]
 *         [5, 2]
 *         [3, 4]
 *         [4, 2] ]
 * Input 2:
 *
 *  A = 3
 *  B = [  [1, 2]
 *         [2, 3]
 *         [3, 1] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [5, 6, 1, 3, 4, 2]
 * Output 2:
 *
 *  []
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
 * Explanation 2:
 *
 *  The given graph contain cycle so topological ordering not possible we will return empty array.
 */
package com.advanced.dsa.graphs;

import com.advanced.dsa.heaps.BClosestPoints;

import java.util.*;

/*
A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
Proof: There’s a simple proof to the above fact is that a DAG does not contain a cycle which means that all paths will be of finite length.
Now let S be the longest path from u(source) to v(destination). Since S is the longest path there can be no incoming edge to u and no outgoing edge from v, if this situation had occurred then S would not have been the longest path
=> indegree(u) = 0 and outdegree(v) = 0

Algorithm:
Steps involved in finding the topological ordering of a DAG:

Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.

Step-2: Pick all the vertices with in-degree as 0 and add them into a min priority queue (Enqueue operation)

Step-3: Remove a vertex from the queue (Dequeue operation) and then.

Increment count of visited nodes by 1.
Decrease in-degree by 1 for all its neighboring nodes.
If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
Step 5: Repeat Step 3 until the queue is empty.

Step 5: If count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.

How to find in-degree of each node?
There are 2 ways to calculate in-degree of every vertex:
Take an in-degree array which will keep track of
1) Traverse the array of edges and simply increase the counter of the destination node by 1.

for each node in Nodes
indegree[node] = 0;
for each edge(src,dest) in Edges
indegree[dest]++
Time Complexity: O(V+E)

2) Traverse the list for every node and then increment the in-degree of all the nodes connected to it by 1.

for each node in Nodes
    If (list[node].size()!=0) then
    for each dest in list
        indegree[dest]++;
We are using priority queue as we have to output the lexographically smallest ordering.

Overall time complexity: O((VlogV+E)
 */
public class TopologicalSort {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int edges = B.size();
        List<Integer>[] g = new ArrayList[A+1];
        for (int i = 0; i < edges; i++){
            if(g[B.get(i).get(0)] == null)
                g[B.get(i).get(0)] = new ArrayList<>();
            g[B.get(i).get(0)].add(B.get(i).get(1)); // For directed graph
        }
        Collections.sort(B, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        int[] in = new int[A+1];
        for (int i = 1; i <=A ; i++) {
            for (int j = 0;g[i]!=null && j < g[i].size(); j++) {
                int v = g[i].get(j);
                in[v]++;
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <=A ; i++)
            if(in[i] == 0)
                q.offer(i);
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            res.add(u);
            for (int i = 0; g[u]!=null && i < g[u].size(); i++) {
                int v = g[u].get(i);
                in[v]--;
                if(in[v] == 0)
                    q.offer(v);
            }
        }
        return res;
    }
}
