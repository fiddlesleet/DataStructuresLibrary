package DataStructures;

public class MaxHeap<E extends Comparable> extends Heap<E> {

    public MaxHeap(Class<E> c) {
        super(c);
    }

    public MaxHeap(Class<E> c, int size) {
        super(c, size);
    }

    @Override
    public int getLeftChildIndex(int index) {
        return super.getLeftChildIndex(index);
    }

    @Override
    public int getRightChildIndex(int index) {
        return super.getRightChildIndex(index);
    }

    @Override
    public int getParentIndex(int index) {
        return super.getParentIndex(index);
    }

    @Override
    protected void swap(int i0, int i1) {
        super.swap(i0, i1);
    }

    @Override
    public int getnEltsInHeap() {
        return super.getnEltsInHeap();
    }

    @Override
    protected void incEltsInHeap() {
        super.incEltsInHeap();
    }

    @Override
    protected void decEltsInHeap() {
        super.decEltsInHeap();
    }

    @Override
    protected E getHighestPriority() {
        return super.getHighestPriority();
    }

    @Override
    public int getArrayLength() {
        return super.getArrayLength();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    @Override
    public E getEltAtIndex(int index) {
        return super.getEltAtIndex(index);
    }

    @Override
    public void setEltInHeap(int index, E data) {
        super.setEltInHeap(index, data);
    }

    protected void siftDown(int index, int nEltsInHeap) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChildIndex != -1 &&
                getEltAtIndex(leftChildIndex).compareTo(getEltAtIndex(nEltsInHeap)) > 0) {
            swap(leftChildIndex, nEltsInHeap);
            siftDown(leftChildIndex, nEltsInHeap);
        }

        if (rightChildIndex != -1 &&
                getEltAtIndex(rightChildIndex).compareTo(getEltAtIndex(nEltsInHeap)) > 0) {
            swap(rightChildIndex, nEltsInHeap);
            siftDown(rightChildIndex, nEltsInHeap);
        }
    }

    @Override
    protected void siftUp(int index) {
        super.siftUp(index);
    }

    @Override
    public void insert(E value) throws HeapFullException {
        super.insert(value);
    }

    public void heapify(int nEltsInHeap) {
        int index = getParentIndex(nEltsInHeap-1);
        while (index >= 0) {
            siftDown(index, nEltsInHeap);
            index--;
        }
    }

    public void heapsort() {
        int endIndex = getnEltsInHeap() - 1;
        heapify(endIndex);

        while (endIndex > 0) {
            swap(0, endIndex);
            endIndex--;
            siftDown(0, endIndex);
        }
    }
}
