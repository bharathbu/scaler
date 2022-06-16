/**
 * Top View of Binary tree
 *
 * Problem Description
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
 *
 * The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
 *
 * Return the nodes in any order.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 10^9
 *
 *
 *
 * Input Format
 * First and only argument is head of the binary tree A.
 *
 *
 *
 * Output Format
 * Return an array, representing the top view of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *             1
 *           /   \
 *          2    3
 *         / \  / \
 *        4   5 6  7
 *       /
 *      8
 * Input 2:
 *
 *
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 4, 8, 3, 7]
 * Output 2:
 *
 *  [1, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Top view is described.
 * Explanation 2:
 *
 * Top view is described.
 */
package com.advanced.dsa.trees;

import java.util.*;
/*
You need to return every node to be visible from the top.
In other words, it should be the leftmost or the rightmost till that level.
This can be found using a queue and modifying the level order
traversal algorithm. You may need to maintain the level of each
node along with the nodes themselves.
 */
public class TopViewBT {
    public class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public ArrayList<Integer> solve(TreeNode A) {
        return verticalOrderTraversal(A);
    }

    public ArrayList<Integer> verticalOrderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<TreeNode>> map = new HashMap<>();
        q.add(new Pair(A,0));
        int minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        while(q.size()>0){
            Pair p = q.peek();
            q.remove();
            TreeNode t = p.node;
            int level = p.level;
            ArrayList<TreeNode> list = map.getOrDefault(level,null);
            minLevel = Math.min(minLevel,level);
            maxLevel = Math.max(maxLevel,level);
            if(list == null)
                list = new ArrayList<>();
            list.add(t);
            map.put(level, list);
            if(t.left != null)
                q.add(new Pair(t.left,level-1));
            if(t.right != null)
                q.add(new Pair(t.right,level+1));
        }

        for (int i = minLevel; i <= maxLevel ; i++) {
            List<TreeNode> list = map.get(i);
            result.add(list.get(0).val);
        }
        return result;
    }
}
