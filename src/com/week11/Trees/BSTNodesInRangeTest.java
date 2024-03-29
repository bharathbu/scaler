/**
 * BST nodes in a range
 * 
 * Problem Description

Given a binary search tree of integers. You are given a range B and C.

Return the count of the number of nodes that lies in the given range.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= B < = C <= 109



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.



Output Format

Return the count of the number of nodes that lies in the given range.



Example Input

Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 12
     C = 20
Input 2:

            8
           / \
          6  21
         / \
        1   4

     B = 2
     C = 20


Example Output

Output 1:

 5
Output 2:

 3


Example Explanation

Explanation 1:

 Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
Explanation 2:

 Nodes which are in range [2, 20] are : [8, 6, 4]
 */
package com.week11.Trees;

/**
 * @author Bharath
 *
 */
public class BSTNodesInRangeTest {

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
		System.out.println(solve(n1,5,15));
	}

	public static int solve(TreeNode A, int B, int C) {
		int result=0;
		if(A==null) return 0;
		
		if(A.val>= B) result+=solve(A.left,B,C);
		if(A.val<=C) result+=solve(A.right,B,C);
		if(A.val >= B && A.val <= C) return 1+result;
		return result;
    }
}
