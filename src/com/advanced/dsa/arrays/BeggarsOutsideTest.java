/**
 * Beggars Outside Temple
 *
 * There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.
 *
 * Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
 *
 * Example:
 *
 * Input:
 * N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 *
 * Return: [10, 55, 45, 25, 25]
 *
 * Explanation:
 * => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
 *
 * => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
 *
 * => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 *
 */

package com.advanced.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class BeggarsOutsideTest {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> d1 = new ArrayList<>();
        d1.add(1);d1.add(2);d1.add(10);
        ArrayList<Integer> d2 = new ArrayList<>();
        d2.add(2);d2.add(3);d2.add(20);
        ArrayList<Integer> d3 = new ArrayList<>();
        d3.add(2);d3.add(5);d3.add(25);
        B.add(d1);
        B.add(d2);
        B.add(d3);

        int A=5;
        System.out.println(solve(A,B));

    }

    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        int Q = B.size(),s,e,v,temp; //no. of devotees or Q queries
        for(int i=0;i<A;i++)
            prefix.add(0);
        for(int i=0;i<Q;i++){
            s=B.get(i).get(0);
            e=B.get(i).get(1);
            v=B.get(i).get(2);
            temp=prefix.get(s-1);
            prefix.set(s-1,v+temp);
            if(e<A){
                temp=prefix.get(e);
                prefix.set(e,temp-v);
            }

        }
        result.add(prefix.get(0));
        for(int i=1;i<A;i++){
            temp=result.get(i-1);
            result.add(temp+prefix.get(i));
        }
        return result;
    }
}
