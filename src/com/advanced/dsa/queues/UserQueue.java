package com.advanced.dsa.queues;

import java.util.Stack;

public class UserQueue {

    static Stack<Integer> s1;
    static Stack<Integer> s2;

    /** Initialize your data structure here. */
    UserQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element X to the back of queue. */
    static void push(int X) {
        s1.push(X);
    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if(s2.size()==0){
            while(s1.size()>0)
                s2.push(s1.pop());
        }

        if(s2.size()>0) return s2.pop();
        return -1;
    }

    /** Get the front element of the queue. */
    static int peek() {
        if(s2.size()>0) return s2.peek();
        else{
            while(s1.size()>0)
                s2.push(s1.pop());
            if(s2.size()>0) return s2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        if(s1.size()==0 && s2.size()==0) return true;
        return false;
    }
}
