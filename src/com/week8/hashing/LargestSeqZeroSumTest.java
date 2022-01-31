/**
 * Largest Continuous Sequence Zero Sum
 * 
 * Problem Description

Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.



Problem Constraints

1 <= N <= 106

-107 <= A[i] <= 107



Input Format

Single argument which is an integer array A.



Output Format

Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.



Example Input

A = [1,2,-2,4,-4]


Example Output

[2,-2,4,-4]


Example Explanation

[2,-2,4,-4] is the longest sequence with total sum of zero.
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class LargestSeqZeroSumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);A.add(2);A.add(-3);A.add(3);
		//A.add(-19);A.add(8);A.add(2);A.add(-8); A.add(19);A.add(5);A.add(-2);A.add(-23);
		//A.add(0);A.add(19);A.add(18);A.add(-8); A.add(59);A.add(-9);A.add(-72);A.add(52);A.add(-2);A.add(23);A.add(92);
		System.out.println(lszero(A));
	}
	
	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int n = A.size(),dist = Integer.MIN_VALUE,s=-1,e=-1,j=-1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] lp = new int[n];
		lp[0] = A.get(0);
		map.put(lp[0], 0);
		for(int i=1;i<n;i++) {
			lp[i] = lp[i-1]+A.get(i);
			map.put(lp[i], i);
		}
		for(int i=0;i<n;i++) {
			j = map.get(lp[i]);
			if(j-i>dist && j!=i  && lp[j]!=0) {
				dist = j-i;
				s=i+1;
				e=j;
			}else if(j+1>dist && lp[j]==0) {
				dist = j+1;
				s=0;
				e=j;
			}
			
		}
		if(s>-1 && e>-1) {
			for(int i=s;i<=e;i++) {
				result.add(A.get(i));
			}
		}
		return result;
    }

}
