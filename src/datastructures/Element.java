package datastructures;

//Single Element in data structure
public class Element {

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
