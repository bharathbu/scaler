/**
 *  Excel Column Number
 *  
 *  Problem Description

Given a column title as appears in an Excel sheet, return its corresponding column number.



Problem Constraints

1 <= length of the column title <= 5



Input Format

Input a string which represents the column title in excel sheet.



Output Format

Return a single integer which represents the corresponding column number.



Example Input

Input 1:

 AB
Input 2:

 ABCD


Example Output

Output 1:

 28
Output 2:

 19010


Example Explanation

Explanation 1:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
package com.week5.TwoDMatrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class ExcelColumnNumberTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(titleToNumber("ABCD"));

	}
	
	public static int titleToNumber(String A) {
		/*int result=0, n=A.length();
		Map<String,Integer> map = new HashMap<String,Integer>();
		String character="";
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<26;i++) {
			character=String.valueOf(alpha.charAt(i));		
			map.put(character,i+1);
		}
		
		for(int i=n-1;i>=0;i--) {
			character = String.valueOf(A.charAt(i));
			result+=Math.pow(26, n-i-1)*map.get(character);
		}
		return result;*/
		int[] val = new int[26];
	    for (int i = 0; i < 26; i++) {
	        val[i] = i + 1;
	    }
	    int mul = 1;
	    int value = 0;
	    for (int i = A.length() - 1; i >= 0; i--) {
	        char c = A.charAt(i);
	        value += (mul * val[c - 'A']);
	        mul *= 26;
	    }
	    return value;
    }

}
