package _03DataStructures;

import java.util.Objects;

public class TestLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int counter = 0;

    @Override
    public void push(E e) {

        Node newNode = new Node(e);

        if (isEmpty())
            head = tail = newNode;

        else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
        counter++;
    }

    @Override
    public void append(E e) {

        Node<E> newNode = new Node<>(e);

        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        counter++;
    }

    @Override
    public boolean remove(E e) {

        if (isEmpty())
            return false;

        if (head.data == e) {
            head = head.next;
            head.previous = null;
            counter--;
            return true;
        }
        else if (tail.data == e) {
            tail = tail.previous;
            tail.next = null;
            counter--;
            return true;
        }

        Node current = head.next;

        while (current != null) {

            if (current.data == e) {

                Node prev = current.previous;
                Node next = current.next;
                prev.next = next;
                next.previous = prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(E e) {

        if (isEmpty())
            return false;

        Node current = head;

        while (current != null) {

            if (current.data == e)
                return true;

            current = current.next;
        }

        return false;
    }

    @Override
    public int getSize() {
        return counter;
    }

    private boolean isEmpty() {
        return counter == 0;
    }

    private class Node<E> {

        E data;
        Node<E> next;
        Node<E> previous;

        private Node(E e) {
            this.data = e;
        }

        private Node(E e, Node next, Node previous) {
            this.data = e;
            this.next = next;
            this.previous = previous;
        }
    }
}
