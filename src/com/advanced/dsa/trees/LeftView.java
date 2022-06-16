/**
 *  Left View of Binary tree
 *
 *  Problem Description
 * Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
 *
 * Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
 *
 * NOTE: The value comes first in the array which have lower level.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 109
 *
 *
 *
 * Input Format
 * First and only argument is a root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the left view of the Binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *             1
 *           /   \
 *          2    3
 *         / \  / \
 *        4   5 6  7
 *       /
 *      8
 * Input 2:
 *
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 4, 8]
 * Output 2:
 *
 *  [1, 2, 4, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Left view of the binary tree is returned.
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
For each level whenever you encounters the first node on that level append it to the answer.

Try to Modify the the level order traversal of tree for this problem.

You can use queue to solve this problem as we do in level order traversal.
 */
public class LeftView {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        result.add(A.val);
        q.add(null);
        while(q.size() > 0){
            TreeNode f = q.peek();
            q.remove();
            if(f==null){
                if(q.size() > 0){
                    q.add(null);
                    result.add(q.peek().val);
                }
                continue;
            }
            if(f.left != null)
                q.add(f.left);
            if(f.right!=null)
                q.add(f.right);
        }
        return result;
    }
}
