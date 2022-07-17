/**
 * Rat In a Maze
 *
 * Problem Description
 *
 * Given a grid A, a rat is at position (1, 1). He wants to go to the position (n, n) where n is size of the square matrix A.
 *
 * 1 represents a traversable cell and 0 represents a non-traversable cell. Rat can only move right or down.
 *
 * Return a path that the rat can take.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 4
 *
 *
 *
 * Input Format
 *
 * First and only argument is the vector of vectors A.
 *
 *
 *
 * Output Format
 *
 * Return a vector of vectors that denotes a path that can be taken.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [   [1, 0]
 *         [1, 1]
 *     ]
 * Input 2:
 *
 * A = [    [1, 1, 1]
 *          [1, 0, 1]
 *          [0, 0, 1]
 *     ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [   [1, 0]
 *     [1, 1]
 * ]
 * Output 2:
 *
 * [    [1, 1, 1]
 *      [0, 0, 1]
 *      [0, 0, 1]
 * ]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Path is shown in output.
 * Explanation 2:
 *
 *  Path is shown in output.
 */
package com.advanced.dsa.backtracking;

import java.util.ArrayList;

public class RatInMaze {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                path.add(0);
            }
            result.add(path);
        }
        solve(A,n,0,0);
        return result;
    }

    private boolean solve(ArrayList<ArrayList<Integer>> A, int n, int i, int j) {
        if(i<0 || i>=n || j<0 || j>=n) return false;
        //if(A.get(i).get(j)==0 || A.get(i).get(j)==2) return;
        if(i==n-1 && j==n-1 && A.get(i).get(j) == 1) {
            result.get(i).set(j,1);
            return true;
        }

        if(A.get(i).get(j)==1){//traversible cell
            result.get(i).set(j,1);

            if(solve(A,n,i,j+1))
                return true;
            if(solve(A,n,i+1,j))
                return true;

            //revert changes
            result.get(i).set(j,0);
        }
        return false;
    }
}
