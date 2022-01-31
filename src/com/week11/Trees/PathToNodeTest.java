/**
 * Path to Given Node
 * 
 * Problem Description

Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.


Problem Constraints

1 <= N <= 105

1 <= Data Values of Each Node <= N

1 <= B <= N



Input Format

First Argument represents pointer to the root of binary tree A.

Second Argument is an integer B denoting the node number.



Output Format

Return an one-dimensional array denoting the path from Root to the node B in order.



Example Input

Input 1:

 A =     
           1
         /   \
        2     3
       / \   / \
      4   5 6   7 

 B = 5
Input 2:

 A = 
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

 B = 1   


Example Output

Output 1:

 [1, 2, 5]
Output 2:

 [1]


Example Explanation

Explanation 1:

 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
Explanation 2:

 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]
 */
package com.week11.Trees;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class PathToNodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		n1.left = new TreeNode(5);
		n1.right = new TreeNode(2);
		n1.right.left = new TreeNode(3);
		n1.right.right = new TreeNode(6);
		System.out.println(solve(n1,6));
	}

	public static ArrayList<Integer> solve(TreeNode A, int B) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		dfs(A,B,ans);
		return ans;
    }

	private static void dfs(TreeNode A, int B, ArrayList<Integer> ans) {
		hasPath(A, B, ans);
	}
	
	private static boolean hasPath(TreeNode A, int B, ArrayList<Integer> ans) {
		// if root is NULL
        // there is no path
        if (A==null)
            return false;
       
        // push the node's value in 'arr'
        ans.add(A.val);    
       
        // if it is the required node
        // return true
        if (A.val == B)    
            return true;
       
        // else check whether the required node lies
        // in the left subtree or right subtree of 
        // the current node
        if (hasPath(A.left, B, ans) ||
            hasPath(A.right, B, ans))
            return true;
       
        // required node does not lie either in the 
        // left or right subtree of the current node
        // Thus, remove current node's value from 
        // 'arr'and then return false    
        ans.remove(ans.size()-1);
        return false; 
	}
	
}
