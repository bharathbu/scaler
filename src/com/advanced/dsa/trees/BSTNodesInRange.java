/**
 *  BST nodes in a range
 *
 * Problem Description
 * Given a binary search tree of integers. You are given a range B and C.
 *
 * Return the count of the number of nodes that lie in the given range.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= B < = C <= 109
 *
 *
 *
 * Input Format
 * First argument is a root node of the binary tree, A.
 *
 * Second argument is an integer B.
 *
 * Third argument is an integer C.
 *
 *
 *
 * Output Format
 * Return the count of the number of nodes that lies in the given range.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *             15
 *           /    \
 *         12      20
 *         / \    /  \
 *        10  14  16  27
 *       /
 *      8
 *
 *      B = 12
 *      C = 20
 * Input 2:
 *
 *             8
 *            / \
 *           6  21
 *          / \
 *         1   7
 *
 *      B = 2
 *      C = 20
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
 * Explanation 2:
 *
 *  Nodes which are in range [2, 20] are : [8, 6, 7]
 */
package com.advanced.dsa.trees;

import java.util.Stack;

/*
The idea is to traverse the given binary search tree starting from the root.
For every node being visited, check if this node lies in range,
if yes, then add 1 to the result and recur for both of its children.
If the current node is smaller than the low value of the range, then recur for the right child; else recur for the left child.
 */
public class BSTNodesInRange {
    public int solve(TreeNode A, int B, int C) {
        return inorderTraversal(A,B, C);
    }

    public int inorderTraversal(TreeNode A,int B, int C) {
        int count=0,val=0;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = A;
        while(curr!=null || !stk.isEmpty()){
            if(curr != null){
                stk.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stk.pop();
                val=temp.val;
                if(val>=B && val<=C)
                    count++;
                curr = temp.right;
            }

        }
        return count;
    }

}
