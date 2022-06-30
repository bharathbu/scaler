/**
 * Spelling Checker
 *
 * Problem Description
 * Given an array of words A (dictionary) and another array B (which contain some words).
 *
 * You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
 *
 * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 *
 * Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
 *
 * NOTE: Try to do this in O(n) time complexity.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 * 1 <= sum of all strings in A <= 50000
 *
 * 1 <= |B| <= 1000
 *
 *
 *
 * Input Format
 * First argument is array of strings A.
 *
 * First argument is array of strings B.
 *
 *
 *
 * Output Format
 * Return the binary array of integers according to the given format.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [ "hat", "cat", "rat" ]
 * B = [ "cat", "ball" ]
 * Input 2:
 *
 * A = [ "tape", "bcci" ]
 * B = [ "table", "cci" ]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 0]
 * Output 2:
 *
 * [0, 0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only "cat" is present in the dictionary.
 * Explanation 2:
 *
 * None of the words are present in the dictionary.
 */
package com.advanced.dsa.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpellinChecker {
    private class Node{
        boolean isEnd;
        Map<Character, Node> hm;
        public Node(){
            isEnd = false;
        }
    }
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        Node root = new Node();
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size(), q = B.size();
        for (int i = 0; i < n; i++) {
            addWord(A.get(i),root);
        }

        for (int i = 0; i < q; i++) {
            if(searchWord(B.get(i),root))
                result.add(1);
            else result.add(0);
        }
        return result;
    }

    private boolean searchWord(String s, Node root) {
        int n=s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!root.hm.containsKey(ch))
                return false;
            else root=root.hm.get(ch);
        }
        return root.isEnd;
    }

    private void addWord(String s, Node root) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(root.hm == null)
                root.hm = new HashMap<>();
            if(!root.hm.containsKey(ch)){
                Node t = new Node();
                root.hm.put(ch,t);
                root = t;
            }else root = root.hm.get(ch);
        }
        root.isEnd=true;
    }
}
