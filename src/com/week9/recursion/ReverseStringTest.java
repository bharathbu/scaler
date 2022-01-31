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
		printReverse(str,0,str.length()-1);
	}
	
	public static void printReverse(String str,int s,int e) {
		if(e==s-1) {
			return;
		}
		System.out.print(str.charAt(e));
		printReverse(str,s,e-1);
	}
}
