package DataStructures;

public class MinHeap<E extends Comparable> extends Heap<E> {

    public MinHeap(Class<E> c) {
        super(c);
    }

    public MinHeap(Class<E> c, int size) {
        super(c, size);
    }

    @Override
    protected void siftDown(int i) {
        int leftIndex = getLeftChildIndex(i);
        int rightIndex = getRightChildIndex(i);

        // find minimum of the left and right child elts
        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getEltAtIndex(leftIndex)
                    .compareTo(getEltAtIndex(rightIndex)) < 0 ?
                    leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else if (rightIndex != -1) {
            smallerIndex = rightIndex;
        }

        // if left and right child do not exist, stop sifting down
        if (smallerIndex == -1) {
            return;
        }

        // compare smaller child with current index to see if swap and
        //    further downshift is necessary
        if (getEltAtIndex(smallerIndex).compareTo(getEltAtIndex(i)) < 0) {
            swap(smallerIndex, i);
            siftDown(smallerIndex);
        }
    }


    protected void siftUp(int i) {
        int parentIndex = getParentIndex(i);

        // find minimum of the left and right child elts
        if (parentIndex != -1 && getEltAtIndex(i)
                    .compareTo(getEltAtIndex(parentIndex)) < 0) {
            swap(parentIndex, i);
            siftUp(parentIndex);
        }
    }

    @Override
    public void insert(E value ) throws HeapFullException {
        int n = getnEltsInHeap();
        if (n >= getArrayLength()) {
            throw new HeapFullException();
        }

        setEltInHeap(n, value);
        siftUp(n);

        incEltsInHeap();
    }

    public E remove() {
        E min = getHighestPriority();

        setEltInHeap(0, getEltAtIndex(getnEltsInHeap() - 1));
        decEltsInHeap();
        siftDown(0);

        return min;
    }

    public void heapify() {
        int lastIndex = getnEltsInHeap() -1;
        E last = getEltAtIndex(lastIndex);
        E parent = getEltAtIndex(getParentIndex(lastIndex));
    }


    public static int getMaximum(MinHeap<Integer> minHeap) {
        int lastIndex = minHeap.getnEltsInHeap() - 1;
        int lastParentIndex = minHeap.getParentIndex(lastIndex);

        int firstLeafIndex = lastParentIndex + 1;

        int maxElt = minHeap.getEltAtIndex(firstLeafIndex);

        for (int i = firstLeafIndex; i <= lastIndex; i++) {
            if (maxElt < minHeap.getEltAtIndex(i)) {
                maxElt = minHeap.getEltAtIndex(i);
            }
        }
        return maxElt;
    }

    public static void printKLargestElts(int k)
        throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k);

        for (int number : randomNumberArray) {
            if (minHeap.isEmpty()) {
                minHeap.insert(number);
            } else if (!minHeap.isFull() || minHeap.getHighestPriority() < number) {
                if (minHeap.isFull()) {
                    minHeap.removeHighestPriority();
                }
                minHeap.insert(number);
            }
        }
        minHeap.printHeapArray();
    }

}


