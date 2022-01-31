/**
 * Preorder Traversal
 * 
 * Problem Description

Given a binary tree, return the preorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is root node of the binary tree, A.



Output Format

Return an integer array denoting the preorder traversal of the given binary tree.



Example Input

Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output

Output 1:

 [1, 2, 3]
Output 2:

 [1, 6, 2, 3]


Example Explanation

Explanation 1:

 The Preoder Traversal of the given tree is [1, 2, 3].
Explanation 2:

 The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
package com.week11.Trees;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class PreorderTraversaltest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(7);
		node.right = new TreeNode(15);
		node.left.left = new TreeNode(5);
		node.left.right = new TreeNode(8);
		node.left.left.left = new TreeNode(3);
		System.out.println(preorderTraversal(node));
	}

	public static ArrayList<Integer> preorderTraversal(TreeNode A) {
	    	ArrayList<Integer> result = new ArrayList<Integer>();
	    	preorder(A, result);
	    	return result;
	}
	
	public static void preorder(TreeNode A,ArrayList<Integer> result) {
		if(A == null) return;
		result.add(A.val);
    	preorder(A.left,result);
    	preorder(A.right,result);
	}

}
