package _03DataStructures.impl;

import _03DataStructures.LinkedList;

import java.util.Objects;

import static java.util.Objects.nonNull;

public class LinkedListImpl<E> implements LinkedList<E> {

    private Node head;
    private Node tail;
    private int counter;

    private class Node {
        private Node prev;
        private Node next;
        private E data;

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public void push(E e) {

        Node neW = new Node(e);

        if (isEmpty())
            head = tail = neW;

        else {
            head.prev = neW;
            neW.next = head;
            head = neW;
        }
        counter++;
    }

    @Override
    public void append(E e) {

        Node neW = new Node(e);

        if (isEmpty())
            head = tail = neW;

        else {
            tail.next = neW;
            neW.prev = tail;
            tail = neW;
        }
        counter++;
    }

    @Override
    public boolean remove(E e) {

        if (isEmpty())
            return false;

        Node current = head;

        while (nonNull(current)) {
            if (current.data == e) {
                removeNode(current);
                counter--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void removeNode(Node current) {

        if (counter == 1)
            head = tail = null;

        else {
            Node prev = current.prev;
            Node next = current.next;

            if (prev != null)
                prev.next = next;

            if (next != null)
                next.prev = prev;
        }
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean contains(E e) {

        if (isEmpty())
            return false;

        Node current = head;
        while (nonNull(current)) {

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
}
