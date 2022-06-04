/**
 *  Evaluate Expression
 *
 *  Problem Description
 * An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each character may be an integer or an operator.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 *
 *
 * Input Format
 * The only argument given is character array A.
 *
 *
 *
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 *
 *
 *
 * Example Input
 * Input 1:
 *     A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 *     A = ["4", "13", "5", "/", "+"]
 *
 *
 * Example Output
 * Output 1:
 *     9
 * Output 2:
 *     6
 *
 *
 * Example Explanation
 * Explaination 1:
 *     starting from backside:
 *     * : () * ()
 *     3 : () * (3)
 *     + : (() + ()) * (3)
 *     1 : (() + (1)) * (3)
 *     2 : ((2) + (1)) * (3)
 *     ((2) + (1)) * (3) = 9
 * Explaination 2:
 *     + : () + ()
 *     / : () + (() / ())
 *     5 : () + (() / (5))
 *     13 : () + ((13) / (5))
 *     4 : (4) + ((13) / (5))
 *     (4) + ((13) / (5)) = 6
 */
package com.advanced.dsa.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixExprEvaluation {
    /*
    This is pretty much a simulation problem.
    Think using stack.

    When you encounter an operator, that is when you need the top 2 numbers on the stack, perform the operation on them, and put them on the stack.
     */
    public int evalRPN(ArrayList<String> A) {
        Stack<String> stk = new Stack<>();
        int n=A.size();
        for (int i = 0; i < n; i++) {
            String tmp = A.get(i);
            int res=0;
            if(tmp.equals("+")){
                res = Integer.parseInt(stk.pop())+Integer.parseInt(stk.pop());
                stk.push(String.valueOf(res));
            }
            else if(tmp.equals("-")){
                res = -Integer.parseInt(stk.pop())+Integer.parseInt(stk.pop());
                stk.push(String.valueOf(res));
            }
            else if(tmp.equals("*")){
                res = Integer.parseInt(stk.pop())*Integer.parseInt(stk.pop());
                stk.push(String.valueOf(res));
            }
            else if (tmp.equals("/")) {
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(stk.pop());
                res = b / a;
                stk.push(String.valueOf(res));
            }else{
                stk.push(tmp);
            }
        }
        return Integer.parseInt(stk.pop());
    }
}
