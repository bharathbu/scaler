package com.advanced.dsa.linkedlist;

public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode t1 = head;
        while(t1!=null){
            RandomListNode t = new RandomListNode(t1.label);
            t.random = null;
            t.next=t1.next;
            t1.next=t;
            t1=t.next;
        }

        t1=head;
        //RandomListNode t2=t1.next;
        while(t1!=null){
            if(t1.random!=null)
                t1.next.random = t1.random.next;
            t1=t1.next.next;
        }

        t1=head;
        RandomListNode t2=t1.next;
        RandomListNode h2 = t2;
        while(t1!=null){
            t1.next=t2.next;
            t1=t1.next;
            if(t1!=null)
                t2.next=t1.next;
            t2=t2.next;
        }
        return h2;
    }
}
