/**
 * Design Linked list
 * 
 * Given a matrix A of size Nx3 representing operations. Your task is to design the linked list based on these operations.

There are four types of operations:

0 x -1: Add a node of value x before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.

1 x -1: Append a node of value x to the last element of the linked list.

2 x index: Add a node of value x before the indexth node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.

3 index -1: Delete the indexth node in the linked list, if the index is valid.

A[i][0] represents the type of operation.

A[i][1], A[i][2] represents the corresponding elements with respect to type of operation.

Note: Indexing is 0 based.


Input Format

The only argument given is matrix A.
Output Format

Return the pointer to the starting of the linked list.
Constraints

1 <= Number of operations <= 1000
1 <= All node values <= 10^9
For Example

Input 1:
    A = [   [0, 1, -1]
            [1, 2, -1]
            [2, 3, 1]   ]
Output 1:
    1->3->2->NULL

Input 2:
    A = [   [0, 1, -1]
            [1, 2, -1]
            [2, 3, 1]
            [0, 4, -1]
            [3, 1, -1]
            [3, 2, -1]
                       ]
Output 2:
    4->3->NULL
 */
package com.week10.LinkedList;

/**
 * @author Bharath
 *
 */
public class DesignLinkedList {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = new int[][]{
			  {2, 18, 0},
			  {2, 5, 1},
			  {2, 8, 0},
			  {1, 7, -1},
			  {1, 5, -1}
			};
		ListNode head = solve(A);
		print_ll(head);

	}
	static int size_of_ll = 0;
	 public static void print_ll(ListNode head) {
	        ListNode temp = head;
	        int flag = 0;
	        while (temp != null) {
	            if (flag == 0) {
	                System.out.print(temp.val);
	                flag = 1;
	            } else
	                System.out.print(" -> " + temp.val);
	            temp = temp.next;
	        }
	    }
	public static ListNode solve(int[][] A) {
		ListNode head = null;
		//int size_of_ll = 0;
		int n = A.length;
		for(int i=0;i<n;i++) {
			if(A[i][0] == 0) 
				head = insert_node(0,A[i][1],head);
			else if(A[i][0] == 1)
				head = insert_node(size_of_ll,A[i][1],head);
			else if(A[i][0] == 2) {
				if(A[i][2] == size_of_ll)
					head = insert_node(size_of_ll,A[i][1],head);
				else if(A[i][2] < size_of_ll && A[i][2] >0)
					head = insert_node(A[i][2], A[i][1],head);
				else if(A[i][2] == 0)
					head = insert_node(0,A[i][1],head);
			}
				
			else if(A[i][0] == 3 && (A[i][1]>=0 && A[i][1]<=size_of_ll))
				head = delete_node(A[i][1],head);
		}
		return head;
    }
	
	public static ListNode insert_node(int position, int value, ListNode head) {
        // @params position, integer
        // @params value, integer
		if (position >= 0 && position <= size_of_ll ) {
	        ListNode temp = new ListNode(value);
	        //temp.data = value;
	        if (position == 0) {
	            temp.next = head;
	            head = temp;
	            size_of_ll++;
	        } else {
	            int count = 0;
	            ListNode prev = head;
	            while (count < position-1) {
	                prev = prev.next;
	                count++;
	            }
	            temp.next = prev.next;
	            prev.next = temp;
	            size_of_ll++;
	        }
		}
		return head;
	}

	
    public static ListNode delete_node(int position, ListNode head) {
    	if (position >= 0 && position < size_of_ll) {
            ListNode temp = null;
            if (position == 0) {
                temp = head;
                head = head.next;
                size_of_ll--;
            } else {
                int count = 0;
                ListNode prev = head;
                while (count < position-1 ) {
                    prev = prev.next;
                    count++;
                }
                temp = prev.next;
                prev.next = temp.next;
                size_of_ll--;
            }
            
        }
    	return head;
    }
}
