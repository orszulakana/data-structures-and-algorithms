package datastructures;

// LIFO - Last in, first out
public class Stack {

    // top of stack
    private Element top;

    public Stack() {
        this.top = null;
    }

    // get top od stack
    public Element getTop() {
        return top;
    }

    //add element to top of stack
    public void push(int value) {
        Element temp = new Element(value, top);
        top = temp;
    }

    // delete element from top of stack
    public void pop() {
        if (top != null) {
            top = top.getNext();
        } else {
            System.out.println("Stack is empty");
        }
    }

    //display content of stack
    public void show() {
        if (top != null) {
            Element temp = top;
            while (temp != null) {
                System.out.println(temp.getValue() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty");
        }
    }
}