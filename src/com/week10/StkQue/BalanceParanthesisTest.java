/**
 * Balanced Parantheses!
 * 
 * Problem Description

Given a string A consisting only of '(' and ')'.

You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.



Problem Constraints

1 <= |A| <= 105



Input Format

First argument is an string A.



Output Format

Return 1 if parantheses in string are balanced else return 0.



Example Input

Input 1:

 A = "(()())"
Input 2:

 A = "(()"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Given string is balanced so we return 1
Explanation 2:

 Given string is not balanced so we return 0
 */
package com.week10.StkQue;

import java.util.Stack;

/**
 * @author Bharath
 *
 */
public class BalanceParanthesisTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve(")))"));

	}
	
	public static int solve(String A) {
		int result = 0,n=A.length();
		char curr;
		Stack<Character> stk = new Stack<Character>();
		for(int i=0;i<n;i++) {
			curr = A.charAt(i);
			if(curr == '(') 
				stk.push(curr);
			else if(!stk.empty() && stk.peek()=='(')
				stk.pop();
			else {
				stk.push(curr);
				break;
			}
		}
		if(stk.empty())
			result=1;
		return result;
    }

}
