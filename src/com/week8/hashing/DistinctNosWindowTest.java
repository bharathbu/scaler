/**
 * Distinct Numbers in Window
 * 
 * Problem Description

You are given an array of N integers, A1, A2 ,…, AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format

First argument is an integer array A
Second argument is an integer B.



Output Format

Return an integer array.



Example Input

Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output

Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation

Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class DistinctNosWindowTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(34);A.add(63);A.add(64);A.add(63);A.add(65);
		A.add(83);A.add(50);A.add(34);A.add(18);A.add(34);
		System.out.println(dNums(A,3));
	}
	
	public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		int n=A.size(),curr,first,count = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = null;
		map = new HashMap<Integer, Integer>();
		//first window
		for(int i=0;i<B;i++) {
			curr = A.get(i);
			map.put(curr, map.getOrDefault(curr, 0)+1);
		}
		result.add(map.size());
		
		//traverse through remaining array
		for(int i=B;i<n;i++) {
			first = A.get(i-B);
			curr = A.get(i);
			if(map.get(first)==1) 
				map.remove(first);
			else 
				map.put(first, map.get(first)-1);
			map.put(curr, map.getOrDefault(curr, 0)+1);
			result.add(map.size());
		}
		return result;
    }

}
