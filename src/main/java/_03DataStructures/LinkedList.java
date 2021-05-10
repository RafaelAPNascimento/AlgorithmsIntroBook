package _03DataStructures;

import java.util.Objects;

public class LinkedList<E> {

    private Node<E> head;
    private int counter = 0;

    public LinkedList() {

    }

    public void push(E element) {

        counter++;

        // splices newNode into the front of head (so the current head becomes the 'new next')
        Node newNode = new Node(element, head, null);
        head = newNode;
    }

    public void append(E element) {

        Node newNode = new Node(element);

        counter++;
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

        Node<E> current = head;

        while (current != null) {

            if (isEquals(current.data, element)) {
                current.previous.next = current.next;
                counter--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // like search
    public boolean contains(E element) {

        Node<E> current = head;

        while (current != null) {

            if (isEquals(current.data, element))
                return true;

            current = current.next;
        }
        return false;
    }

    public int getSize() {

        return counter;
    }

    private boolean isEquals(E e, E other) {
        return Objects.equals(e, other);
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
