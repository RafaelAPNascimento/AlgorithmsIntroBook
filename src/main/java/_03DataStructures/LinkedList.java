package _03DataStructures;

import java.util.Objects;

public class LinkedList<E> {

    private Node<E> head;

    public LinkedList() {

    }

    public void push(E element) {

        // splices newNode into the front of head (so the current head becomes the 'new next')
        Node newNode = new Node(element, head, null);
        head = newNode;
    }

    public void append(E element) {

        Node newNode = new Node(element);

        // list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.previous = last;
    }

    public boolean remove(E element) {

        Node current = head;

        while (current != null) {
            if (current.data == element) {
                current.previous.next = current.next;
                return true;
            }
        }
        return false;
    }

    // like search
    public boolean contains(E element) {

        Node current = head;

        while (current != null) {

            if (current.data == element)
                return true;

            current = current.next;
        }
        return false;
    }

    class Node<E> {

        E data;
        Node<E> previous;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
            previous = null;
        }

        public Node(E data, Node next, Node previous) {

            this(data);
            this.next = next;
            this.previous = previous;

            if (!Objects.isNull(next))
                next.previous = this;
        }
    }




}
