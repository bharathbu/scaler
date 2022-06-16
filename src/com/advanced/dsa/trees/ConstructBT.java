/**
 *  Binary Tree From Inorder And Preorder
 *
 * Problem Description
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First argument is an integer array A denoting the preorder traversal of the tree.
 *
 * Second argument is an integer array B denoting the inorder traversal of the tree.
 *
 *
 *
 * Output Format
 * Return the root node of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 *  B = [2, 1, 3]
 * Input 2:
 *
 *  A = [1, 6, 2, 3]
 *  B = [6, 1, 3, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *    1
 *   / \
 *  2   3
 * Output 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Create the binary tree and return the root node of the tree.
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;

/*
Focus on the preorder traversal to begin with.
The first element in the traversal will definitely be the root.
Based on this information, can you identify the elements in the left subtree and right subtree ? ( Hint : Focus on inorder traversal and root information )

Once you do that, your problem has now been reduced to a smaller set. Now you have the inorder and preorder traversal for the left and right subtree and you need to figure them out.
Divide and conquer.

Bonus points if you can do it without recursion.
 */
public class ConstructBT {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return construct(A,0,A.size()-1,B,0,B.size()-1);
    }

    private TreeNode construct(ArrayList<Integer> pre, int ps, int pe, ArrayList<Integer> in, int ins, int ine) {
        /*
        Base case
         */
        if(ps>pe) return null;

        /*
        Main Logic
         */
        TreeNode root = new TreeNode(pre.get(ps));
        //Search root in inorder
        int idx = 0;
        for (int i = ins; i <= ine; i++) {
            if(in.get(i)==root.val) {
                idx = i;
                break;
            }
        }
        int n=idx-ins;
        root.left = construct(pre,ps+1,ps+n,in,ins,idx-1);
        root.right = construct(pre,ps+n+1,pe,in,idx+1,ine);
        return root;
    }
}
