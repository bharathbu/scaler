/**
 * Length of longest consecutive ones
 * 
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
    
 */
package com.week5.TwoDMatrix;

/**
 * @author Bharath
 *
 */
public class LongestConsec1Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve("1111"));

	}
	
	public static int solve(String A) {
		
		int result=-1,count=0,n=A.length(),maxCount=0;
		int[] lps = new int[n];
		int[] rss = new int[n];
		
		lps[0] = A.charAt(0)-48;
		rss[n-1] = A.charAt(n-1)-48;
		for(int i=1;i<n;i++) {
			if(A.charAt(i) == '1') {
				lps[i] = lps[i-1]+1;
				count++;
			}else
				lps[i] = 0;
		}
		if(lps[0] ==1)
			count++;
		for(int i=n-2;i>=0;i--) {
			if(A.charAt(i) == '1') {
				rss[i] = rss[i+1]+1;
			}else
				rss[i] = 0;
		}
		
		for(int i=0;i<n;i++) {
			if(A.charAt(i) == '0'){
				if(i>0 && i<n-1) {
					maxCount = lps[i-1]+rss[i+1];
				}else if(i<n-1){
					maxCount = rss[i+1];
				}else {
					maxCount = lps[i-1];
				}
				
				if(count>maxCount) {
					maxCount++;
				}
				if(maxCount> result)
					result=maxCount;
			}
		}
		if(result<0)
			result=count;
		return  result;
        
    }

}
