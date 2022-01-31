/**
 * Linked-List
 * 
 * Problem Description

Design and implement a Linked List data structure. A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space.
Note:

If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in new line.


Problem Constraints

1 <= position <= n where, n is the size of the linked-list.



Input Format

First line contains an integer denoting number of cases, let's say t.
Next t line denotes the cases.


Output Format

When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
NOTE: You don't need to return anything.


Example Input

5
i 1 23
i 2 24
p
d 1
p


Example Output

23 24
24


Example Explanation

After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.
 */
package com.week10.LinkedList;

/**
 * @author Bharath
 *
 */
public class LinkedListOps {

	public static Node head = null;
	public static int size_of_ll = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insert_node(1,226);
		insert_node(2 ,875);
		insert_node(3, 604);
		insert_node(4, 550);
		insert_node(5 ,498);
		insert_node(6, 875);
		insert_node(7 ,847);
		insert_node(8 ,633);
		insert_node(9 ,793);
		insert_node(10,872);
		insert_node(11,313);
		insert_node(12,440);
		insert_node(13,331);
		insert_node(14,582);
		insert_node(15,188);
		insert_node(16,476);
		insert_node(17,722);
		insert_node(18,402);
		insert_node(19,890);
		insert_node(20,713);
		insert_node(21,421);
		insert_node(22,930);
		insert_node(23,579);
		insert_node(24,459);
		insert_node(25,278);
		insert_node(26,818);
		insert_node(27,320);
		insert_node(28,549);
		insert_node(29,240);
		insert_node(30,528);
		insert_node(31,367);
		insert_node(32,835);
		insert_node(33,20 );
		insert_node(34,170);
		insert_node(35,903);
		insert_node(36,242);
		insert_node(37,943);
		insert_node(38,802);
		insert_node(39,145);
		insert_node(40,291);
		insert_node(41,224);
		insert_node(42,400);
		insert_node(43,43 );
		insert_node(44,355);
		insert_node(45,83 );
		insert_node(46,26 );
		insert_node(47,816);
		insert_node(48,477);
		insert_node(49,425);
		insert_node(50,543);
		insert_node(51,211);
		insert_node(52,799);
		insert_node(53,185);
		insert_node(54,5  );
		insert_node(55,184);
		insert_node(56,150);
		insert_node(57,572);
		insert_node(58,626);
		insert_node(59,109);
		insert_node(60,807);
		delete_node(25);
		print_ll();
		delete_node(53);
		print_ll();
		delete_node(12);
		delete_node(54);
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		delete_node(39);
		delete_node(42);
		print_ll();
		delete_node(47);
		delete_node(45);
		delete_node(35);
		print_ll();
		delete_node(13);
		print_ll();
		delete_node(18);
		delete_node(59);
		delete_node(47);
		delete_node(43);
		delete_node(38);
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		print_ll();
		delete_node(8);
		print_ll();
		delete_node(8);
		print_ll();
		delete_node(39);
		delete_node(60);
		delete_node(16);
		print_ll();
		print_ll();
	}

	public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
		if (position >= 1 && position <= size_of_ll + 1) {
	        Node temp = new Node(value);
	        //temp.data = value;
	        if (position == 1) {
	            temp.next = head;
	            head = temp;
	        } else {
	            int count = 1;
	            Node prev = head;
	            while (count < position - 1) {
	                prev = prev.next;
	                count++;
	            }
	            temp.next = prev.next;
	            prev.next = temp;

	        }
	        size_of_ll++;
		}
	}

	
    public static void delete_node(int position) {
    	if (position >= 1 && position <= size_of_ll) {
            Node temp = null;
            if (position == 1) {
                temp = head;
                head = head.next;
            } else {
                int count = 1;
                Node prev = head;
                while (count < position - 1) {
                    prev = prev.next;
                    count++;
                }
                temp = prev.next;
                prev.next = prev.next.next;
            }
            size_of_ll--;
        }
    	
    }

    public static void print_ll() {
        // Output each element followed by a space	
    	/*if(head == null) return;
    	else {
    		Node temp = head;
    		while(temp.next!=null) {
        		System.out.print(temp.data+" ");
        		temp=temp.next;
        	}
        	System.out.print(temp.data);
        	System.out.println();
    	}*/	
    	Node temp = head;
        int flag = 0;
        while (temp != null) {
            if (flag == 0) {
                System.out.print(temp.data);
                flag = 1;
            } else
                System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }
}
