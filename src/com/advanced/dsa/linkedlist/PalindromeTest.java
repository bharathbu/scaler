/**
 * Palindrome List
 *
 * Problem Description
 * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the given linked list.
 *
 *
 *
 * Output Format
 * Return 0, if the linked list is not a palindrome.
 *
 * Return 1, if the linked list is a palindrome.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 2, 1]
 * Input 2:
 *
 * A = [1, 3, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
 * Explanation 2:
 *
 *  The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 */
package com.advanced.dsa.linkedlist;

import java.util.Stack;

public class PalindromeTest {

    public static void main(String[] args){
        ListNode A = new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(1);
        System.out.println(lPalin(A));
    }
    public static int lPalin(ListNode A) {
        ListNode f = A;
        ListNode s = A;
        ListNode head = A;
        if(A.next==null)
            return 1;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        f=s;
        ListNode h2 = reverseList(s.next);

        while(head!=null && h2!=null){
            if(head.val != h2.val)
                return 0;
            else{
                head=head.next;
                h2=h2.next;
            }
        }
        return 1;
    }

    public static ListNode reverseList(ListNode A) {
        ListNode t=A,h1 = A,h2=null;
        while(h1 != null){
            t = h1;
            h1 = h1.next;
            t.next = h2;
            h2 = t;
        }
        return h2;
    }
}
