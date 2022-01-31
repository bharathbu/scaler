/**
 * Subset
 * 
 * Problem Description

Given a set of distinct integers, A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints

1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format

First and only argument of input contains a single integer array A.



Output Format

Return a vector of vectors denoting the answer.



Example Input

Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output

Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]


Example Explanation

Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets.
 */
package com.week12.subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Bharath
 *
 */
public class SubsetsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(12);
		A.add(13);
		int n = A.size(), rows = (1<<n);
		
		ArrayList<ArrayList<Integer>> result = subsets(A);
		
		/*for(int i=0;i<rows;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(result.get(i).get(j)+ " ");
			}
			System.out.println();
		}*/
		System.out.println(result);
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		Collections.sort(A);
		int n = A.size(), rows = (1<<n);
		ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row = null;
		for(int i=0;i<rows;i++) {
			//result.add(new ArrayList<Integer>());
			row = new ArrayList<Integer>();
			for(int j=0;j<n;j++) {
				if(checkBit(i,j)) 
					row.add(A.get(j));
			}
			result.add(row);
		}
		Collections.sort(result, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
		return result;
    }

	private static boolean checkBit(int i, int j) {
		if((i&(1<<j)) > 0)
				return true;		
		return false;
	}

}
