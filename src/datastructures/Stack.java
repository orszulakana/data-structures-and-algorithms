package datastructures;

// LIFO - Last in, first out
public class Stack {

    // top of stack
    private Element first;

    public Stack() {
        this.first = null;
    }

    // get top od stack
    public Element getTop() {
        return first;
    }

    //add element to top of stack
    public void push(int value) {
        Element element = new Element(value, first);
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
            Element element = first;
            while (element != null) {
                System.out.println(element.getValue() + " ");
                element = element.getNext();
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty");
        }
    }

    //Single Element
    class Element {

        private int value;
        private Element next;

        public Element(int value, Element next) {
            this.value = value;
            this.next = next;
        }

        //get next element
        public int getValue() {
            return value;
        }

        //get value of element
        public Element getNext() {
            return next;
        }
    }
}

