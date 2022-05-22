/**
 * 4 Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * Example : Given array S = {1 0 -1 0 -2 2}, and target = 0 A solution set is:
 *
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *     (-1,  0, 0, 1)
 * Also make sure that the solution set is lexicographically sorted. Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND … Solution[i][k] < Solution[j][k])
 */
package com.advanced.dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class QuadrupletsSum {
    /*
    When the array is sorted, try to fix the least and second least integer by looping over it.
    Lets say the least integer in the solution is arr[i] and second least is arr[j].
    Now we need to find a pair of integers k and l such that arr[k] + arr[l] is target-arr[i]-arr[j].
    To do that, lets try the 2 pointer approach. If we fix the two pointers at the end ( that is, j+1 and end of array ), we look at the sum.
    If the sum is smaller than the sum we want, we increase the first pointer to increase the sum.
    If the sum is bigger than the sum we want, we decrease the end pointer to reduce the sum.

    Note that there is one more solution possible if the question only asked to answer YES / NO to suggest whether there existed at least one tuple with the target sum.
    Then we could have gone with an approach using more memory with hashing.
     */
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> quad;

        Collections.sort(A);

        for (int i = 0; i < n-1; i++) {
            int a=A.get(i);
            for (int j = i+1; j < n; j++) {
                int b=A.get(j),t = B-(a+b);
                int front = j+1;
                int back=n-1;

                while(front < back){
                    int sum = A.get(front)+A.get(back);
                    if(sum<t){
                        front++;
                    }else if (sum>t){
                        back--;
                    }else{
                        quad = new ArrayList<>();
                        int c = A.get(front), d=A.get(back);
                        quad.add(a);
                        quad.add(b);
                        quad.add(c);
                        quad.add(d);
                        result.add(quad);
                        while (front < back && A.get(front) == c) front++;
                        while (back > front && A.get(back) == d) back--;
                    }
                }
                while (j + 1 < n && b == A.get(j + 1)) j++;
            }
            while (i + 1 < n && a == A.get(i + 1)) i++;
        }

        return result;
    }
}
