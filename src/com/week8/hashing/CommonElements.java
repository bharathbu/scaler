/**
 * Common Elements
 * 
 * Problem Description

Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.


Problem Constraints

1 <= N, M <= 105

1 <= A[i] <= 109



Input Format

First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format

Return an integer array denoting the common elements.



Example Input

Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output

Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation

Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class CommonElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);A.add(2);A.add(2);A.add(1);
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(2);B.add(3);B.add(1);B.add(2);
		System.out.println(solve(A,B));

	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n = A.size(),m=B.size(),curr=0,count=0;
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			count = (map.get(curr)==null ? 0:map.get(curr));
			map.put(curr, (count==0)?1:count+1);
		}
		for(int i=0;i<m;i++) {
			curr = B.get(i);
			count = (map.get(curr)==null ? 0:map.get(curr));
			if(count!=0) {
				map.put(curr, count-1);
				result.add(curr);
			}
		}
		return result;
    }
}
