/**
 * Contact Finder
 *
 * Problem Description
 *
 * We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:
 *
 * Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.
 *
 * Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].
 *
 * You have been given sequential add and find operations. You need to perform each operation in order.
 *
 * And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 10000
 *
 * 1 <= |length of strings in B| <= 10
 *
 *
 *
 * Input Format
 *
 * First argument is the vector A, which denotes the type of query.
 *
 * Second argument is the vector B, which denotes the string for corresponding query.
 *
 *
 *
 * Output Format
 *
 * Return an array of integers, denoting answers for each query of type 1.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [0, 0, 1, 1]
 * B = ["hack", "hacker", "hac", "hak"]
 * Input 2:
 *
 * A = [0, 1]
 * B = ["abcde", "abc"]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *
 * [2, 0]
 * Output 2:
 *
 * [1]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 * We perform the following sequence of operations:
 * Add a contact named "hack".
 * Add a contact named "hacker".
 * Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
 * Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.
 * Explanation 2:
 *
 *
 * Add "abcde"
 * Find words with prefix "abc". We have answer as 1.
 */
package com.advanced.dsa.trie;

import java.util.ArrayList;
/*
Handling operations:

Add : We will simply insert the string in the trie.
We will increase the value of the variable of the nodes that are visited in the process by .

Find : We need to find the number of strings which have been inserted into the trie and have as a prefix.
We will start from the root of the trie and traverse it using the string .
The value of the variable stored in the final node ( the node where the traversal ends) is the answer to this operation.
This is because all the strings that have as prefix must have visited this node and no other string can visit this node.
 */
public class ContactFinder {
    private class Node{
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
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        Node root = new Node('0',1);
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size(), q = B.size();
        for (int i = 0; i < n; i++) {
            if(A.get(i) == 0)
                addWord(B.get(i),root);
        }

        for (int i = 0; i < n; i++) {
            if(A.get(i) == 1)
                result.add(searchWord(B.get(i),root));
        }
        return result;
    }

    private int searchWord(String word, Node root) {
        int n=word.length();
        Node curr = root;
        int l = word.length(),index = 0,i=0;
        String prefix = "";
        for(i=0;i<l-1;i++){
            index = word.charAt(i)-'a';
            if(curr.children[index] == null)
                return 0;
            else
                curr = curr.children[index];
        }
        index = word.charAt(i)-'a';
        if(curr.children[index] == null)
            return 0;
        return curr.children[index].count;
    }

    private void addWord(String word, Node root) {
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
}
