package DataStructures;

public class DoublyLinkedListNode<E> {

    E data;
    DoublyLinkedListNode<E> prev;
    DoublyLinkedListNode<E> next;

    public DoublyLinkedListNode(E data) {
        this.data = data;
    }

    public DoublyLinkedListNode(E data, DoublyLinkedListNode next) {

    }
}
