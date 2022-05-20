/**
 * Merge Two Sorted Lists
 *
 * Problem Description
 * Merge two sorted linked lists, A and B, and return it as a new list.
 *
 * The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
 *
 *
 *
 * Problem Constraints
 * 0 <= |A|, |B| <= 105
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 *
 * The second argument of input contains a pointer to the head of linked list B.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the merged linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5 -> 8 -> 20
 *  B = 4 -> 11 -> 15
 * Input 2:
 *
 *  A = 1 -> 2 -> 3
 *  B = Null
 *
 *
 * Example Output
 * Output 1:
 *
 *  4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Output 2:
 *
 *  1 -> 2 -> 3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Explanation 2:
 *
 *  We don't need to merge as B is empty.
 */
package com.advanced.dsa.linkedlist;

public class MergeSortedLists {

    /*
    Maintain pointers in both the linked list and keep appending the elements to the list to be returned.
    NOTE: You don’t have to create new nodes here, i.e., the list to be returned should be made from the combination of both of the given lists.

    The first thing to note is that all you would want to do is modify the next pointers. You don’t need to create new nodes.
    At every step, you choose the minimum of the current head X on the 2 lists and modify your answer’s next pointer to X. You move the current pointer on the said list and the current answer.
    Corner case,
    Make sure that at the end of the loop, when one of the lists goes empty, you do include the remaining elements from the second list into your answer.
    Test case : 1->2->3 4->5->6
     */
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        //ListNode h3=null;
        //ListNode l = null;
        ListNode h1=A;
        ListNode h2=B;
        if(h1==null) return h2;
        if(h2==null) return h1;

        /*if(h1.val < h2.val){
            h3=h1;
            l=h1;
            h1=h1.next;
        }else{
            h3=h2;
            l=h2;
            h2=h2.next;
        }*/
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
