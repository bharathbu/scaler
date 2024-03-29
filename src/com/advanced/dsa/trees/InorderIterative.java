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
/*
Think stack.

Recursive call would look something like this :

inorderprint(root->left);
print(root->val);
inorderprint(root->right);

Instead of calling the functions, can you put the nodes on a stack and process them?

How would your solution work if you could change the original tree?
How would it work if you were not allowed to change the tree but use additional memory ( track the number of times a node has appeared in the tree )?
How would it work if you were not even allowed the extra memory?
 */
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
