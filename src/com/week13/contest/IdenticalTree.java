/**
 * Given two binary trees A and B, make them identical with only below operation:
 *  - In each operation you can swap the left pointer and right pointer of any node.
 *  Return minimum no. of operations reqd to make both the trees identical, if impossible return -1.
 *
 */
package com.week13.contest;

public class IdenticalTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    public int solve(TreeNode A, TreeNode B) {
        if(A.val == B.val)
            return recur(A,B);
        else
            return -1;
    }

    public boolean check(TreeNode A, TreeNode B) {
        if(A == null && B== null)
            return true;
        if(A == null || B==null)
            return false;
        if(A.val == B.val)
            return true;
        return false;
    }
    public int recur(TreeNode A, TreeNode B) {
        int ans = 0;
        if(check(A.left,B.left) &&
                check(A.right,B.right)){
            int temp = 0;
            if(A.left != null)
                temp = recur(A.left,B.left);
            if(temp == -1) return -1;
            ans+=temp;
            temp=0;
            if(A.right != null)
                temp = recur(A.right,B.right);
            if(temp == -1) return -1;
            ans+=temp;
        }else if(check(A.left,B.right) &&
                check(A.right,B.left)){
            int temp = 0;
            ans+=1;
            if(A.left != null)
                temp = recur(A.left,B.right);
            if(temp==-1) return -1;
            ans+=temp;

            temp = 0;
            if(A.right != null)
                temp = recur(A.right,B.left);
            if(temp==-1) return -1;
            ans+=temp;
        }else return -1;

        return ans;
    }
}
