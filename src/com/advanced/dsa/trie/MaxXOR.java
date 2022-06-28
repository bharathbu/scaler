/**
 * Maximum XOR
 *
 * Problem Description
 * Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum result of A[i] XOR A[j].
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  117
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
 * Explanation 2:
 *
 *  Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 */
package com.advanced.dsa.trie;

import java.util.ArrayList;

public class MaxXOR {

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);
        System.out.println(solve(A));
    }
    static class Node{
        Node[] c = new Node[2];
        Node(){
            c[0] = null;
            c[1] = null;
        }
    }
    public static int solve(ArrayList<Integer> A) {
        int maxElement = getMax(A);
        int b = maxSetBits(maxElement);
        int n=A.size();
        Node root = new Node();
        for (int i = 0; i < n ; i++) {
            insert(root,A.get(i), b);
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans=Math.max(ans,query(root,A.get(i),b));
        }
        return ans;
    }

    private static int query(Node root, Integer element, int b) {
        int ans=0;
        for (int i = b; i >=0 ; i--) {
            int e = checkBit(element,i);
            if(root.c[1-e] != null){
                ans=ans+(1<<i);
                root=root.c[1-e];
            }else root=root.c[e];
        }
        return ans;
    }

    private static void insert(Node root, Integer element, int b) {
        for (int i = b; i >=0 ; i--) {
            int e = checkBit(element,i);
            if(root.c[e] == null){
                root.c[e] = new Node();
                root=root.c[e];
            }else root=root.c[e];
        }
    }

    private static int checkBit(Integer element, int i) {
        return (element>>i)&1;
    }

    private static int maxSetBits(int maxElement) {
        String ans = Integer.toBinaryString(maxElement);
        return ans.length();
    }

    private static int getMax(ArrayList<Integer> a) {
        int n=a.size(),ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp=a.get(i);
            if(temp>ans) ans=temp;
        }
        return ans;
    }
}


