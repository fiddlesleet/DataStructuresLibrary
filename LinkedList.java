package DataStructures;

public class LinkedList<T extends Comparable<T>> {

    private LinkedListNode<T> head = null;

    public LinkedList() {

    }

    public void addFirstNode(T data) {
        LinkedListNode<T> oldHead = head;
        this.head = new LinkedListNode<T>(data);
        this.head.setNext(oldHead);
    }

    public void removeFirstNode() {
        this.head = this.head.getNext();
    }


    public void addLastNode(T data) {
        if (head == null) {
            head = new LinkedListNode<T>(data);
        } else {
            LinkedListNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new LinkedListNode<T>(data));
        }
    }

    public void removeLastNode() {
        LinkedListNode<T> current = this.head;
        while ((current.getNext()).getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        if (head == null) {
            return 0;
        } else {
            LinkedListNode<T> current = head;
            int size = 0;

            while (current != null) {
                current = current.getNext();
                size++;
            }

            return size;
        }
    }

    // return first elt of list
    public T pop() {
        if (head != null) {
            T top = head.getData();
            head = head.getNext();
            return top;
        }
        return null;
    }

}
