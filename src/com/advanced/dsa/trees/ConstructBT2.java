/**
 *  Binary Tree From Inorder And Postorder
 *
 * Problem Description
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 * Input Format
 * First argument is an integer array A denoting the inorder traversal of the tree.
 *
 * Second argument is an integer array B denoting the postorder traversal of the tree.
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
 *  A = [2, 1, 3]
 *  B = [2, 3, 1]
 * Input 2:
 *
 *  A = [6, 1, 3, 2]
 *  B = [6, 3, 2, 1]
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

public class ConstructBT2 {

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return construct(B,0,B.size()-1,A,0,A.size()-1);
    }

    private TreeNode construct(ArrayList<Integer> post, int ps, int pe, ArrayList<Integer> in, int ins, int ine) {
        /*
        Base case
         */
        if(ps>pe) return null;

        /*
        Main Logic
         */
        TreeNode root = new TreeNode(post.get(pe));
        //Search root in inorder
        int idx = 0;
        for (int i = ins; i <= ine; i++) {
            if(in.get(i)==root.val) {
                idx = i;
                break;
            }
        }
        int n=idx-ins;
        root.left = construct(post,ps,ps+n-1,in,ins,idx-1);
        root.right = construct(post,ps+n,pe-1,in,idx+1,ine);
        return root;
    }
}
