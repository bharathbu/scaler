/**
 * Subset
 *
 * Problem Description
 * Given a set of distinct integers A, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 *
 *
 * Input Format
 * First and only argument of input contains a single integer array A.
 *
 *
 *
 * Output Format
 * Return a vector of vectors denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *     []
 *     [1]
 * ]
 * Output 2:
 *
 * [
 *  []
 *  [1]
 *  [1, 2]
 *  [1, 2, 3]
 *  [1, 3]
 *  [2]
 *  [2, 3]
 *  [3]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You can see that these are all possible subsets.
 * Explanation 2:
 *
 * You can see that these are all possible subsets.
 */
package com.advanced.dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetGen {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A,Collections.reverseOrder());
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++)
            idx.add(0);
        generateAllSubsets(A,idx,n,0);
        return result;
    }

    private void generateAllSubsets(ArrayList<Integer> a, ArrayList<Integer> idx, int n, int i) {
        if(i == n){
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(idx.get(j) == 1)
                    subset.add(a.get(j));
            }
            result.add(subset);
            return;
        }
        idx.add(i,0);
        generateAllSubsets(a,idx,n,i+1);
        idx.add(i,1);
        generateAllSubsets(a,idx,n,i+1);
    }
}
