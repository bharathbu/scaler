/**
 * Commutable Islands
 *
 * Problem Description
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, M <= 6*104
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 * 1 <= B[i][2] <= 103
 *
 *
 *
 * Input Format
 * The first argument contains an integer, A, representing the number of islands.
 *
 * The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 *
 *
 *
 * Output Format
 * Return an integer representing the minimal cost required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 4]
 *         [1, 4, 3]
 *         [4, 3, 2]
 *         [1, 3, 10]  ]
 * Input 2:
 *
 *  A = 4
 *  B = [  [1, 2, 1]
 *         [2, 3, 2]
 *         [3, 4, 4]
 *         [1, 4, 3]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
 * Explanation 2:
 *
 *  We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 */
package com.advanced.dsa.graphs.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
We can assume islands as the vertex points and bridges as the edges and can construct a graph with the the help of them. After constructing the graph, the problem boils down to finding a subset of edges which helps in connecting vertices in a single connected component such that the sum of their edge weights is as minimum as possible.

Now since the problem is clear to you, can you think of any graph theory algorithms related to this?

Well the answer to this problem is the classic minimum spanning tree algorithm. In this algorithm we aim at finding subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.

There are many algorithms for finding minimum spanning tree of a graph. Some of them are Kruskal’s algorithm, Prim’s algorithm etc.

Kruskal’s algorithm in detail can be found at : https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
Prim’s algorithm in detail can be found at : https://en.wikipedia.org/wiki/Prim%27s_algorithm

Now, can you code this?
 */
public class CommutableIslands {
    /*
    Below solution is done using Kruskal Union find algorithm
    TC: O(E log E + E)
     */
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, Comparator.comparing(a -> a.get(2)));
        int[] components = new int[A+1];
        int ans = 0, edges = B.size();
        for (int i = 0; i <= A; i++)
            components[i] = i;
        for (int i = 0; i < edges; i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            int w = B.get(i).get(2);

            int cu = findComp(u, components);
            int cv = findComp(v,components);
            if(cu!=cv){
                components[Math.max(cu,cv)] = components[Math.min(cu,cv)]; //As a standard rule, assign merge the component of higher value to the component of lower value
                ans += w;
            }
        }
        return ans;
    }

    private int findComp(int x, int[] components) {
        if(x == components[x]) return x;
        components[x] = findComp(components[x],components);
        return components[x];
    }
}
