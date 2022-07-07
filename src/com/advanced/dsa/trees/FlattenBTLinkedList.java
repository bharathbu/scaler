/**
 * Flatten Binary Tree to Linked List
 *
 * Problem Description
 * Given a binary tree A, flatten it to a linked list in-place.
 *
 * The left child of all nodes should be NULL.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the head of tree A.
 *
 *
 *
 * Output Format
 * Return the linked-list after flattening.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *      1
 *     / \
 *    2   3
 * Input 2:
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 * Output 2:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Tree flattening looks like this.
 * Explanation 2:
 *
 *  Tree flattening looks like this.
 */
package com.advanced.dsa.trees;

/*
If you notice carefully in the flattened tree,
each node’s right child points to the next node of a pre-order traversal.
Now, if a node does not have a left node, then our problem reduces to solving it for the node->right.

If it does, then the next element in the preorder traversal is the immediate left child. But if we make the immediate left child the right child of the node, then the right subtree will be lost. So we figure out where the right subtree should go. In the preorder traversal, the right subtree comes right after the rightmost element in the left subtree.
So we figure out the rightmost element in the left subtree and attach the right subtree as its right child. We make the left child the right child now and move on to the next node.
 */
public class FlattenBTLinkedList {

    public TreeNode flatten(TreeNode root) {
        if (root != null) {
            flatten(root.right);
            if (root.left != null) {
                flatten(root.left);
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
        return root;
    }
}
