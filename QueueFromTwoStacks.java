package DataStructures;

public class QueueFromTwoStacks<E> {
    private Stack<E> forwardStack = new Stack<>();
    private Stack<E> reverseStack = new Stack<>();

    public QueueFromTwoStacks() {

    }

    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }

    public boolean isEmpty() {
        return reverseStack.isEmpty() && reverseStack.isEmpty();
    }

    public void enq(E data) throws Queue.QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

        try {
            if (forwardStack.isEmpty()) {
                while (!reverseStack.isEmpty()) {
                    forwardStack.push(reverseStack.pop());
                }
            }
            forwardStack.push(data);
        } catch (Stack.StackOverflowException | Stack.StackUnderflowException se) {
            throw new Queue.QueueOverflowException();
        }
    }
}
