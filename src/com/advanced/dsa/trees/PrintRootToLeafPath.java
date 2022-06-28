/**
 *  Print all root to leaf paths
 *
 * You are given a binary tree. Find all paths from root to leaves of the binary tree.
 *
 *
 * Input Format
 *
 * The only argument given is the root pointer of tree A.
 * Output Format
 *
 * Return all paths from root to leaf.
 * Constraints
 *
 * 1 <= number of nodes <= 50000
 * 0 <= A[i] <= 10^9
 * For Example
 *
 * Input 1:
 *           5
 *          / \
 *         4   8
 *        /   / \
 *       11  13  4
 *      /      /
 *     7      5
 * Output 1:
 *  [
 *    [5,4,11,7],
 *    [5,8,13],
 *    [5,8,4,5]
 * ]
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;

public class PrintRootToLeafPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<Integer> path = new ArrayList<>();
        printRecur(A,path,0);
        return result;
    }

    private void printRecur(TreeNode root,ArrayList<Integer> path,int i) {
        if(root == null)
            return;
        path.add(i,root.val);
        i++;

        if(root.left == null && root.right==null){
            result.add(path);
        }

        else{
            printRecur(root.left,path,i);
            printRecur(root.right,path,i);
        }
    }
}
