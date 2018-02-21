package datastructures;

import java.util.LinkedList;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void preOrder(Node node) {
        System.out.print(node + " ");
        Node temp = node.getLeftMostChild();
        while (temp != null) {
            preOrder(temp);
            temp = temp.getRightSibling();
        }
    }

    public void inOrder(Node node) {
        if (node.isLeaf())
            System.out.print(node + " ");
        else {
            Node temp = node.getLeftMostChild();
            inOrder(temp);
            System.out.print(node + " ");
            temp = temp.getRightSibling();
            while (temp != null) {
                inOrder(temp);
                temp = temp.getRightSibling();
            }
        }
    }

    public void postOrder(Node node) {
        Node temp = node.getLeftMostChild();
        while (temp != null) {
            postOrder(temp);
            temp = temp.getRightSibling();
        }
        System.out.print(node + " ");
    }

    class Node {
        private int value;
        private Node parent;
        private LinkedList<Node> children; // list of children

        public Node() {
            parent = null;
            children = new LinkedList<>();
        }

        public Node(Node parent) {
            this();
            this.parent = parent;
        }

        public Node(Node parent, int value) {
            this(parent);
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getDegree() {
            return children.size();
        }

        public Node getChild(int idx) {
            return children.get(idx);
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }

        public Node addChild(Node child) {
            child.setParent(this);
            children.add(child);
            return child;
        }

        public Node addChild(int value) {
            Node child = new Node(this, value);
            children.add(child);
            return child;
        }

        public Node removeChild(int idx) {
            return children.remove(idx);
        }

        public void removeChildren() {
            children.clear();
        }

        public Node getLeftMostChild() {
            if (children.isEmpty()) return null;
            return children.get(0);
        }

        public LinkedList<Node> getChildren() {
            if (children.isEmpty()) return null;
            return children;
        }

        public Node getRightSibling() {
            if (parent != null) {
                LinkedList<Node> childrenParent = parent.getChildren();
                int position = childrenParent.indexOf(this);
                if (childrenParent.size() > position + 1)
                    return childrenParent.get(position + 1);
            }
            return null;
        }

        public String toString() {
            return String.valueOf(value);
        }
    }
}