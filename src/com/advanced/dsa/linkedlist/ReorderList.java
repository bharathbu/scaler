package com.advanced.dsa.linkedlist;

public class ReorderList {

    /*
    Note that moving in the reverse order in the list is not feasible unless you use additional memory. This indicates that we need to reverse some parts of the list.
    Can you figure out a solution reversing a part of the list?

     We can try to break down the solution approach into majorly three parts.

    Firstly, we try to break the list from the middle into two separate linked lists.
    Now, we reverse the latter half of the linked list.
    Finally, we would merge the lists so that the nodes alternate to get the required answer.
     */
    public ListNode reorderList(ListNode A) {
        ListNode h1= A;
        ListNode t1 = getMiddleNode(A);
        ListNode h2 = t1.next;
        t1.next=null;

        h2 = reverseList(h2);

        ListNode h3 = h1, l=h1;
        h1=h1.next;
        int flag=2;
        while(h2!=null){
            if(flag == 1){
                l.next = h1;
                h1=h1.next;
                flag=2;
            }else{
                l.next=h2;
                h2=h2.next;
                flag=1;
            }
            l=l.next;
        }
        if(h1!=null)
            l.next = h1;
        return h3;
    }

    private ListNode getMiddleNode(ListNode A) {
        if (A.next == null)
            return A;
        ListNode slow = A, fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode A) {
        ListNode t=A,h1 = A,h2=null;
        while(h1 != null){
            t=h1;
            h1=h1.next;
            t.next=h2;
            h2=t;
        }
        return h2;
    }
}
