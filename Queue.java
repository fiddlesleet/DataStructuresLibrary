package DataStructures;

import java.lang.reflect.Array;

public class Queue<E> {

    // flag for when no elements in Queue
    private static final int QUEUE_IS_EMPTY = -1;
    private static int MAX_SIZE = 40;
    private E[] elements;

    // head and tail intialized to EMPTY_QUEUE values indicating they're empty
    private int headIndex = QUEUE_IS_EMPTY;
    private int tailIndex = QUEUE_IS_EMPTY;

    public Queue(Class<E> className) {
        // initialize generic array
        this.elements = (E[]) Array.newInstance(class, MAX_SIZE);

    }

    public void enqueue(E data) throws QueueOverflowException {
        // if queue is full, fail
        if (isFull()) {
            throw new QueueOverflowException();
        }

        // get tailIndex and insert the new element there
        // Wraparound if at end of circular array
        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        // if this is the first element enqueued, set the head index to the tail index
        if (headIndex == Queue_IS_EMPTY) {
            headIndex = tailIndex;
        }

    }

    public E dequeue() {

    }

    public boolean isFull() {
        return this.elements.length == MAX_SIZE;
    }
}
