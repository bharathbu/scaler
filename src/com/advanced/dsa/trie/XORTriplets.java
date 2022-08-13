/**
 *  XOR TRIPLETS
 *
 * Problem Description
 *
 * Given an array of integers A of size N.
 *
 * A triplet (i, j, k), i <= j <= k is called a power triplet if A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k].
 *
 * Where, ^ denotes bitwise xor.
 *
 * Return the count of all possible power triplets. Since the answer could be large return answer % 109 +7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100000
 * 1 <= A[i] <= 100000
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 *
 *
 *
 * Output Format
 *
 * Return the count of all possible power triplets % 109 + 7.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [5, 2, 7]
 * Input 2:
 *
 *  A = [1, 2, 3]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  All possible power triplets are:
 *     1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
 *     2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]
 * Explanation 2:
 *
 *  All possible power triplets are:
 *     1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
 *     2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]
 */
package com.advanced.dsa.trie;

/*
Can we say that to calculate answer we need to find the subarrays such that Xor of that subarray is Zero.

A simple is to find the every possible triplet and check if it satisfies the above condition.
But this is not an efficient way to do that.

One thing we observe is that for (i,j,k), A[i]^A[i+1]..^A[j-1] = A[j]^A[j+1]^A[k] i.e A[i]^A[i+1]..^A[k] = 0.
So, if we find (i,k) such that A[i]^A[i+1]..^A[k] = 0, then all j in this range will satisfy our above condition.

An efficient solution is to use Trie.

->We will take the cumulative xor of the elements in the array and check that this xor value exists in the Trie or not.

->If the xor already exists in the Trie then we have encounted a subarray having 0 xor and count all the triplets.

->Else push the value of xor into the Trie.

 */
public class XORTriplets {
    static final int INT_SIZE = 20;
    static class TrieNode {
        int soi;
        int noi;
        TrieNode[] arr = new TrieNode[2];
        public TrieNode() {
            soi = 0;
            noi = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }
    static TrieNode root;
    static void insert(int pre_xor, int index) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();

            temp = temp.arr[val];
        }
        temp.noi++;
        temp.soi += index;
    }
    static long query(int pre_xor, int index) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.arr[val] == null)
                return 0;
            temp = temp.arr[val];
        }
        int sz = temp.noi;
        int sum = temp.soi;
        long ans = (long)((long) sz * (long) index) - (long)((long) sum);
        return ans;
    }
    public int solve(int[] A) {
        int curr_xor = 0;
        long mod = 1000000007;
        long number_of_triplets = 0;
        int n = A.length;
        root = new TrieNode();
        for (int i = 0; i < n; i++) {
            int x = A[i];
            insert(curr_xor, i);
            curr_xor ^= x;
            number_of_triplets += query(curr_xor, i);
            number_of_triplets %= mod;
        }
        long res = number_of_triplets % mod;
        return (int) res;
    }
}
