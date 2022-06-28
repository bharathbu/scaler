/**
 * Equal Tree Partition
 *
 * Problem Description
 * Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 0 <= value of node <= 109
 *
 *
 *
 * Input Format
 * First and only argument is head of tree A.
 *
 *
 *
 * Output Format
 * Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *                 5
 *                /  \
 *               3    7
 *              / \  / \
 *             4  6  5  6
 * Input 2:
 *
 *
 *                 1
 *                / \
 *               2   10
 *                   / \
 *                  20  2
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Remove edge between 5(root node) and 7:
 *         Tree 1 =                                               Tree 2 =
 *                         5                                                     7
 *                        /                                                     / \
 *                       3                                                     5   6
 *                      / \
 *                     4   6
 *         Sum of Tree 1 = Sum of Tree 2 = 18
 * Explanation 2:
 *
 *  The given Tree cannot be partitioned.
 */
package com.advanced.dsa.trees;

import java.util.HashSet;
import java.util.Set;

/*
After removing some edge from parent to child,
(where the child cannot be the original root)
the subtree rooted at child must be half the sum of the entire tree.

Let’s record the sum of every subtree. We can do this recursively using depth-first search.
After, we should check that half the sum of the entire tree occurs somewhere in our recording
(and not from the total of the entire tree.)
 */
public class EqualTreePartition {
    public int solve(TreeNode A) {
        Set<Long> set = new HashSet<>();
        Long total = populate(A,set);
        if(total == 0 && set.contains(total)) return 1;
        return total%2==0 && set.contains(total/2) ? 1 : 0;

    }

    private Long populate(TreeNode a, Set<Long> set) {
        if(a == null) return 0L;
        long sum = a.val+populate(a.left,set)+populate(a.right,set);
        set.add(sum);
        return sum;
    }
}
