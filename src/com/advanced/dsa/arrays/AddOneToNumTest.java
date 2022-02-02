/**
 * Add One To Number
 *
 * Problem Description
 *
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :
 *
 * Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 *
 *
 * Problem Constraints
 *
 * 1 <= size of the array <= 1000000
 *
 *
 *
 * Input Format
 *
 * First argument is an array of digits.
 *
 *
 *
 * Output Format
 *
 * Return the array of digits after adding one.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * [1, 2, 3]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [1, 2, 4]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 *
 */
package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumTest {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        //A.add(1);A.add(2);A.add(4);A.add(3);A.add(0);A.add(2);A.add(1);A.add(9);
        A.add(0);A.add(3);A.add(9);A.add(9);
        System.out.println(plusOne(A));

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size(),temp=0,carry=0,i;
        ArrayList<Integer> result = new ArrayList<>();
        for (i=0;i<n;i++){
            result.add(A.get(i));
        }
        temp = result.get(n-1)+1;
        if(temp<10){
            result.set(n-1,temp);
        }else{
            carry = temp/10;
            for(i=n-1;i>=1;i--){
                if(carry == 1){
                    temp = result.get(i)+carry;
                    result.set(i,temp%10);
                    carry=temp/10;
                }else{
                    carry = 0;
                    break;
                }
            }
            if(carry == 1){
                temp = result.get(0)+carry;
                if(temp == 10){
                    result.add(0,1);
                    result.set(1,0);
                }else{
                    result.set(0,result.get(0)+carry);
                    result.set(1,0);
                }
            }
            i=0;
            while(result.get(i) == 0 && i<n){
                result.remove(i);
                i++;
                n--;
            }
        }
        return result;
    }
}
