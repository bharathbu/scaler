/*Next Pointer Binary Tree
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree and try to solve this in constant extra space.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return the head of the binary tree after the changes are made.



Example Input
Input 1:


     1
    /  \
   2    3
Input 2:


        1
       /  \
      2    5
     / \  / \
    3  4  6  7


Example Output
Output 1:


        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2:


         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL


Example Explanation
Explanation 1:

Next pointers are set as given in the output.
Explanation 2:

Next pointers are set as given in the output.

 */
package com.advanced.dsa.trees;

import java.util.ArrayList;

public class NextPointerBinaryTree {

    public class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        inorderTraversal(root);
        TreeLinkNode curr = root;
        while(curr.left != null){
            TreeLinkNode temp = curr;
            while(temp!=null){
                temp.left.next = temp.right;
                if(temp.next != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }
            curr = curr.left;
        }
    }

    public void inorderTraversal(TreeLinkNode A) {

        if(A==null) return;
        inorderTraversal(A.left);
        A.next=null;
        inorderTraversal(A.right);
    }
}
