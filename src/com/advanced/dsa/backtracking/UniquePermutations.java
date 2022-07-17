/**
 *  All Unique Permutations
 *
 * Problem Description
 * Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * NOTE: No 2 entries in the permutation sequence should be the same.
 *
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 9
 *
 * 0 <= A[i] <= 10
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible unique permutation of the array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [1,1,2]
 *   [1,2,1]
 *   [2,1,1] ]
 * Output 2:
 *
 * [ [1, 2]
 *   [2, 1] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All the possible unique permutation of array [1, 1, 2].
 * Explanation 2:
 *
 *  All the possible unique permutation of array [1, 2].
 */
package com.advanced.dsa.backtracking;

import java.util.*;
/*
Try to think of a recursive solution in which iterate over the given array and on every ietartion the ith element
is picked as the first element of the current array and again call recurive function on the remaining suffix array.
Using recursion and backtracking we can iterate over all possible permutations but there will be many duplicates due to
duplicate element possibility in the given array. How can we resolve this?

Whatever approach we were following we follow the same approach just this time instead of iterating over the whole array
in the recursive call we iterate only over the unique elements and reduce its frequency by 1 on further calls. This ensures
that duplicate recursive call are not made keeping the same element in the same position. The frequencies can be tracked by
using a frequency hashmap and updating it in the whole process in all recursive call and backtracking steps.
Check Implementation for details.
The overall time complexity in the worst case is O(N!) as in the worst case maximum number of permutations is N!.
Space Complexity - O(N)
 */
public class UniquePermutations {
    Set<ArrayList<Integer>> set = new HashSet<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int n = A.size();
        generatePermutation(A,n,0);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int r = set.size();

        Iterator itr = set.iterator();
        while(itr.hasNext()){
            result.add((ArrayList<Integer>) itr.next());
        }
        return result;
    }

    private void generatePermutation(ArrayList<Integer> A, int n, int i) {
        if(i==n-1){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (Integer v:
                    A) {
                tmp.add(v);
            }
            set.add(tmp);
            return;
        }
        for (int j = i; j < n; j++) {
            Collections.swap(A,i,j);
            generatePermutation(A,n,i+1);
            Collections.swap(A,i,j);
        }
    }
}
