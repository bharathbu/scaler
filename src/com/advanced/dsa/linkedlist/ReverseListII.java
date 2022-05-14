/**
 * Reverse Link List II
 *
 * Problem Description
 * Reverse a linked list A from position B to C.
 *
 * NOTE: Do it in-place and in one-pass.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 *
 * 1 <= B <= C <= |A|
 *
 *
 *
 * Input Format
 * The first argument contains a pointer to the head of the given linked list, A.
 *
 * The second arugment contains an integer, B.
 *
 * The third argument contains an integer C.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the modified linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1 -> 2 -> 3 -> 4 -> 5
 *  B = 2
 *  C = 4
 *
 * Input 2:
 *
 *  A = 1 -> 2 -> 3 -> 4 -> 5
 *  B = 1
 *  C = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1 -> 4 -> 3 -> 2 -> 5
 * Output 2:
 *
 *  5 -> 4 -> 3 -> 2 -> 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
 *  Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
 * Explanation 2:
 *
 *  In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
 *  Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
 */
package com.advanced.dsa.linkedlist;

public class ReverseListII {

    public static void main(String[] args){
        /*
        If you are still stuck at reversing the full linked list problem,
        then would maintaining curNode, nextNode and a tmpNode help?

        Maybe at every step, you do something like this :

            tmp = nextNode->next;
                    nextNode->next = cur;
                    cur = nextNode;
                    nextNode = tmp;
        Now, let’s say you did solve the problem of reversing the linked list and are stuck at applying it to the current problem.
        What if your function reverses the linked list and returns the endNode of the list.
        You can simply do
        prevNodeOfFirstNode->next = everseLinkedList(curNode, n - m + 1);

        Explanation in the video:
        We can also find the two pointers between which the list needs to be reversed and only reverse that portion.
        We will also have to make two new connections, one from the node just before the first node in the original portion to the node at the starting of the reversed portion, another from the first node of the original portion to the node after the last node in the original portion.
        A detailed explanation is in the video.


        public ListNode reverseBetween(ListNode A, int m, int n) {
        int i;
        ListNode node = A;
        ListNode prev = null;
        m--;
        n--;
        for (i = 0; i < m; i++) {
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = reverseList(node, n - m + 1);
        else
            A = reverseList(node, n - m + 1);
        return A;
    }

    public ListNode reverseList(ListNode A, int count) {
        ListNode node, prev, temp, last;
        node = A;
        last = A;
        if (node == null)
            return null;
        prev = null;
        while (node != null && count > 0) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            count--;
        }
        last.next = node;
        return prev;
    }


         */
        ListNode A = new ListNode(1);
        A.next=new ListNode(2);
        A.next.next=new ListNode(4);
        A.next.next.next=new ListNode(6);
        A.next.next.next.next=new ListNode(5);
        A.next.next.next.next.next=new ListNode(9);
        ListNode rev = reverseBetween(A,1,6);
    }
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        int n = size(A);
        if(n==1)
            return A;
        ListNode h1,h3,t=A,next=A,prev=A;
        ListNode h2=null;
        h1=A;
        for (int i = 1; i < B ; i++) {
            prev=h1;
            h1=h1.next;
        }

        h2=A;
        for (int i = 1; i < C ; i++)
            h2=h2.next;

        next=h2.next;

        int k = (C-B+1);
        while( k>0 ){
            t=h1;
            h1=h1.next;
            t.next=next;
            next=t;
            k--;
        }
        if(B==1)
            A=h2;
        else
            prev.next=h2;
        return A;
    }

    public static int size(ListNode A){
        int count=0;
        ListNode temp = A;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}
