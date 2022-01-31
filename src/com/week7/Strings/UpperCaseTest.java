/**
 * 
 */
package com.week7.Strings;

import java.util.ArrayList;

/**
 * @author Bharath
 *
 */
public class UpperCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Character> A = new ArrayList<Character>();
		A.add('A');A.add('b');A.add('0');A.add('Z');A.add('M');A.add('N');A.add('o');A.add('p');
		System.out.println(to_upper(A) );
	}
	
	public static ArrayList<Character> to_upper(ArrayList<Character> A) {
		ArrayList<Character> result = new ArrayList<Character>();
		int n = A.size();
		Character curr = null;
		for(int i=0;i<n;i++) {
			curr = A.get(i);
			if((curr>='a') && (curr<='z')) {
				curr = (char) (curr^32);
			}
			result.add(curr);
		}
		return result;
    }

}
