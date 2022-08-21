/**
 * Batches
 *
 * Problem Description
 *
 * A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
 *
 * Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
 *
 * All students who know each other are placed in one batch.
 *
 * Strength of a batch is equal to sum of the strength of all the students in it.
 *
 * Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
 *
 * Find the number of batches selected.
 *
 * NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 * 1 <= M <= 2*105
 *
 * 1 <= B[i] <= 104
 *
 * 1 <= C[i][0], C[i][1] <= A
 *
 * 1 <= D <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is an integer A.
 * The second argument given is an integer array B.
 * The third argument given is a matrix C.
 * The fourth argument given is an integer D.
 *
 *
 *
 * Output Format
 *
 * Return the number of batches selected in IB.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 7
 *  B = [1, 6, 7, 2, 9, 4, 5]
 *  C = [  [1, 2]
 *         [2, 3]
 *        `[5, 6]
 *         [5, 7]  ]
 *  D = 12
 * Input 2:
 *
 *  A = 5
 *  B = [1, 2, 3, 4, 5]
 *  C = [  [1, 5]
 *         [2, 3]  ]
 *  D = 6
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Initial Batches :
 *     Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
 *     Batch 2 = {4} Batch Strength = 2
 *     Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
 *     Selected Batches are Batch 1 and Batch 2.
 * Explanation 2:
 *
 *  Initial Batches :
 *     Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
 *     Batch 2 = {2, 3} Batch Strength = 5
 *     Batch 3 = {4} Batch Strength = 4
 *     Selected Batch is only Batch 1.
 */
package com.advanced.dsa.graphs.kruskals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Modify the above problem in the form of an undirected weighted graph.
Consider students as nodes and relations as edges between them.
All connected components come under one batch.
Strength of a batch is the sum of the weight of nodes of connected components of the graph(batch).

After Modifying the problem statement to graph perspective, It is easy to see find the solution.

Initiaize ans = 0

Pick any unvisited node and find the sum of all the weights of nodes which are reachable from this node and mark all such nodes as visited. if this sum is greater than equal to D then increment ans.

If N is the number of students and M is the number of relations then
Time Complexity : O (N+M)
 */
public class Batches {
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
        int[] components = new int[A+1];
        int edges = C.size();
        for (int i = 0; i <= A ; i++)
            components[i] = i;
        for (int i = 0; i < edges; i++) {
            int u = C.get(i).get(0);
            int v = C.get(i).get(1);
            int cu = findComp(u,components);
            int cv = findComp(v,components);
            if(cu != cv)
                components[Math.max(cu,cv)] = components[Math.min(cu,cv)];
        }
        for (int i = 1; i <= A; i++) {
            components[i] = findComp(i, components);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= A ; i++) {
            int iStrength = B.get(i-1);
            Integer oldStrength = map.getOrDefault(components[i],null);
            if(oldStrength == null)
                map.put(components[i],iStrength);
            else map.put(components[i],oldStrength+iStrength);
        }
        int count = 0;
        for (Integer comp: map.keySet()) {
            if(map.get(comp) >= D)
                count++;
        }
        return count;
    }

    private int findComp(int x, int[] components) {
        if(x == components[x]) return x;
        
        components[x] = findComp(components[x],components);
        return  components[x];
    }
}
