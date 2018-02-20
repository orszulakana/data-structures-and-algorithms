package datastructures;

public class SingleLinkedList {

    private Element first;

    public SingleLinkedList() {
        this.first = null;
    }

    public Element add(int value, Element element) {
        Element temp;
        if (first == null) {
            temp = new Element(value, null);
            first = temp;
        } else {
            temp = new Element(value, element.next);
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

        if (temp != null) {
            if (prev == null) {
                first = temp.next;
            } else {
                prev.next = temp.next;
            }
        }
    }

    public int search(int value) {
        Element temp = first;

        while (temp != null && temp.value != value) {
            temp = temp.next;
        }
        return temp.value;
    }

    class Element {
        private int value;
        private Element next;

        public Element(int value, Element next) {
            this.value = value;
            this.next = next;
        }
    }
}
