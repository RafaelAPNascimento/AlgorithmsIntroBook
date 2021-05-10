package ch03;

import _03DataStructures.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void shouldReturnCorrectSize() {

        LinkedList<Integer> lk = new LinkedList<>();
        lk.append(1);
        lk.append(2);
        lk.append(3);
        lk.append(4);

        Assertions.assertEquals(4, lk.getSize());
    }

    @Test
    public void shouldReturnCorrectSizeAfterRemoving() {

        LinkedList<Integer> lk = new LinkedList<>();
        lk.append(1);
        lk.append(2);
        lk.append(3);
        lk.append(4);
        lk.remove(4);
        Assertions.assertEquals(3, lk.getSize());
    }

    @Test
    public void shouldConfirmContainedElement() {

        LinkedList<String> lk = new LinkedList<>();
        lk.append("A");
        lk.append("B");
        lk.append("C");
        lk.append("D");
        Assertions.assertTrue(lk.contains("C"));
    }
}
