package com.advanced.dsa.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PowerFunTest {
    public static void main(String args[]){

        System.out.println(pow(71045970,41535484,64735492));
    }
    public static int pow(int A, int B, int C) {
        if(A==0) return 0;
        if(B==0) return 1;

        int halfPow = pow(A,B/2,C);
        long halhAns = halfPow * halfPow;
        if(B%2 == 0){
            halhAns = halhAns%C;
            if(halhAns<0)
                halhAns = halhAns+C;
        }
        else{
            halhAns = (halhAns*A)%C;
            if(halhAns<0)
                halhAns = halhAns+C;

        }
        return (int)(halhAns);

    }
}
