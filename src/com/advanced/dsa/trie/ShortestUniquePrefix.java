/**
 * Shortest Unique Prefix
 *
 * Problem Description
 * Given a list of N words, find the shortest unique prefix to represent each word in the list.
 *
 * NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
 *
 *
 *
 * Problem Constraints
 * 1 <= Sum of length of all words <= 106
 *
 *
 *
 * Input Format
 * First and only argument is a string array of size N.
 *
 *
 *
 * Output Format
 * Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = ["zebra", "dog", "duck", "dove"]
 * Input 2:
 *
 * A = ["apple", "ball", "cat"]
 *
 *
 * Example Output
 * Output 1:
 *
 *  ["z", "dog", "du", "dov"]
 * Output 2:
 *
 *  ["a", "b", "c"]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Shortest unique prefix of each word is:
 *  For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 *  For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 *  For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 *  For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".
 *
 * Explanation 2:
 *
 *  "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 */
package com.advanced.dsa.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {
    public String[] prefix(String[] A) {
        String [] prefixArray = new String[A.length];
        Node root = new Node('0',1);
        for(int i=0;i<A.length;i++)
            insert(root,A[i]);
        //search prefix
        for(int i=0;i<A.length;i++)
            prefixArray[i] = searchPrefix(root,A[i]);
        return prefixArray;
    }


    public void insert(Node root, String word)
    {
        Node curr = root;
        int l = word.length();
        for(int i=0;i<l;i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null)
                curr.children[index] = new Node(word.charAt(i),1);
            else
                curr.children[index].count++;
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public String searchPrefix(Node root, String word)
    {
        Node curr = root;
        int l = word.length();
        String prefix = "";
        for(int i=0;i<l;i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null)
                return prefix;
            else if(curr.children[index].count == 1) {
                prefix = prefix+word.charAt(i);
                return prefix;
            }
            prefix = prefix+word.charAt(i);
            curr = curr.children[index];
        }
        return prefix;
    }
    private class Node
    {
        char data;
        int count;
        Node[] children;
        boolean isEnd;

        Node(char data, int count)
        {
            this.data = data;
            this.count= count;
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
}



