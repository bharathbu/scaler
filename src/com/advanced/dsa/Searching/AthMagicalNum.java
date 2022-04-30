package com.advanced.dsa.Searching;

import static com.advanced.dsa.math.GCDTest.gcd;

public class AthMagicalNum {

    public static void main(String[] args){
        System.out.println(solve(807414236,3788,38141));

    }
    public static int solve(int A, int B, int C) {
        long l=1,h=(long) Math.min(B,C)*A, mid=0,ans=0;
        int gcd = gcd(B,C);
        int lcm = (B*C)/gcd;
        while(l<=h){
            mid= (l+h)/2;
            int x = count(mid,B,C,lcm);
            if(x >= A){
                ans = mid;
                h = mid-1;
            }
            else l=mid+1;
        }
        return (int)(ans%1000000007);
    }

    private static int count(long N, int B, int C, int lcm) {
        return (int) (N/B+N/C-N/lcm);
    }
}
