package DataStructures;

public class LinkedListQueue<E extends Comparable<E>>  {
    /* requires 2 pointers, 1 to head, 1 to tail:
         if you only maintain head pointer,
         enq(): O(n), deq(): O(1)
    */

    LinkedListNode<E> head;
    LinkedListNode<E> tail;


    public void enq(E data) {
        LinkedListNode<E> oldTail = this.tail;
        LinkedListNode<E> newTail = new LinkedListNode<E>(data);

        if (isEmpty()) {
            this.head = newTail;
            this.tail = this.head;
        } else {
            oldTail.setNext(newTail);
        }
    }

    public E deq() {
        E oldHeadData = this.head.getData();
        this.head = this.head.getNext();

        // is the queue now Empty?
        if(isEmpty()) {
            this.tail = null;
        }

        return oldHeadData;
    }


    public boolean isEmpty() {
        return this.head == null;
    }



}
