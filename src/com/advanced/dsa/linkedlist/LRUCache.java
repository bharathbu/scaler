package com.advanced.dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
    Lets approach this question bit by bit.
    If lets say you never had to remove entries from the LRU cache because we had enough space, what would you use to support and get and set ?
    A simple map / hashmap would suffice.

    Alright, lets now look at the second part which is where the eviction comes in. We need a data structure which at any given instance can give me the least recently used objects in order. Lets see if we can maintain a linked list to do it. We try to keep the list ordered by the order in which they are used. So whenever, a get operation happens, we would need to move that object from a certain position in the list to the front of the list. Which means a delete followed by insert at the beginning.

    Insert at the beginning of the list is trivial. How do we achieve erase of the object from a random position in least time possible ?

    How about we maintain another map which stores the pointer to the corresponding linked list node.

    Ok, now when we know the node, we would need to know its previous and next node in the list to enable the deletion of the node from the list. We can get the next in the list from next pointer ? What about the previous node ? To encounter that, we make the list doubly linked list.

    Now, can you think of an approach using doubly linked list and the map(s) ?
     */

    /*
    As discussed in the previous hint, we solve this problem using :

    originalMap : A hashmap which stores the orginial key to value mapping
    accessList : A doubly linked list which has keys ordered by their access time ( Most recently used key in front of the list to least recently used key at the end of the list ).
    addressMap : A hashmap which saves the mapping of key to address of the key in accessList.
    Lets see now how the get and set operation would work :

    get(key) :
    Look for the value corresponding to key in originalMap.
    If key is not found, we don’t need to change accessList. So, return -1.
    If key is found, then we need to move the node corresponding to the key to front of the list in accessList.
    To do that, we find the address of the node for key from addressMap. We make the node->prev->next = node->next;, node->next->prev = node->prev;, node->prev = NULL; node->next = head; head->prev = node;
    We update the head of the accessList to be node now.

    set(key, value)
    If the key is a new entry (it does not exist in the originalMap) AND the cache is full(size = capacity), then we would need to remove the least recently used key lkey.
    We know that this key is the key corresponding to the last node in accessList which is accessible in O(1). To evict, we delete the last node from accessList, and the entry corresponding to lkey(from last node) in addressMap and originalMap.

    Post this, there are 2 cases.

    key is a new entry and is not present in originalMap. In this case, a new node is created for key and inserted at the head of accessList. A new (key,value) entry is created into originalMap and addressMap accordingly.
    key is present in the map, in which case the value needs to be updated. We update the value in the originalMap and then we update the accessList for key exactly the way we did in the case of get operation.
    A couple of insights for clean code :

    Note that the update of accessList for key when key is present is a common operation in get and a subcase of set function. We should create a function for it and call that function in both cases to reduce redundancy.
    Also, note that originalMap and addressMap are always of the same size with the same keys ( One with value and the other with address in linkedlist ). If you want to manage less maps, you can just have a masterMap which maps key to a pair of (value, address_in_list)
     */
    public class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int k, int v){
            key = k;
            value = v;
            next=null;
            prev=null;
        }
    }

    int capacity;
    Map<Integer,Node> cache;

    //Head and tail nodes;
    Node head = null;
    Node tail = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>(this.capacity);
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node currentNode = cache.get(key);
            if(currentNode.next!=null){
                remove(currentNode);
                insertAtBack(currentNode);
            }
            return currentNode.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(cache.containsKey(key)){
            Node updateNode = cache.get(key);
            updateNode.value = value;
            if(updateNode.next!=null){
                remove(updateNode);
                cache.remove(key);
                updateNode = new Node(key,value);
                insertAtBack(updateNode);
                cache.put(key,updateNode);
            }
        }else{
            Node newNode = new Node(key,value);
            if(cache.size() == capacity){
                cache.remove(head.key);
                remove(head);
                cache.put(key,newNode);
                insertAtBack(newNode);
            }else{
                cache.put(key,newNode);
                insertAtBack(newNode);
            }
        }
    }

    public void insertAtBack(Node newNode){
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev = tail;
        tail=newNode;
    }

    public void remove(Node t){
        if(t.next == null && t.prev == null){
            head=null;
            tail=null;
            return;
        }

        if(tail == t){
            tail=t.prev;
            return;
        }
        if(head == t)
            head = head.next;

        Node p = t.prev;
        Node n = t.next;
        n.prev = p;
        if(p!=null)
            p.next = n;

    }

}
