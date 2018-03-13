package DataStructures;

import java.util.Iterator;
import java.util.ListIterator;

public class ResizingArrayStack<E> {
    private int nElementsOnStack = 0;
    private E[] myStack;

    // initialize empty Stack
    public ResizingArrayStack<E>() {
        this.myStack = (E[]) new Object[2];
        this.nElementsOnStack = 0;
    }

    public ResizingArrayStack(int capacity) {
        this.myStack = (E[]) new Object[capacity];
    }

    // invariants of this stack due to resizing: never overflows, and never < 1/4 full
    private void resize(int capacity) {
        E[] copy = (E[]) new Object[capacity];
        for (int i = 0; i < myStack.length; i++) {
            copy[i] = myStack[i];
        }
        this.myStack = copy;
    }

    // Resize with push or pop: O(size) = O(n)

    public E pop() {
        E data = myStack[--nElementsOnStack];
        myStack[nElementsOnStack] = null; // avert loitering
        nElementsOnStack--;
        // only resize when array is 1/4 full, to prevent thrashing if client does
        //    push-pop-push-pop... when array is half full
        if (nElementsOnStack > 0 && nElementsOnStack == myStack.length / 4) {
            resize(myStack.length / 2);
        }
        return data;
    }

    public void push(E item) {
        if (this.nElementsOnStack >= myStack.length) {
            resize(2 * myStack.length);
        }
        myStack[nElementsOnStack++] = item;
    }

    public boolean isEmpty() {
        return this.nElementsOnStack == 0;
    }

    public int size() {
        return this.nElementsOnStack;
    }

}
