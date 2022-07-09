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
 * Input Format
 * The first and only argument is a list containing N head pointers.
 *
 * Output Format
 * Return a pointer to the head of the sorted linked list after merging all the given linked lists.
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
 * Example Output
 * Output 1:
 *
 *  1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * Output 2:
 *
 *  5 -> 6 -> 10 -> 12 ->13
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
 * Explanation 2:
 *
 *  The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
 */
package com.advanced.dsa.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }
    class Pair{
        int val;
        int row;
        Pair(int v, int r){
            val = v;
            row = r;
        }
    }
/*
There are two approaches to solving the problem.

Approach 1: Using heap.
You need the minimum of the head of all the K linked lists at every instant.
Once you know the minimum, you can push the node to your answer list and move it over to the next node in that linked list.

Approach 2: Divide and conquer.
Solve the problem for the first k/2 and last k/2 list. Then you have two sorted lists. Then merge the lists.
Analyze the time complexity.

T(N) = 2 T(N/2) + N
T(N) = O (N log N)
 */
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = new ListNode(-1); // dummy node
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing((Pair p) -> p.val));
        int n=a.size();
        for (int i = 0; i < n; i++) {
            int ele = a.get(i).val;
            Pair p = new Pair(ele,i);
            minHeap.offer(p);
        }
        ListNode curr = head;
        while(!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            int val = p.val, row = p.row;
            curr.next = new ListNode(val);
            curr = curr.next;
            ListNode nextVal = a.get(row);
            while(nextVal!=null && nextVal.val!=val)
                nextVal=nextVal.next;
            if(nextVal!=null && nextVal.val == val && nextVal.next!=null){
                int ele = nextVal.next.val;
                Pair next = new Pair(ele,row);
                minHeap.offer(next);
            }
        }
        return head.next;
    }
}
