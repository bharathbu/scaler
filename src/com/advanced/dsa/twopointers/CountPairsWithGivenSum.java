package com.advanced.dsa.twopointers;

public class CountPairsWithGivenSum {

    public static void main(String[] args){
        /*

         */
        int[] a = new int[]{1, 2, 3, 4, 5};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a,5));
    }

    public static int solve(int[] A, int B) {
        int n=A.length,p1=0,p2=n-1,count=0;
        while(p1<p2){
            int sum= A[p1]+A[p2];
            if(sum == B){
                count++;
                p1++;
            }else if(sum>B)
                p2--;
            else
                p1++;
        }
        return count;
    }
}
