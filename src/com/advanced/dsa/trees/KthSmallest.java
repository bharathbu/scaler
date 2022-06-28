/**
 * Kth Smallest Element In BST
 *
 * Problem Description
 * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 10^9
 *
 *
 *
 * Input Format
 * First and only argument is head of the binary tree A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the Bth element.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *             2
 *           /   \
 *          1    3
 * B = 2
 * Input 2:
 *
 *
 *             3
 *            /
 *           2
 *          /
 *         1
 * B = 1
 *
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 2nd element is 2.
 * Explanation 2:
 *
 * 1st element is 1.
 */
package com.advanced.dsa.trees;

import java.util.HashMap;
import java.util.Map;

/*
Note the property of the binary search tree.
All elements smaller than root will be in the left subtree, and all elements greater than root will be in the right subtree.
This means we need not even explore the right subtree till we have explored everything in the left subtree. Or in other words, we go to the right subtree only when the size of left subtree + 1 ( root ) < k.

With that in mind, we can come up with an easy recursive solution which is similar to inorder traversal :

Step 1: Find the kth smallest element in left subtree decrementing k for every node visited. If answer is found, return answer.
Step 2: Decrement k by 1. If k == 0 ( this node is the kth node visited ), return node’s value
Step 3: Find the kth smallest element in right subtree.
 */
public class KthSmallest {
    Map<TreeNode,Integer> map = new HashMap<>();

    public int kthsmallest(TreeNode A, int B) {
        TreeNode curr = A;
        int size = size(A);
        map.put(null,0);
        while(curr != null){

            if(map.get(curr.left) == B-1)
                return curr.val;
            else if(map.get(curr.left) >= B)
                curr = curr.left;
            else if(map.get(curr.left) < B){
                B = B - map.get(curr.left) - 1;
                curr = curr.right;
            }

        }
        return -1;
    }

    public int size(TreeNode root){
        if(root == null) return 0;
        int ls = size(root.left);
        int rs = size(root.right);
        map.put(root,1+ls+rs);
        return 1+ls+rs;
    }
}
