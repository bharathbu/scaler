/**
 * 
 */
package com.week11.Trees;

/**
 * @author Bharath
 *
 */
public class SymmetricBinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	public static int isSymmetric(TreeNode A) {
		return solve(A,A);
    }
	
	public static int solve(TreeNode A, TreeNode B) {
		if(A == null && B==null) return 1;
		if(A == null || B==null) return 0;
		if(A.val != B.val) return 0;
		if (solve(A.left,B.right)==1 &&
				solve(A.right,B.left)==1)
			return 1;
		else return 0;
	}
}
