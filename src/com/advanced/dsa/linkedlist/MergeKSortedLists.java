/**
 * Merge K Sorted Lists
 *
 * Problem Description
 * Given a list containing head pointers of N sorted linked lists.
 * Merge these given sorted linked lists and return them as one sorted list.
 *
 *
 *
 * Problem Constraints
 * 1 <= total number of elements in given linked lists <= 100000
 *
 *
 *
 * Input Format
 * The first and only argument is a list containing N head pointers.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the sorted linked list after merging all the given linked lists.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  1 -> 10 -> 20
 *  4 -> 11 -> 13
 *  3 -> 8 -> 9
 * Input 2:
 *
 *  10 -> 12
 *  13
 *  5 -> 6
 *
 *
 * Example Output
 * Output 1:
 *
 *  1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * Output 2:
 *
 *  5 -> 6 -> 10 -> 12 ->13
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
 * Explanation 2:
 *
 *  The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
 */
package com.advanced.dsa.linkedlist;

import java.util.ArrayList;

public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int size = a.size();
        //ListNode head =
        if(size<=1)
            return a.get(0);
        return mergeSort(a,0,size-1);
    }

    private ListNode mergeSort(ArrayList<ListNode> a, int l, int r) {
        if(l == r) return a.get(r);
        int mid = l+(r-l)/2;
        ListNode left = mergeSort(a,l,mid);
        ListNode right = mergeSort(a,mid+1,r);
        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode h1=A;
        ListNode h2=B;
        if(h1==null) return h2;
        if(h2==null) return h1;

        ListNode l = new ListNode(0);
        ListNode h3=l;

        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                l.next = h1;
                h1=h1.next;
            }else{
                l.next=h2;
                h2=h2.next;
            }
            l=l.next;
        }
        if(h1==null)
            l.next=h2;
        if(h2==null)
            l.next=h1;
        return h3.next;
    }
}
