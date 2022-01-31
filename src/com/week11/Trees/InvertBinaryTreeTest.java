/**
 * Invert the Binary Tree
 * 
 * Problem Description

Given a binary tree A, invert the binary tree and return it.

Inverting refers to making left child as the right child and vice versa.



Problem Constraints

1 <= size of tree <= 100000



Input Format

First and only argument is the head of the tree A.



Output Format

Return the head of the inverted tree.



Example Input

Input 1:

 
     1
   /   \
  2     3
Input 2:

 
     1
   /   \
  2     3
 / \   / \
4   5 6   7


Example Output

Output 1:

 
     1
   /   \
  3     2
Output 2:

 
     1
   /   \
  3     2
 / \   / \
7   6 5   4


Example Explanation

Explanation 1:

Tree has been inverted.
Explanation 2:

Tree has been inverted.
 */
package com.week11.Trees;

/**
 * @author Bharath
 *
 */
public class InvertBinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(10);
		n1.left = new TreeNode(7);
		n1.right = new TreeNode(15);
		n1.left.left = new TreeNode(5);
		n1.left.right = new TreeNode(8);
		n1.left.left.left = new TreeNode(3);
		System.out.println(InorderTraversalTest.inorderTraversal(n1));
		n1=invertTree(n1);
		System.out.println(InorderTraversalTest.inorderTraversal(n1));
	}
	
	public static TreeNode invertTree(TreeNode A) {
		if(A == null) return null;
		TreeNode right = invertTree(A.left);
		TreeNode left = invertTree(A.right);
		A.left = left;
		A.right = right;
		return A;
    }

}
