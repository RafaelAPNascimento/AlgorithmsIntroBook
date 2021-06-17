package _03DataStructures;

public class LinkedListImpl<E> implements LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int counter;

    public LinkedListImpl() {

    }

    @Override
    public void push(E e) {
        Node neww = new Node(e);
        if (counter == 0) {
            head = neww;
            tail = head;
        }
        else {
            neww.next = head;
            head.prev = neww;
            head = neww;
        }
        counter++;
    }

    @Override
    public void append(E e) {
        Node neww = new Node(e);
        if (counter == 0) {
            head = neww;
            tail = head;
        }
        else {
            neww.prev = tail;
            tail.next = neww;
            tail = neww;
        }
        counter++;
    }

    @Override
    public boolean remove(E e) {

        if (counter == 0)
            return false;

        else if (counter == 1) {
            head = tail = null;
            counter--;
            return true;
        }

        Node current = head;

        while (current != null) {
            if (current.data == e) {
                removeNode(current);
                counter--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void removeNode(Node node) {
        if (node == head) {
            head.next.prev = null;
            head = head.next;
        }
        else if (node == tail) {
            tail.prev.next = null;
            tail = tail.prev;
        }
        else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    @Override
    public boolean contains(E e) {
        if (counter > 0) {
            Node current = head;
            while (current != null) {
                if (current.data == e)
                    return true;

                current = current.next;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return counter;
    }

    class Node<E> {

        private E data;
        private Node<E> next;
        private Node<E> prev;

        private Node(E e) {
            this.data = e;
        }
    }
}
