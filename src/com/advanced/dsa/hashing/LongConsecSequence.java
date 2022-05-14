/**
 * Longest Consecutive Sequence
 *
 * Problem Description
 * Given an unsorted integer array A of size N.
 *
 * Find the length of the longest set of consecutive elements from array A.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * -106 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 *
 * A = [2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 *
 *  The set of consecutive elements will be [1, 2].
 */
package com.advanced.dsa.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongConsecSequence {

    public static void main(String[] args){
        /*
        One solution is to sort the elements and then find the longest subarray with consecutive elements. But this will take O(NlogN).

        An efficient way is to use hashing.

        First, create an empty hash, and for each element, we insert and update the hash table and maxCount.

        We only insert the element which is not yet inserted.
        Calculate the lcount, i.e., the longest consecutive element till the current element - 1.
        Calculate the rcount, i.e., the longest consecutive element from the current element + 1.

        Update hMap[ele] (current element) = lcount + 1 + rcount.

        Also, update the maxCount.
         */
        int[] a = new int[]{100, 4, 200, 1, 3, 2};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(longestConsecutive(a));

    }
    public static int longestConsecutive(final int[] A) {
        int n=A.length;
        Set set = new HashSet();
        for (int i = 0; i < n; i++)
            set.add(A[i]);

        int sz = set.size(),ans=0,maxL=Integer.MIN_VALUE,temp=0;

        for (int i = 0; i < sz; i++) {
            if(set.contains(A[i]-1)){
                ans=0;
                temp=A[i];
                while(set.contains(temp)){
                    temp++;
                    ans++;
                }
                maxL = Math.max(ans,maxL);
            }
        }

        return maxL;
    }
}
