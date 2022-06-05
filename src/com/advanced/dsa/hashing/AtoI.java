/**
 * Atoi
 *
 * There are certain questions where the interviewer would intentionally frame the question vague.
 * The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.
 *
 * Implement atoi to convert a string to an integer.
 *
 * Example :
 *
 * Input : "9 2704"
 * Output : 9
 * Note: There might be multiple corner cases here. Clarify all your doubts using "See Expected Output".
 *
 * Questions:
 *
 * Q1. Does string contain whitespace characters before the number? A. Yes
 *
 * Q2. Can the string have garbage characters after the number? A. Yes. Ignore it.
 *
 * Q3. If no numeric character is found before encountering garbage characters, what should I do? A. Return 0.
 *
 * Q4. What if the integer overflows? A. Return INTMAX if the number is positive, INTMIN otherwise.
 *
 * Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI. If you do, we will disqualify your submission retroactively and give you penalty points.
 */
package com.advanced.dsa.hashing;

public class AtoI {
/*
We only need to handle four cases:

Discards all leading whitespaces

Sign of the number

Overflow

Invalid input

Detecting overflow gets tricky. You need to detect overflow before the number is about to overflow.

So:

If the number is positive and the current number is greater than MAX_INT/10, and you are about to append a digit, then certainly your number will overflow.

If the current number = MAX_INT / 10, then based on the last digit, we can detect if the number will overflow.

 */
    public static void main(String[] args){
        System.out.println(atoi("-54332872018247709407 4 54"));
    }
    public static int atoi(final String A) {
        int n=A.length(),sign=1,k=0;
        StringBuilder sb = new StringBuilder();
        if(A.charAt(0) == '-' || A.charAt(0) == '+'){
            k++;
            if(A.charAt(0) == '-')
                sign=-1;
        }
        long ans = 0;
        for (int i = k; i < n; i++) {
            char ch = A.charAt(i);
            if(ch>='0' && ch<='9' )
                ans = ans*10+(ch-'0');
            else break;

            if(ans>Integer.MAX_VALUE)
                break;
        }
        if(sign==-1)
            ans=ans*-1;
        //ans = Long.parseLong(sb.toString());
        if(ans>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(ans<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else return (int) ans;

    }
}
