package _03DataStructures;

public class LinkedListImpl<E> implements LinkedList<E> {

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

        Node current = head;
        while (current != null && current.data != e)
            current = current.next;

        boolean removed = removeNode(current);
        return removed;
    }

    private boolean removeNode(Node node) {

        if (node != null) {
            if (node.previous != null)
                node.previous.next = node.next;
            else
                head = node.next;

            if (node.next != null)
                node.next.previous = node.previous;
            else
                tail = node.previous;

            counter--;
            return true;
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
    }
}
