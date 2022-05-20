/**
 * Sort List
 *
 * Problem Description
 * Sort a linked list, A in O(n log n) time using constant space complexity.
 *
 *
 *
 * Problem Constraints
 * 0 <= |A| = 105
 *
 *
 *
 * Input Format
 * The first and the only arugment of input contains a pointer to the head of the linked list, A.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the sorted linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [3, 4, 2, 8]
 * Input 2:
 *
 * A = [1]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 3, 4, 8]
 * Output 2:
 *
 * [1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
 * Explanation 2:
 *
 *  The sorted form of [1] is [1].
 */
package com.advanced.dsa.linkedlist;

public class SortList {

    /*
    Merge sort is usually quicker and easier to implement when it comes to implementing sorting in O(nlogn).
    Think recursively. You will end up breaking the problems into small pieces.

    We can try to implement either merge sort or qsort.
    Let us look at the merge sort. We start traversing the singly linked list to find the midpoint of the singly linked list.
    Now, we will sort the first half and second half separately by calling the merge sort function on them.
    Then we only have to merge the 2 lists ( Note that we already have solved a problem to merge 2 lists ).
     */
    public static ListNode sortList(ListNode A) {
        if(A==null || A.next==null)
            return A;

        ListNode mid = getMiddleNode(A);
        ListNode right = mid.next;
        mid.next=null;
        ListNode left = sortList(A);
        right=sortList(right);

        return merge(left,right);
    }

    private static ListNode merge(ListNode A, ListNode B) {
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

    private static ListNode getMiddleNode(ListNode A) {
        if (A.next == null)
            return A;
        ListNode slow = A, fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
