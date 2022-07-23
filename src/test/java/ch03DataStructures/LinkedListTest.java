package ch03DataStructures;

import _03DataStructures.LinkedList;
import _03DataStructures.impl.LinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void shouldReturnCorrectSize() {

        LinkedList<Integer> lk = new LinkedListImpl<>();
        lk.append(1);
        lk.append(2);
        lk.append(3);
        lk.append(4);

        Assertions.assertEquals(4, lk.getSize());
    }

    @Test
    public void shouldReturnCorrectSizeAfterRemoving() {

        LinkedList<Integer> lk = new LinkedListImpl<>();
        lk.append(1);
        lk.append(2);
        lk.append(3);
        lk.append(4);
        lk.remove(4);
        Assertions.assertEquals(3, lk.getSize());
    }

    @Test
    public void shouldConfirmElementAfterAppend() {

        LinkedList<String> lk = new LinkedListImpl<>();
        lk.append("A");
        lk.append("B");
        lk.append("C");
        lk.append("D");
        Assertions.assertTrue(lk.contains("C"));
    }

    @Test
    public void shouldConfirmElementAfterPush() {

        LinkedList<String> lk = new LinkedListImpl<>();
        lk.append("A");
        lk.push("B");
        lk.push("C");
        lk.push("D");
        Assertions.assertTrue(lk.contains("C"));
    }

    @Test
    public void shouldNotContainElement() {

        LinkedList<String> lk = new LinkedListImpl<>();
        lk.append("A");
        lk.push("B");
        lk.push("C");
        lk.push("D");
        Assertions.assertFalse(lk.contains("E"));
    }

    @Test
    public void shouldNotContainElementAfterRemoving() {

        LinkedList<String> lk = new LinkedListImpl<>();
        lk.push("E");
        lk.append("A");
        lk.push("B");
        lk.push("C");
        lk.push("D");
        lk.remove("E");
        Assertions.assertFalse(lk.contains("E"));
    }

    @Test
    public void shouldNotRemoveBecauseDoesntExist() {

        LinkedList<String> lk = new LinkedListImpl<>();
        lk.push("E");
        Assertions.assertFalse(lk.remove("A"));
    }

    @Test
    public void shouldBeEmptyAfterRemovingAll() {

        LinkedList<Integer> lk = new LinkedListImpl<>();
        lk.append(1);
        lk.append(2);
        lk.append(3);
        lk.remove(1);
        lk.remove(2);
        lk.remove(3);
        Assertions.assertEquals(0, lk.getSize());
    }
}
