/**
 * Nodes Max
 *
 * Problem Description
 *
 * You are given the root node of a binary tree A. You have to find the max value of all node values of this tree.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= Number of nodes in the tree <= 105
 *
 * 0 <= Value of each node <= 104
 *
 *
 *
 * Input Format
 *
 * First and only argument is a tree node A.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the max of all node values of the tree.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  Values =  1
 *           / \
 *          4   3
 * Input 2:
 *
 *
 *  Values =  1
 *           / \
 *          8   3
 *         /
 *        2
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Clearly, among 1, 4, 3: 4 is maximum.
 * Explanation 2:
 *
 * Clearly, among 1, 8, 3, 2: 8 is maximum.
 */
package com.advanced.dsa.trees;
/*
Let's solve this question by recursive approach.
Run a recursive function with the root node.
Then call left and right child inside the function if they exist.
Afterwards in the recursive function update the ans variable with the node values accordingly.
Return void from the function if the node value is NULL.
 */
public class NodesMax {
    int max = Integer.MIN_VALUE;
    public int solve(TreeNode A) {
        return dfs(A);
    }

    private int dfs(TreeNode A) {
        if(A==null) return 0;
        if(A.val>max) max=A.val;
        dfs(A.left);
        dfs(A.right);
        return max;
    }
}
