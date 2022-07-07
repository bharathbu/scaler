/**
 * Recover Binary Search Tree
 *
 * Problem Description
 * Two elements of a binary search tree (BST), represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.
 *
 * A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the head of the tree,A
 *
 *
 *
 * Output Format
 * Return the 2 elements which need to be swapped.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *          1
 *         / \
 *        2   3
 * Input 2:
 *
 *
 *          2
 *         / \
 *        3   1
 *
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 1]
 * Output 2:
 *
 *  [3, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Swapping 1 and 2 will change the BST to be
 *          2
 *         / \
 *        1   3
 * which is a valid BST
 * Explanation 2:
 *
 * Swapping 1 and 3 will change the BST to be
 *          2
 *         / \
 *        1   3
 * which is a valid BST
 */
package com.week11.Trees;

import java.util.ArrayList;

public class RecoverBST {

    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> recoverTree(TreeNode A) {
        dfs(A);

        return result;
    }

    private void dfs(TreeNode curr) {
        if(curr ==null || result.size()==2)
            return;
        if(curr.left!=null && curr.right!=null){
            if(curr.val>curr.right.val && curr.val < curr.left.val){
                result.add(curr.left.val);
                result.add(curr.right.val);
                return;
            }
            else if(curr.val < curr.left.val){
                result.add(curr.left.val);
                result.add(curr.val);
                return;
            }
            else if(curr.val > curr.right.val){
                result.add(curr.val);
                result.add(curr.right.val);
                return;
            }
        }else if(curr.left!=null){
            if(curr.val < curr.left.val){
                result.add(curr.left.val);
                result.add(curr.val);
                return;
            }
        }else if(curr.right!=null){
            if(curr.val>curr.right.val){
                result.add(curr.val);
                result.add(curr.right.val);
                return;
            }
        }
        dfs(curr.left);
        dfs(curr.right);
    }
}
