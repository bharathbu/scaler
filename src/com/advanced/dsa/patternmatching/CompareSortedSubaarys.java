package com.advanced.dsa.patternmatching;

import java.util.HashMap;

public class CompareSortedSubaarys {

    public static HashMap<Integer, Long> map = new HashMap<>();
    public static void main(String[] args){
        int[] A = { 100000, 100000, 100000, 100000, 100000};
        int[][] B = {
                {0, 3, 1, 4},
        {0, 1, 2, 3},
            {4, 4, 1, 1},
                {1, 3, 0, 0},
                    {2, 4, 1, 1}
        };
        System.out.println(solve(A,B));
    }
    public static int[] solve(int[] A, int[][] B) {
        int N = A.length;
        int[] res = new int[B.length];

        //Converting values of A to hashValue
        setHash(A);

        long[] prefix = new long[N];
        prefix[0] = map.get(A[0]);
        for(int i=1; i<N; i++) {
            prefix[i] = prefix[i-1] + map.get(A[i]);
        }

        for(int i=0; i<B.length; i++) {
            int[] range = B[i];
            int L1=range[0], R1=range[1], L2=range[2], R2=range[3];

            res[i] = 0;
            if(R1-L1 == R2-L2) {
                long sum1 = 0, sum2 = 0;
                if(L1 == 0) {
                    sum1 = prefix[R1];
                } else {
                    sum1 = prefix[R1] - prefix[L1-1];
                }

                if(L2 == 0) {
                    sum2 = prefix[R2];
                } else {
                    sum2 = prefix[R2] - prefix[L2-1];
                }

                if(sum1 == sum2) {
                    res[i] = 1;
                }
            }
        }
        return res;
    }

    private static void setHash(int[] A) {
        int N = A.length;
        long range = 1000*1000*1000*1000;

        for(int i=0; i<N; i++) {
            long hashValue = (long)(Math.random() * range + 1);

            if(!map.containsKey(A[i])) {
                map.put(A[i], hashValue);
            }
        }
    }
}
