/**
 * Postorder Traversal
 * 
 * Problem Description

Given a binary tree, return the Postorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is root node of the binary tree, A.



Output Format

Return an integer array denoting the Postorder traversal of the given binary tree.



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

 [3, 2, 1]
Output 2:

 [6, 3, 2, 1]


Example Explanation

Explanation 1:

 The Preoder Traversal of the given tree is [3, 2, 1].
Explanation 2:

 The Preoder Traversal of the given tree is [6, 3, 2, 1].
 */
package com.week11.Trees;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class PostorderTraversalTest {

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
		System.out.println(postorderTraversal(node));
	}

	public static ArrayList<Integer> postorderTraversal(TreeNode A) {
	    	ArrayList<Integer> result = new ArrayList<Integer>();
	    	postorder(A, result);
	    	return result;
	}
	
	public static void postorder(TreeNode A,ArrayList<Integer> result) {
		if(A == null) return;
		postorder(A.left,result);
    	postorder(A.right,result);
    	result.add(A.val);  	
	}

}
