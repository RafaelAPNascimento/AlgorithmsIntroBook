package _03DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BstImpl<E> implements BST<E> {

    private final Class<E> type;
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public BstImpl(Class<E> type) {
        this.type = type;
    }

    @Override
    public List<E> inOrderWalk() {

        List<E> list = new ArrayList<>(size);
        inOrderWalk(head, list);
        return list;
    }

    private void inOrderWalk(Node<E> node, List<E> list) {

        if (!Objects.isNull(node)) {
            inOrderWalk(node.left, list);
            list.add(node.data);
            inOrderWalk(node.right, list);
        }
    }

    private class Node<E> {

        E data;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
        }
    }
}
