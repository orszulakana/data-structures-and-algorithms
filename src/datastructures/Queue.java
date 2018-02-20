package datastructures;

// FIFO - First in, first out
public class Queue {

    private Element first;
    private Element last;

    public Queue() {
        first = null;
        last = null;
    }

    public Element getFirst() {
        return first;
    }

    public Element getLast() {
        return last;
    }

    public void setLast(Element element) {
        last = element;
    }

    public void setFirst(Element element) {
        first = element;
    }

    // add element to end of queue
    public void enqueue(int value) {
        Element element = new Element(value);
        if (first == null) {
            first = last = element;
            element.setNext(null);
        } else {
            last.setNext(element);
            last = element;
        }
    }

    /* delete last element  */
    public void dequeue() {
        if (first != null) {
            if (first.getNext() == null) {
                last = null;
            }
            first = first.getNext();
        } else {
            System.out.println("Queue is empty");
        }
    }

    /* wyswietla zawartosc kolejki */
    public void show() {
        if (first != null) {
            Element temp = first;
            while (temp != null) {
                System.out.print(temp.getValue() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty");
        }
    }

    // single element in queue
    class Element {

        private int value;
        private Element next;

        public Element(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }
}

