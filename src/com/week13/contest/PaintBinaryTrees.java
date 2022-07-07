/**
 * Ali and Billu are plaiying game on a binary tree A.
 * Ali has white paint and Billu has black.
 *
 * The game is as follows,
 *  1. Ali starts the game first.
 *  2. Each player chooses a previously unpainted node and paints it with his color.
 *  3. After both have painted all the nodes, Billu will paint all white nodes adjacent to it to Black
 *  4. If, after the above operation, there's any 1 node that is still white, ALi wins otherwise Billu wins.
 */
package com.week13.contest;

import java.util.HashSet;
import java.util.Set;

public class PaintBinaryTrees {
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
    Set<TreeNode> leaves = new HashSet<>();
    String ans = "Billu";
    public void dfs(TreeNode root){
        int c = 0;
        if(root.left != null){
            dfs(root.left);
            c++;
        }
        if(root.right != null){
            dfs(root.right);
            c++;
        }
        if(c==0){
            leaves.add(root);
            return;
        }
        if(c==1)
            return;
        //c has to be 2 in this case
        if(leaves.contains(root.left) && leaves.contains(root.right))
            ans = "Ali";
        return;
    }
    public String solve(TreeNode A) {
        dfs(A);
        if(A.left == null){
            if(leaves.contains(A.right.left) ||
                    leaves.contains(A.right.right))
                ans="Ali";
        }
        if(A.right == null){
            if(leaves.contains(A.left.left) ||
                    leaves.contains(A.left.right))
                ans="Ali";
        }
        return ans;
    }
}
