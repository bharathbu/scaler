/**
 * Shaggy and distances
 * 
 * Problem Description

Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array as a special pair if elements at that index in the array are equal.

Shaggy wants you to find a special pair such that distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array then return -1.



Problem Constraints

1 <= |A| <= 105



Input Format

First and only argument is the array A.



Output Format

Return one integer corresponding to the minimum possible distance between a special pair.



Example Input

Input 1:

A = [7, 1, 3, 4, 1, 7]
Input 2:

A = [1, 1]


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

Here we have 2 options:
1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
Therefore the minimum possible distance is 3. 
Explanation 2:

Only possibility is choosing A[1] and A[2].
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class ShaggyDistancesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(5);A.add(5);A.add(5);A.add(-9);A.add(105);
		System.out.println(solve(A));
	}
	
	public static int solve(ArrayList<Integer> A) {
		int result=Integer.MAX_VALUE,n=A.size(),dist=-1,temp;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			map.put(A.get(i), i);
		}
		for(int i=0;i<n;i++) {
			temp=map.get(A.get(i));
			if(temp!=i) {
				dist = Math.abs(i-temp);
				if(dist<result)
					result=dist;
			}
		}
		if(result==Integer.MAX_VALUE)
			result=-1;
		return result;
    }

}
