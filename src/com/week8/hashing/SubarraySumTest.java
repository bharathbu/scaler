/**
 * Subarray with given sum
 * 
 * Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output

Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation

Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class SubarraySumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);
		System.out.println(solve(A,6));

	}
	
	public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int n=A.size(),s=-1,e=-2,temp=0;
		long currSum=0;
		//[sum_0Toi -> (A[i].val -> i)] map
		Map<Long,Map<Integer,Integer>> map = new HashMap<Long,Map<Integer,Integer>>();
		Map<Integer,Integer> val;
		a:
		for(int i=0; i<n; i++) {
			temp = A.get(i);
			currSum += temp;
			val = new HashMap<Integer, Integer>();
			val.put(temp, i);
			if(currSum == B) {
				s=0; e=i; break;
			}			
			if (map.containsKey(currSum - B)) {
				for (java.util.Map.Entry<Integer, Integer> key : map.get(currSum - B).entrySet()) {
					s=key.getValue()+1;
					e=i;
					break a;
				}
			}
			if(!map.containsKey(currSum))
				map.put(currSum,val);
		}
		
		if(s<=e) {
			for(int i=s;i<=e;i++) {
				temp = A.get(i); 
				result.add(temp);
			}
		}else
			result.add(-1);
		return result;
    }

}
