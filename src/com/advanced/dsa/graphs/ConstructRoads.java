/**
 * Construct Roads
 *
 * Problem Description
 * A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
 *
 * Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.
 *
 * Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
 *
 * NOTE: All cities can be visited from any city.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * 1 <= B[i][0], B[i][1] <= N
 *
 *
 *
 * Input Format
 * First argument is an integer A denoting the number of cities, N.
 *
 * Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of roads king can construct.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = [
 *        [1, 2]
 *        [1, 3]
 *      ]
 * Input 2:
 *
 *  A = 5
 *  B = [
 *        [1, 3]
 *        [1, 4]
 *        [3, 2]
 *        [3, 5]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can't construct any new roads such that the country remains bipartite.
 * Explanation 2:
 *
 *  We can add two roads between cities (4, 2) and (4, 5).
 */
package com.advanced.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

/*
As we know, the tree is itself bipartite.
Run a Depth First search over the given tree and partition it into two sets.
We can’t add an edge between any 2 nodes in the same set and we can add an edge between every 2 nodes in different sets, so let the number of nodes in the left set be x and the number of nodes in the right set be y.
The maximum number of edges that can exist is x * y, but N - 1 edges already exist so the maximum number of edges to be added is x * y - (N - 1).
 */
public class ConstructRoads {
    static long[] col = new long[2];
    static long mod = 1000000007;
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
        col[0] = 0;
        col[1] = 0;
        dfs(1,0,g,0);
        long ans = col[0] * col[1];
        ans -= A - 1;
        ans %= mod;
        return (int) ans;

    }

    private void dfs(int u, int pnode, List<Integer>[] g,int c) {
        col[c]++;
        for (int i = 0; g[u]!=null && i < g[u].size(); i++) {
            int v = g[u].get(i);
            dfs(v,u,g,1-c);
        }
    }
}
