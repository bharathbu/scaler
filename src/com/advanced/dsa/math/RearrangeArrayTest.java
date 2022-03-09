/**
 *  Rearrange Array
 *
 *  Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 * Lets say N = size of the array. Then, following holds true :
 *
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer
 */
package com.advanced.dsa.math;

import java.util.ArrayList;

public class RearrangeArrayTest {
    public static void main(String[] args){
        ArrayList<Integer> d1 = new ArrayList<Integer>();
        d1.add(5);d1.add(0);d1.add(1);d1.add(3);d1.add(4);d1.add(2);
        arrange(d1);
        int n=d1.size();
        for(int i=0;i<n;i++){
            System.out.print(d1.get(i)+" ");
        }
    }

    public static void arrange(ArrayList<Integer> a) {
        int n=a.size(),temp=0;
        for(int i=0;i<n;i++){
            temp = a.get(i);
            temp += (a.get(a.get(i))%n)*n;
            a.set(i,temp);
        }
        for(int i=0;i<n;i++){
            a.set(i,a.get(i)/n);
        }
    }

}
