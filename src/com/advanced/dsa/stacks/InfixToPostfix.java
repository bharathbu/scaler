/**
 * Infix to Postfix
 *
 * Problem Description
 * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
 *
 * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
 *
 * Find and return the postfix expression of A.
 *
 * NOTE:
 *
 * ^ has the highest precedence.
 * / and * have equal precedence but greater than + and -.
 * + and - have equal precedence and lowest precedence among given operators.
 *
 *
 * Problem Constraints
 * 1 <= length of the string <= 500000
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return a string denoting the postfix conversion of A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "x^y/(a*z)+b"
 * Input 2:
 *
 *  A = "a+b*(c^d-e)^(f+g*h)-i"
 *
 *
 * Example Output
 * Output 1:
 *
 *  "xy^az* /b+"
 *
 *  Output 2:
 *
 *  "abcd^e-fgh*+^*+i-"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Ouput dentotes the postfix expression of the given input.
 */
package com.advanced.dsa.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {

    /*
    Given the algorithm below, we have used a stack to keep the operators in the precedence order.

    Algorithm:

    Scan the infix expression from left to right.
    If the scanned character is an operand, output it.
    Else,
    3.1 If the precedence of the scanned operator is greater than that of the operator in the stack(or the stack is empty, or the stack contains a ‘(‘ ), push it.
    3.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that, Push the scanned operator to the stack. (If you encounter parenthesis while popping, stop there and push the scanned operator in the stack.)
    If the scanned character is an ‘(‘, push it to the stack.
    If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis.
    Repeat steps 2-6 until infix expression is scanned.
    Print the output
    Pop and output from the stack until it is not empty.
     */
    public static void main (String[] args){
       System.out.println(solve( "q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)"));
    }
    public static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        char tmp;
        int n=A.length();
        for (int i = 0; i < n; i++) {
            tmp=A.charAt(i);
            if(tmp>='a' && tmp<='z')
                sb.append(tmp);
            else{
                if(tmp=='(')
                    stk.push(tmp);
                else if(tmp==')'){
                    while(!stk.isEmpty() && stk.peek()!='(')
                        sb.append(stk.pop());
                    if(!stk.isEmpty() && stk.peek()=='(') stk.pop();
                }
                else{
                    if(!stk.isEmpty() && precedence(stk.peek()) >= precedence(tmp)){
                        while(!stk.isEmpty() && precedence(stk.peek()) >= precedence(tmp))
                            sb.append(stk.pop());
                        stk.push(tmp);
                    }else stk.push(tmp);
                }
            }
        }
        while(!stk.isEmpty()){
            tmp = stk.pop();
            if(tmp!='(')
                sb.append(tmp);
        }


        return sb.toString();
    }

    public static int precedence(char operand){
        if(operand=='+' || operand=='-')
            return 1;
        else if(operand=='*' || operand=='/')
            return 2;
        else if(operand=='^')
            return 3;
        else return 0;
    }
}
