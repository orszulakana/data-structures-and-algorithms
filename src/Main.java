import datastructures.Queue;
import datastructures.Stack;

public class Main {

    public static void main(String[] args) {
        //testStack();

        testQueue();
    }

    private static void testStack() {
        Stack stack = new Stack();
        stack.push(2);
        stack.show();

        stack.push(6);
        stack.push(5);
        stack.show();

        stack.pop();
        stack.show();

        stack.pop();
        stack.show();
    }

    private static void testQueue() {
        Queue queue = new Queue();
        queue.enqueue(2);
        queue.show();

        queue.enqueue(6);
        queue.enqueue(5);
        queue.show();

        queue.dequeue();
        queue.show();

        queue.dequeue();
        queue.show();
    }
}
