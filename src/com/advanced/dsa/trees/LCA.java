/**
 * Least Common Ancestor
 *
 * Problem Description
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 *
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B, C <= 109
 *
 *
 *
 * Input Format
 * First argument is head of tree A.
 *
 * Second argument is integer B.
 *
 * Third argument is integer C.
 *
 *
 *
 * Output Format
 * Return the LCA.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *       1
 *      /  \
 *     2    3
 * B = 2
 * C = 3
 * Input 2:
 *
 *       1
 *      /  \
 *     2    3
 *    / \
 *   4   5
 * B = 4
 * C = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  LCA is 1.
 * Explanation 2:
 *
 *  LCA is 2.
 */
package com.advanced.dsa.trees;

import java.util.ArrayList;
import java.util.Collections;

public class LCA {
    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> p1 = solve(A,B);
        ArrayList<Integer> p2 = solve(A,C);

        int n=p1.size(),m=p2.size(),i=0;
        int min=Math.min(n,m);
        for (i = 0; i < min; i++) {
            if(!p1.get(i).equals(p2.get(i)))
                break;
        }
        if(min==0) return -1;
        i=i-1;
        return p1.get(i);
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> path=new ArrayList<>();
        check(A,B,path);
        Collections.reverse(path);
        return path;
    }

    public boolean check(TreeNode A, int B, ArrayList<Integer> path){
        if(A==null) return false;

        if(A.val == B){
            path.add(A.val);
            return true;
        }

        if(check(A.left,B, path) || check(A.right,B, path)){
            path.add(A.val);
            return true;
        }else return false;
    }
}
