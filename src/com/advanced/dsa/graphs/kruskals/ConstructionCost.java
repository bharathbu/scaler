/**
 * Construction Cost
 *
 * Problem Description
 * Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
 *
 * Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
 *
 * NOTE: Return the answer modulo 109+7 as the answer can be large.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 * 0 <= C <= 100000
 * 1 <= B[i][0], B[i][1] <= N
 * 1 <= B[i][2] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum construction cost.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * B = [   [1, 2, 14]
 *         [2, 3, 7]
 *         [3, 1, 2]   ]
 * Input 2:
 *
 * A = 3
 * B = [   [1, 2, 20]
 *         [2, 3, 17]  ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 9
 * Output 2:
 *
 * 37
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
 * we can reach the 1st node from 2nd and 3rd node using only these two edges.
 * So, the total cost of costruction is 9.
 * Explanation 2:
 *
 * We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
 */
package com.advanced.dsa.graphs.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
As it can be easily be seen that the graph will not have any cyles and every other node should be rechable from the 1st.
The resulting graph is connected and without cycles. So, it will be a tree.
To minimize the cost, we can find minimum spanning tree using Kruskal or Prim algorithms.

I've used Kruskal's union find algorithm
 */
public class ConstructionCost {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, Comparator.comparing(a -> a.get(2)));
        int[] components = new int[A+1];
        int edges = B.size();
        long ans = 0,MOD = (int) 1e9 +7;
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
        return (int) (ans%MOD);
    }

    private int findComp(int x, int[] components) {
        if(x == components[x]) return x;
        components[x] = findComp(components[x],components);
        return components[x];
    }
}
