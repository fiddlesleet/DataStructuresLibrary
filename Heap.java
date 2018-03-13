package DataStructures;

import java.lang.reflect.Array;

public abstract class Heap<E extends Comparable> {
    private static int MAX_SIZE = 40;
    private E[] array;
    private int nEltsInHeap = 0;

    public Heap(Class<E> c) {
        this(c, MAX_SIZE);
    }

    public Heap(Class<E> c, int size) {
        array = (E[]) Array.newInstance(c, size);
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= nEltsInHeap) {
            return -1;
        }

        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= nEltsInHeap) {
            return -1;
        }

        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > nEltsInHeap) {
            return -1;
        }

        return (index - 1) / 2;
    }

    protected void swap(int i0, int i1) {
        E temp = array[i0];
        array[i0] = array[i1];
        array[i1] = temp;
    }

    public int getnEltsInHeap() {
        return nEltsInHeap;
    }

    protected void incEltsInHeap() {
        this.nEltsInHeap++;
    }

    protected void decEltsInHeap() {
        this.nEltsInHeap--;
    }

    protected E getHighestPriority() {
        if (isEmpty()) {
            throw new HeapEmptyException();
        }
        return this.array[0];
    }

    public int getArrayLength() {
        return array.length;
    }

    public boolean isEmpty() {
        return nEltsInHeap == 0;
    }

    public boolean isFull() {
        return nEltsInHeap == array.length;
    }

    public E getEltAtIndex(int index) {
        return array[i];
    }

    public void setEltInHeap(int index, E data) {
        array[index] = data;
    }

    protected void siftDown(int index) {

    }

    protected void siftUp(int index) {

    }

    public void insert(E value) throws HeapFullException {
    }



}
