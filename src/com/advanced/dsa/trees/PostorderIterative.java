/**
 * Postorder Traversal
 *
 * Problem Description
 * Given a binary tree, return the Postorder traversal of its nodes' values.
 *
 * NOTE: Using recursion is not allowed.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the Postorder traversal of the given binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * Input 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [3, 2, 1]
 * Output 2:
 *
 *  [6, 3, 2, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Preoder Traversal of the given tree is [3, 2, 1].
 * Explanation 2:
 *
 *  The Preoder Traversal of the given tree is [6, 3, 2, 1].
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderIterative {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        Stack<TreeNode> s1 = new Stack<>(),s2 = new Stack<>();
        s1.push(A);
        while(!s1.isEmpty()){
            TreeNode t = s1.pop();
            s2.push(t);
            if(t.left != null)
                s1.push(t.left);
            if(t.right != null)
                s1.push(t.right);
        }
        int n = s2.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(s2.pop().val);
        }
        return result;
    }
}
