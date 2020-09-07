package com.leecode.question0347;

public class Node {
    private Node previous;
    private Node next;
    private int counter;

    public Node() {
    }

    public Node(int counter) {
        this.counter = counter;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increaseCounter() {
        counter += 1;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
