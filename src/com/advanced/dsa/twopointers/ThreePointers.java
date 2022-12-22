/**
 * Array 3 Pointers
 *
 * Problem Description
 * You are given 3 sorted arrays A, B and C.
 *
 * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 *
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 *
 *
 *
 * Problem Constraints
 * 0 <= len(A), len(B), len(c) <= 106
 *
 * 0 <= A[i], B[i], C[i] <= 107
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer array B.
 *
 * Third argument is an integer array C.
 *
 * Output Format
 * Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 10]
 *  B = [2, 15, 20]
 *  C = [10, 12]
 * Input 2:
 *
 *  A = [3, 5, 6]
 *  B = [2]
 *  C = [3, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  1
 *
 * Example Explanation
 * Explanation 1:
 *
 *  With 10 from A, 15 from B and 10 from C.
 * Explanation 2:
 *
 *  With 3 from A, 2 from B and 3 from C.
 */
package com.advanced.dsa.twopointers;

import java.util.List;

/*
Windowing strategy works here.
Lets say the arrays are A,B and C.

Take 3 pointers X, Y and Z
Initialize them to point to the start of arrays A, B and C
Find min of X, Y and Z.
Compute max(X, Y, Z) - min(X, Y, Z).
If new result is less than current result, change it to the new result.
Increment the pointer of the array which contains the minimum.
Note that we increment the pointer of the array which has the minimum, because our goal is to decrease the difference.
Increasing the maximum pointer is definitely going to increase the difference.
Increase the second maximum pointer can potentially increase the difference ( however, it certainly will not decrease the difference ).
 */
public class ThreePointers {
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int l=A.size(),m=B.size(),n=C.size();
        int i=0,j=0,k=0;
        int res = Integer.MAX_VALUE;
        while(i<l && j<m && k<n){
            int min = Math.min(A.get(i),Math.min(B.get(j),C.get(k)));
            int max = Math.max(A.get(i),Math.max(B.get(j),C.get(k)));
            res = Math.min(res,max-min);
            if(A.get(i)<=B.get(j) && A.get(i)<=C.get(k))
                i++;
            else if(B.get(j)<=C.get(k) && B.get(j)<=A.get(i))
                j++;
            else k++;
        }
        return res;
    }
}
