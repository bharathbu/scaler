/**
 * List Cycle
 *
 * Problem Description
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Try solving it using constant additional space.
 *
 * Example:
 *
 * Input:
 *
 *                   ______
 *                  |     |
 *                  \/    |
 *         1 -> 2 -> 3 -> 4
 *
 * Return the node corresponding to node 3.
 */
package com.advanced.dsa.linkedlist;

public class ListCycle {

    public static void main(String[] args){
        /*
        Lets first look at detection of a cycle in the list.

        Following are different ways of doing this

        1) Use Hashing:
        What if you could maintain a list of nodes already visited. As soon as you visit a node already visited, you know that there is a cycle.

        2) 2 pointer approach ( Floyd’s Cycle-Finding Algorithm ) :
        What if you have 2 pointers which are going at different speed. For arguments sake, lets just say one pointer is going at double the speed of the other.
        Would they meet if there is a cycle ? Are they guaranteed to meet if there is a cycle ?
        What happens if there is no cycle ?

        Once you detect a cycle, think about finding the starting point.
        ------------------------------------------------

        Lets now look at the starting point.
        If we were using hashing, the first repetition we get is the starting point. Simple!

        What happens with the 2 pointer approach ?

        Method 1 :
        If you detect a cycle, the meeting point is definitely a point within the cycle.

        Can you determine the size of the cycle ? ( Easy ) Let the size be k.
        Fix one pointer on the head, and another pointer to kth node from head.
        Now move them simulataneously one step at a time. They will meet at the starting point of the cycle.
        Method 2 :
        This might be slightly more complicated. It involves a bit of maths and is not as intuitive as method 1.
        Suppose the first meet at step k,the distance between the start node of list and the start node of cycle is s, and the distance between the start node of cycle and the first meeting node is m.
        Then
        2k = (s + m + n1r)
        2(s + m + n2r) = (s + m + n1r)
        s + m = nr where n is an integer.
        s = nr - m
        s = (r - m) + (n-1)r

        So, if we have one pointer on the head and another pointer at the meeting point. Note that since the distance between start node of cycle and the first meeting node is m,
        therefore if the pointer moves (r - m) steps, it will reach the start of the cycle. When the pointer at the head moves s steps,
        the second pointer moves (r-m) + (n-1)r steps which both points to the start of the cycle. In other words, both pointers meet first at the start of the cycle.
         */
        ListNode A = new ListNode(1);
        A.next=A;
        System.out.println(detectCycle(A));
    }
    public static ListNode detectCycle(ListNode a) {
        ListNode s = a;
        ListNode f = a;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){
                while(a!=s){
                    a=a.next;
                    s=s.next;
                }
                return s;
            }
        }
        return null;
    }

}
