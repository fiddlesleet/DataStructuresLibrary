package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<E> implements Iterable<E>{
    private E[] myQ;
    private int nEltsOnQ = 0;
    private int firstIndex = 0;
    private int lastIndex = 0;

    public ResizingArrayQueue() {
        this.myQ = (E[]) new Object[2];;
    }

    public ResizingArrayQueue(int capacity){
        this.myQ = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return nEltsOnQ == 0;
    }

    public int size() {
        return this.nEltsOnQ;
    }

    private void resize(int capacity) {
        E[] copy = (E[]) new Object[capacity];

        for (int i = 0; i < nEltsOnQ; i++) {
            copy[i] = myQ[(firstIndex + i) % myQ.length];
        }

        myQ = copy;
        firstIndex = 0;
        lastIndex = nEltsOnQ;
    }

    public void enq(E data) {
        // double size if queue is full
        if (nEltsOnQ == myQ.length) {
            resize(2 * myQ.length);
        }
        myQ[nEltsOnQ++] = data;
        lastIndex++;
    }

    public E deq() {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements" +
                    "on queue to dequeue");
        }

        E first = myQ[firstIndex];

        // remove the element
        myQ[firstIndex] = null; // avert loitering
        nEltsOnQ--;
        firstIndex++;

        // wraparound
        if (firstIndex == myQ.length) {
            firstIndex = 0;
        }

        // shrink storage size if necessary
        if (nEltsOnQ > 0 && nEltsOnQ == myQ.length / 4) {
            resize(myQ.length / 2);
        }

        return first;
    }

    public E peek() {
        return myQ[firstIndex];
    }

    // Iterator that returns items in FIFO order
    public Iterator<E> iterator() {
        return new ArrayQIterator();
    }

    private class ArrayQIterator implements Iterator<E> {
        private int i = 0;

        public boolean hasNext() {
            return i < nEltsOnQ;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E data = myQ[(i + firstIndex) % myQ.length];
            i++;
            return data;
        }

    }
}
