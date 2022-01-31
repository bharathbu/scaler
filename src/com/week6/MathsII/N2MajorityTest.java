/**
 * Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.
 */
package com.week6.MathsII;

/**
 * @author Bharath
 *
 */
public class N2MajorityTest {
	public static void main(String[] args) {
		int[] A = {3,1,1,5,1,4,1,1};
		System.out.println(majorityElement(A));

	}

	public static int majorityElement(final int[] A) {
		int result=0,maj=-1,freq=0,n=A.length,count=0;
		for(int i=0;i<n;i++) {
			if(maj == -1){
				maj = A[i];
				freq++;
			}else if(A[i] == maj) {
				freq++;
			}else {
				freq--;
				if(freq == 0)
					maj = -1;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(A[i] == maj)
				count++;
		}
		if(count >= (n/2)+1)
			result=maj;
		return result;
    }

}
