/**
 * Serialize Binary Tree
 *
 * Problem Description
 * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
 *
 * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
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
 *
 *
 * Input Format
 * Only argument is a A denoting the root node of a Binary Tree.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the Level Order Traversal of the given Binary Tree.
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
 *  [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Output 2:
 *
 *  [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 *  Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 *
 *  The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 *  Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
We can do this simply by using a queue data structure.

Firstly, we will push the root node in the queue.
Now, run a loop until the queue is empty.
Pop the Node, store the value of the node if it not NULL else store -1 in the output array.

Then push the left child and right child of the node respectively in the queue.

Return the output array.
 */
public class SerialiseBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t == null){
                list.add(-1);
                continue;
            }
            list.add(t.val);
            q.add(t.left);
            q.add(t.right);
        }
        return list;
    }
}
