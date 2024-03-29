/**
 * Diameter of binary tree
 *
 * Problem Description
 * Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
 *
 * The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
 *
 *
 *
 * Problem Constraints
 * 0 <= N <= 105
 *
 *
 *
 * Input Format
 * First and only Argument represents the root of binary tree A.
 *
 *
 *
 * Output Format
 * Return an single integer denoting the diameter of the tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *            1
 *          /   \
 *         2     3
 *        / \
 *       4   5
 * Input 2:
 *
 *             1
 *           /   \
 *          2     3
 *         / \     \
 *        4   5     6
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
 * Explanation 2:
 *
 *  Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */
package com.advanced.dsa.trees;
/*
First, let’s see how to find the height or maxDepth of a tree:

If the tree is empty, then return 0
Else
(a) Get the max depth of each subtree recursively.

(b) Take the max depth and second max depth of any subtree. Get the max depth of the right subtree recursively, i.e., call height( tree->right-subtree)

(c) Get the max of max depths of left and right subtrees and add 1 to it for the current node.
max_depth = max(max dept of left subtree, max depth of right subtree) + 1

(d) Return max_depth

Diameter of a tree can be calculated by only using the height function, because the diameter of a tree is nothing but maximum value of (left_height + right_height + 1) for each node. So we need to calculate this value (left_height + right_height + 1) for each node and update the result. Time complexity – O(N).
 */
public class DiameterBinaryTree {

    int ans=Integer.MIN_VALUE;
    public int solve(TreeNode A) {
        height(A);
        return ans;
    }

    public int height(TreeNode A){
        if(A== null)
            return -1;

        int l=height(A.left);
        int r=height(A.right);

        int path = l+r+2;
        ans=Math.max(path,ans);
        return Math.max(l,r)+1;
    }
}
