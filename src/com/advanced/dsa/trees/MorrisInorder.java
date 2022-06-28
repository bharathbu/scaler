/**
 * norder Traversal
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
/*
Think stack.

Recursive call would look something like this :

inorderprint(root->left);
print(root->val);
inorderprint(root->right);

Instead of calling the functions, can you put the nodes on a stack and process them?

How would your solution work if you could change the original tree?
How would it work if you were not allowed to change the tree but use additional memory ( track the number of times a node has appeared in the tree )?

How would it work if you were not even allowed the extra memory? -- Use Morris inorder traversal (Below code is the implementation)
 */
public class MorrisInorder {

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = A;
        while(curr !=null){
            if(curr.left == null){
                result.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr)
                    temp = temp.right;
                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }
                else if(temp.right == curr){
                    temp.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
