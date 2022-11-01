package _03DataStructures.impl;

import _03DataStructures.Bag;

import java.util.Iterator;

public class BagImpl<E> implements Bag<E> {

    private Node first;
    private int size;

    private class Node {
        E element;
        Node next;
        Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void add(E element) {
        Node oldFirst  = first;
        first = new Node(element, oldFirst);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {

        return null;
    }

    private class ListIterator implements Iterator<E> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }
    }
}
