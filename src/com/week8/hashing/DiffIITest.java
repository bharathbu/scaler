/**
 * Diffk II
 * 
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bharath
 *
 */
public class DiffIITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(34);A.add(63);A.add(64);A.add(38);A.add(65);
		A.add(83);A.add(50);A.add(44);A.add(18);A.add(34);
		A.add(71);A.add(80);A.add(22);A.add(22);A.add(20);
		A.add(96);A.add(33);A.add(70);A.add(70);A.add(25);
		A.add(64);A.add(96);A.add(18);A.add(18);A.add(53);
		A.add(100);A.add(24);A.add(47);A.add(47);A.add(69);
		A.add(60);A.add(5);A.add(8);A.add(38);A.add(72);
		A.add(94);A.add(18);A.add(68);A.add(0);A.add(53);
		A.add(18);A.add(30);A.add(86);A.add(55);A.add(13);
		A.add(93);A.add(15);A.add(43);A.add(73);A.add(68);A.add(0);
		//A.add(1);A.add(53);A.add(2);A.add(68);A.add(0);
		System.out.println(diffPossible(A,97));

	}

	public static int diffPossible(final List<Integer> A, int B) {
		int result=0,n=A.size(),curr,diff;
		Set<Integer> set = new HashSet<Integer>();
		if(n>1) {
			for(int i=0;i<n;i++) {
				curr=A.get(i);
				diff=curr-B;
				if(set.contains(diff)|| (curr==0 && set.contains(B))) {
					result=1;
					break;
				}else if(set.contains(B+curr)) {
					result=1;
					break;
				}
				else {
					set.add(curr);
				}
			}
		}
		return result;
    }
}
