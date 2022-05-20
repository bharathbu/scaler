/**
 * Remove Loop from Linked List
 *
 * Problem Description
 * You are given a linked list that contains a loop.
 * You need to find the node, which creates a loop and break it by making the node point to NULL.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 1000
 *
 *
 *
 * Input Format
 * Only argument is the head of the linked list.
 *
 *
 *
 * Output Format
 * return the head of the updated linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 * 1 -> 2
 * ^    |
 * | - -
 * Input 2:
 *
 * 3 -> 2 -> 4 -> 5 -> 6
 *           ^         |
 *           |         |
 *           - - - - - -
 *
 *
 * Example Output
 * Output 1:
 *
 *  1 -> 2 -> NULL
 * Output 2:
 *
 *  3 -> 2 -> 4 -> 5 -> 6 -> NULL
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Chain of 1->2 is broken.
 * Explanation 2:
 *
 *  Chain of 4->6 is broken.
 */
package com.advanced.dsa.linkedlist;

public class RemoveLoop {

    /*
    You just need to find what the point is, which has 2 pointers pointing towards it.
    Once you have found it, remove one of the pointers and return the head of the new linked list.
     */
    public ListNode solve(ListNode A) {
        ListNode s = A;
        ListNode f = A;
        boolean loop = false;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){
                loop=true;
                break;
            }
        }

        if(!loop){
            return A;
        }
        f = A;
        while(f.next!=s.next){
            f=f.next;
            s=s.next;
        }
        s.next=null;
        return A;
    }
}
