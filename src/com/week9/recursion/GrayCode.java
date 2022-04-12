package com.week9.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {

    public static void main(String[] args){
        /*
        Let G(n) represent a gray code of n bits.
        Note that the reverse of G(n) is also a valid sequence.
        Let R(n) denote the reverse of G(n).

        Note that we can construct.
        G(n+1) as the following :
        0G(n)
        1R(n)

        Where 0G(n) means all elements of G(n) prefixed with 0 bit and 1R(n) means all elements of R(n) prefixed with 1.
        Note that the last element of G(n) and the first element of R(n) are the same. So the above sequence is valid.

        Example G(2) to G(3) :
        0 00
        0 01
        0 11
        0 10
        1 10
        1 11
        1 01
        1 00
         */
        System.out.println(grayCode(5));
    }

    public static ArrayList<Integer> grayCode(int a) {
        if(a==0) return new ArrayList<>(Arrays.asList(0));

        if(a==2) return new ArrayList<>(Arrays.asList(0,1,3,2));

        ArrayList<Integer> result = grayCode(a-1);

        for (int i = 0; i < (1<<a)/2; i++) {
            int temp = result.get((1<<a-1)-1-i) | (1<<a-1);
            result.add(i+((1<<a)/2) ,temp);
        }

        return result;
    }

}
