/**
 * 
 */
package com.week9.recursion;

import java.util.Scanner;

/**
 * @author Bharath
 *
 */
public class ReverseStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();	
		printReverse(str);
	}
	
	public static void printReverse(String str) {
		/*
		Recursive function (reverse) takes string (S) as input and calls itself with next location to passed pointer (s+1).

		Recursion continues this way, when pointer reaches ‘\0’, all functions accumulated in stack print char at passed location (S) and print one by one.

		Time Complexity: O(n)
		 */
		if(str.length() == 0) return;
		printReverse(str.substring(1));
		System.out.print(str.charAt(0));
	}
}
