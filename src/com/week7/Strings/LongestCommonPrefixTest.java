/**
 * Longest Common Prefix
 * 
 * Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints

0 <= sum of length of all strings <= 1000000



Input Format

The only argument given is an array of strings A.



Output Format

Return the longest common prefix of all strings in A.



Example Input

Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output

Output 1:

"a"
Output 2:

"ab"


Example Explanation

Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
 */
package com.week7.Strings;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class LongestCommonPrefixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<String>();
		A.add("abcd");A.add("aze");
		System.out.println(longestCommonPrefix(A));
	}
	
	public static String longestCommonPrefix(ArrayList<String> A) {
		StringBuffer sb = new StringBuffer();
		int n=A.size(),minlength = Integer.MAX_VALUE,m=0;
		String curr=null;
		char tmp='\0';
		boolean flag=true;
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			m=curr.length();
			if(m<minlength) 
				minlength = m;
		}
		for(int j=0;j<minlength;j++) {
			tmp = A.get(0).charAt(j);
			for(int i=1;i<n;i++){
				curr = A.get(i);
				if(tmp!=curr.charAt(j)) {
					flag=false;
					break;
				}
			}
			if(flag) {
				sb.append(tmp);
			}else {
				break;
			}
		}
		return sb.toString();
		/*StringBuffer result = new StringBuffer();
		String prev=null,curr=null,finalResult=null;
		int n = A.size(),m=0,j=0,p=0,k=0;
		prev = A.get(0);
		for(int i=1;i<n;i++) {
			curr = A.get(i);
			m=curr.length();
			
			j=0;
			k=0;
			if(result.length()==0) {
				p = prev.length();
				while((j<p && k<m) && (curr.charAt(k)==prev.charAt(j)) ) {
					result.append(curr.charAt(k)); 
					k++;
					j++;
				}
			}else {
				p = result.length();
				while((j<p && k<m) ) {
					if(result.charAt(j)!=curr.charAt(k)) {
						result.delete(j, p);
						break;
					}
					k++;
					j++;
				}
				if(j<p) {
					result.delete(j, p);
				}
			}
			prev = curr;
		}
		if(n==1) {
			finalResult = prev;
		}else {
			finalResult = result.toString();
		}
		return finalResult.toString();*/
    }

}
