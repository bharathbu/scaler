/**
 * Identical Binary Trees
 * 
 * Problem Description

Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First argument is a root node of first tree, A.

Second argument is a root node of second tree, B.



Output Format

Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input

Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Both trees are structurally identical and the nodes have the same value.
Explanation 2:

 Value of left child of the tree is different.
 */
package com.week11.Trees;

/**
 * @author Bharath
 *
 */
public class IdenticalBinaryTreeTest {

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
		
		TreeNode n2 = new TreeNode(10);
		n2.left = new TreeNode(7);
		n2.right = new TreeNode(15);
		n2.left.left = new TreeNode(5);
		n2.left.right = new TreeNode(8);
		n2.left.left.left = new TreeNode(3);
		System.out.println(isSameTree(n1,n2));
	}

	public static int isSameTree(TreeNode A, TreeNode B) {
		if(A == null && B==null) return 1;
		if(A == null || B==null) return 0;
		if(A.val != B.val) return 0;
		if (isSameTree(A.left,B.left)==1 &&
				isSameTree(A.right,B.right)==1)
			return 1;
		else return 0;
    }
}
