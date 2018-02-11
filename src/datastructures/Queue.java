package datastructures;

// FIFO - First in, first out
public class Queue {

    private QueueElement first;
    private QueueElement last;

    public Queue() {
        first = null;
        last = null;
    }

    public QueueElement getFirst() {
        return first;
    }

    public QueueElement getLast() {
        return last;
    }

    public void setLast(QueueElement element) {
        last = element;
    }

    public void setFirst(QueueElement element) {
        first = element;
    }

    // add element to end of queue
    public void add(int value) {
        QueueElement element = new QueueElement(value);
        if (first == null) {
            first = last = element;
            element.setNext(null);
        } else {
            last.setNext(element);
            last = element;
        }
    }

    /* delete last element  */
    public void delete() {
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
            QueueElement temp = first;
            while (temp != null) {
                System.out.print(temp.getValue() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty");
        }
    }
}

// single element in queue
class QueueElement {

    private int value;
    private QueueElement next;

    public QueueElement(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public QueueElement getNext() {
        return next;
    }

    public void setNext(QueueElement next) {
        this.next = next;
    }
}