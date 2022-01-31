/**
 * Counting the Nodes
 * 
 * Problem Description
Given the root of a tree A with each node having a certain value, find the count of nodes which have more value than all its ancestor

Problem Constraints

1 <= Number of Nodes <= 200000
1 <= Value of Nodes <= 2000000000

Input Format
First and only argument of input is a tree node.



Output Format
Return a single integer denoting count of nodes which have more value than all of it's ancestor.

Example Input
Input 1: 
     3
     
Input 2:
    4
   / \
  5   2
     / \
    3   6


Example Output

Output 1:
 1
Output 2:
 3


Example Explanation

Explanation 1:

 One node is valid
Explanation 2:

 Three nodes are 4, 5 and 6.
 */
package com.week11.Trees;

/**
 * @author Bharath
 *
 */
public class CountingNodestest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		n1.left = new TreeNode(5);
		n1.right = new TreeNode(2);
		n1.right.left = new TreeNode(3);
		n1.right.right = new TreeNode(6);
		System.out.println(solve(n1));
	}
	
	public static int solve(TreeNode A) {
		int result = countNode(A,A.val-1);
		return result;
    }
	
	public static int countNode(TreeNode A, int maxRoot) {
		if(A == null) return 0;
		if(A.val > maxRoot) return 1+countNode(A.left,A.val)+countNode(A.right,A.val);	
		else return countNode(A.left,maxRoot)+countNode(A.right,maxRoot);
		
	}

}
