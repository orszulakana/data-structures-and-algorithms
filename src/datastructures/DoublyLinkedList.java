package datastructures;

public class DoublyLinkedList {

    private Element first;
    private Element last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public Element add(int value, Element element) {
        Element temp;

        if (first == null) {
            temp = new Element(value, null, null);
            first = temp;
            last = temp;
        } else {
            temp = new Element(value, element.next, element);

            if (temp.next != null) {
                element.next.prev = temp;
            } else {
                last = temp;
            }
            element.next = temp;
        }
        return temp;
    }

    public void delete(int value) {
        Element temp = first;
        Element prev = null;

        while (temp != null && temp.value != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null)
            if (prev == null) {
                first = temp.next;
                first.prev = null;
            } else {
                prev.next = temp.next;

                if (temp.next == null) {
                    last = prev;
                } else {
                    temp.next.prev = prev;
                }
            }
    }

    int search(int value) {
        Element temp = first;

        while (temp != null && temp.value != value) {
            temp = temp.next;
        }

        return temp.value;
    }

    class Element {

        private int value;
        private Element next;
        private Element prev;

        Element(int value, Element next, Element prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

