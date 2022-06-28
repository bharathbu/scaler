/**
 * Deserialize Binary Tree
 *
 * Problem Description
 * You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
 *
 * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
 *
 * NOTE:
 *
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 * -1 <= A[i] <= 105
 *
 *
 *
 * Input Format
 * Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
 *
 *
 *
 * Output Format
 * Return the root node of the Binary Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Input 2:
 *
 *  A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 *
 *
 * Example Output
 * Output 1:
 *
 *            1
 *          /   \
 *         2     3
 *        / \
 *       4   5
 * Output 2:
 *
 *             1
 *           /   \
 *          2     3
 *         / \ .   \
 *        4   5 .   6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 *  Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 *
 *  Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 *  Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
We can do this simply by using a queue data structure.

We know that the root node will always be the first element of level order traversal.
Create a root node and push the root node into the queue.

Now, run a loop until the queue is empty and keep a variable, let’s say i, for denoting the current index in the Level Order Traversal.

Pop the Node: If the node is not NULL, then the element at index i will be the left child, and the element at i+1 will be the right child.
Create those children and push the left child and right child of the node, respectively, in the queue.

After building the tree, return the root node.
 */
public class DeserialiseBinaryTree {
    public TreeNode solve(ArrayList<Integer> A) {
        TreeNode root = new TreeNode(A.get(0));
        int i=1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(A.get(i) != -1){
                t.left = new TreeNode(A.get(i));
                q.add(t.left);
            }
            i++;
            if(A.get(i) != -1){
                t.right = new TreeNode(A.get(i));
                q.add(t.right);
            }
            i++;
        }
        return root;
    }
}
