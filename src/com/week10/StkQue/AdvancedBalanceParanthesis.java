/**
 * Balanced Paranthesis
 * 
 * Problem Description

Given an expression string A, examine whether the pairs and the orders of �{�,�}�, �(�,�)�, �[�,�]� are correct in A.

Refer to the examples for more clarity.



Problem Constraints

1 <= |A| <= 100



Input Format

The first and the only argument of input contains the string A having the paranthesis sequence.



Output Format

Return 0, if the paranthesis sequence is not balanced.

Return 1, if the paranthesis sequence is balanced.



Example Input

Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[] 


Example Output

Output 1:

 1 
Output 2:

 0 
Output 3:

 1 


Example Explanation

You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */
package com.week10.StkQue;

import java.util.Stack;

/**
 * @author Bharath
 *
 */
public class AdvancedBalanceParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solve("[]{}({})"));

	}
	
	public static int solve(String A) {
		int result=0, n=A.length();
		char curr;
		Stack<Character> stk = new Stack<Character>();
		for(int i=0;i<n;i++) {
			curr = A.charAt(i);
			if(curr == '(' || curr == '[' || curr == '{') 
				stk.push(curr);
			else if(!stk.empty() && ((stk.peek()=='(' && curr==')')||
					                 (stk.peek()=='[' && curr==']')||
					                 (stk.peek()=='{' && curr=='}')) )
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
