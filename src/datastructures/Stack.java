package datastructures;

// LIFO - Last in, first out
public class Stack {

    // top of stack
    private StackElement first;

    public Stack() {
        this.first = null;
    }

    // get top od stack
    public StackElement getTop() {
        return first;
    }

    //add element to top of stack
    public void push(int value) {
        StackElement element = new StackElement(value, first);
        first = element;
    }

    // delete element from top of stack
    public void pop() {
        if (first != null) {
            first = first.getNext();
        } else {
            System.out.println("Stack is empty");
        }
    }

    //display content of stack
    public void show() {
        if (first != null) {
            StackElement element = first;
            while (element != null) {
                System.out.println(element.getValue() + " ");
                element = element.getNext();
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty");
        }
    }
}

//Single Element
class StackElement {

    private int value;
    private StackElement next;

    public StackElement(int value, StackElement next) {
        this.value = value;
        this.next = next;
    }

    //get next element
    public int getValue() {
        return value;
    }

    //get value of element
    public StackElement getNext() {
        return next;
    }
}