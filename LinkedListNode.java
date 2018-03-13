package DataStructures;

// TODO: HOW CAN I MAKE THIS CLASS PRIVATE FOR ONLY LINKEDLIST TO ACCESS?
public class LinkedListNode<T extends Comparable<T>> {

    private T data;
    private LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        setNext(null);
    }

    public LinkedListNode(T data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return this.data;
    }


    @Override
    public String toString() {
        return String.valueOf(data);
    }


}
