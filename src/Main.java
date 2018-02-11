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
        queue.add(2);
        queue.show();

        queue.add(6);
        queue.add(5);
        queue.show();

        queue.delete();
        queue.show();

        queue.delete();
        queue.show();
    }
}
