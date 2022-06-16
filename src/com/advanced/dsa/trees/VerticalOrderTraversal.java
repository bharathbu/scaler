/**
 *  Vertical Order traversal
 *
 * Problem Description
 * Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
 *
 *
 * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 *
 * Problem Constraints
 * 0 <= number of nodes <= 105
 *
 * Input Format
 * First and only arument is a pointer to the root node of binary tree, A.
 * Output Format
 * Return a 2D array denoting the vertical order traversal of tree as shown.
 *
 * Example Input
 * Input 1:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 * Input 2:
 *
 *       1
 *     /   \
 *    3     7
 *   /       \
 *  2         9
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     [2],
 *     [3],
 *     [6, 5],
 *     [7],
 *     [9]
 *  ]
 * Output 2:
 *
 *  [
 *     [2],
 *     [3],
 *     [1],
 *     [7],
 *     [9]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  First row represent the verical line 1 and so on.
 */
package com.advanced.dsa.trees;

import java.util.*;

public class VerticalOrderTraversal {

    public class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
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
            int n =list.size();
            List level = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                level.add(list.get(j).val);
            }
            result.add((ArrayList<Integer>) level);
        }
        return result;
    }
}
