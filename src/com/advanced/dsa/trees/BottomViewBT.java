/**
 * Bottom View Of Binary Tree
 *
 * Problem Description
 *
 * Given a Binary Tree A consisting of N integer nodes, you need to print the bottom view from left to right.
 *
 * A node x is there in output if x is the bottom-most node at its horizontal distance.
 *
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
 *
 * Note: If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= N <= 105
 *
 *
 *
 * Input Format
 *
 * First and only Argument represents the root of binary tree A.
 *
 *
 *
 * Output Format
 *
 * Return an one-dimensional integer array denoting the bottom view of A from left to right.
 *
 *
 *
 * Example Input
 *
 * Input:1
 *
 *                       20
 *                     /    \
 *                   8       22
 *                 /   \      \
 *               5      3      25
 *                     / \
 *                   10    14
 * Input:2
 *
 *                       20
 *                     /    \
 *                   8       22
 *                 /   \    /   \
 *               5      3  4    25
 *                     / \
 *                   10    14
 *
 *
 * Example Output
 *
 * Output:1
 *
 *  [5, 10, 3, 14, 25]
 * Output:2
 *
 *  [5, 10, 4, 14, 25]
 *
 *
 * Example Explanation
 *
 * Explanation:1
 *
 * Node 5 has a horizontal distance of -2 and it is the bottom-most node at this distance.
 * Node 10 has a horizontal distance of -1 and it is the bottom-most node at this distance.
 * Node 3 has a horizontal distance of 0 and it is the bottom-most node at this distance.
 * Node 14 has a horizontal distance of 1 and it is the bottom-most node at this distance.
 * Node 25 has a horizontal distance of 2 and it is the bottom-most node at this distance.
 * Explanation:2
 *
 *
 *  Node 5 has a horizontal distance of -2 and it is the bottom-most node at this distance.
 *  Node 10 has a horizontal distance of -1 and it is the bottom-most node at this distance.
 *  Node 3 and Node 4 has a horizontal distance of 0 and they are the bottom-most node at this distance but we will output the one who comes later in level-order traversal so we output 4.
 *  Similarly for Node 14 and 25
 */
package com.advanced.dsa.trees;

import java.util.*;
/*
Method 1 – Using Queue

The following are steps to print Bottom View of Binary Tree.

1.We put tree nodes in a queue for the level order traversal.

2.Start with the horizontal distance(hd) 0 of the root node, keep on adding left child to queue along with the horizontal distance as hd-1 and right child as hd+1.

3.Also, use a TreeMap which stores key value pair sorted on key.

4.Every time, we encounter a new horizontal distance or an existing horizontal distance put the node data for the horizontal distance as key. For the first time it will add to the map, next time it will replace the value. This will make sure that the bottom most element for that horizontal distance is present in the map and if you see the tree from beneath that you will see that element.

Time Complexity of hashing based solution can be considered as O(n) under the assumption that we have good hashing function that allows insertion and retrieval operations in O(1) time.
In the above C++ implementation, map of STL is used. map in STL is typically implemented using a Self-Balancing Binary Search Tree where all operations take O(Logn) time.
Therefore time complexity of the above implementation is O(nLogn).

Method 2- Using HashMap()
Approach:
Create a map like, map where key is the horizontal distance and value is a pair(a, b) where a is the value of the node and b is the height of the node. Perform a pre-order traversal of the tree.
If the current node at a horizontal distance of h is the first we’ve seen, insert it in the map.
Otherwise, compare the node with the existing one in map and if the height of the new node is greater, update in the Map.
 */
public class BottomViewBT {

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
            result.add(list.get(list.size()-1).val);
        }
        return result;
    }
}
