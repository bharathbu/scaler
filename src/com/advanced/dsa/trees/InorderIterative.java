/**
 * Inorder Traversal
 *
 * Problem Description
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Return an integer array denoting the inorder traversal of the given binary tree.
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
 *  [1, 3, 2]
 * Output 2:
 *
 *  [6, 1, 3, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Inorder Traversal of the given tree is [1, 3, 2].
 * Explanation 2:
 *
 *  The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderIterative {

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = A;
        while(curr!=null || !stk.isEmpty()){
            if(curr != null){
                stk.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stk.pop();
                result.add(temp.val);
                curr = temp.right;
            }
        }
        return result;
    }

}
