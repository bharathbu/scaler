/**
 * Maximum XOR Subarray
 *
 * Problem Description
 * Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
 *
 * NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] <= 109
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 * Output Format
 * Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 3]
 * Input 2:
 *
 *  A = [8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  [1, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 6 possible subarrays of A:
 *  subarray            XOR value
 *  [1]                     1
 *  [4]                     4
 *  [3]                     3
 *  [1, 4]                  5 (1^4)
 *  [4, 3]                  7 (4^3)
 *  [1, 4, 3]               6 (1^4^3)
 *
 *  [4, 3] subarray has maximum XOR value. So, return [2, 3].
 * Explanation 2:
 *
 *  There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].
 */
package com.advanced.dsa.trie;

import java.util.ArrayList;

public class MaxXorSubarray {
    static class Node{
        Node[] c = new Node[2];
        int value;
        int end;
        Node(){
            end=-1;
            value=0;
            c[0] = null;
            c[1] = null;
        }
    }

    static class Pair{
        int num;
        int idx;
        public Pair(int n,int i){
            this.num = n;
            this.idx = i;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int start=-1,end=0,n=A.size();
        ArrayList<Integer> result = new ArrayList<>();
        int resXor = Integer.MIN_VALUE,preXor=0;
        Node root = new Node();
        insert(root,0,-1);
        for (int i = 0; i < n; i++) {
            preXor = preXor ^ A.get(i);
            insert(root,preXor,i);
            Pair ans = query(root,preXor);
            if(ans.num > resXor){
                resXor = ans.num;
                end=i;
                start = ans.idx+1;
            }else if(ans.num == resXor){
                int currLen = end-start+1;
                int newLen = i - (ans.idx +1) +1;
                if(newLen < currLen){
                    start = ans.idx+1;
                    end=i;
                }else if(newLen == currLen && (ans.idx+1) < start){
                    start = ans.idx+1;
                    end=i;
                }
            }
        }
        result.add(start+1);
        result.add(end+1);
        return result;
    }

    private static Pair query(Node root, Integer element) {
        int ans=0;
        for (int i = 31; i >=0 ; i--) {
            int e = checkBit(element,i);
            if(root.c[1-e] != null){
                ans=ans+(1<<i);
                root=root.c[1-e];
            }else root=root.c[e];
        }
        return  (new Pair(element ^ (root.value), root.end));
    }

    private static void insert(Node root, Integer element, int idx) {
        for (int i = 31; i >=0 ; i--) {
            int e = checkBit(element,i);
            if(root.c[e] == null){
                root.c[e] = new Node();
                root=root.c[e];
            }else root=root.c[e];
        }
        root.value = element;
        root.end = idx;
    }

    private static int checkBit(Integer element, int i) {
        return (element>>i)&1;
    }
}
