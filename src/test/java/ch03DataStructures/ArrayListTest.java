package ch03DataStructures;

import _03DataStructures.MyArrayList;
import _03DataStructures.impl.MyArrayListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void shouldReturnCorrectSize() {

        MyArrayList<Integer> list = new MyArrayListImpl<>();
        for (int i = 0; i < 900; i++) {
            list.add(i);
        }
        assertEquals(900, list.size());
    }

    @Test
    public void shouldReturnCorrectSizeAfterSetCapacity() {

        MyArrayList<String> list = new MyArrayListImpl<>(10);
        list.insert(8, "name");
        list.insert(9, "nick");
        assertEquals(2, list.size());
    }

    @Test
    public void shouldSetCorrectValueAtIndex() {

        MyArrayList<Integer> list = new MyArrayListImpl<>(5);
        for (int i = 0; i < 900; i++) {
            list.add(i);
        }
        list.set(200, 5);
        assertEquals(5, list.get(200));
    }

    @Test
    public void shouldBeEmpty() {
        MyArrayList<Integer> list = new MyArrayListImpl<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldBeEmptyAfterRemoving() {
        MyArrayList<Float> list = new MyArrayListImpl<>();
        list.add(2.3F);
        list.add(5.8F);
        list.add(9.9F);
        list.delete(0);
        list.delete(1);
        list.delete(2);
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldDelete() {

        MyArrayList<String> list = new MyArrayListImpl<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");

        assertTrue(list.contains("CC"));
        list.delete(2);
        assertFalse(list.contains("CC"));
    }

    @Test
    public void shouldInsertAtIndex() {

        MyArrayList<String> list = new MyArrayListImpl<>(10);
        list.insert(8, "name");

        assertNull(list.get(7));
        assertEquals("name", list.get(8));
    }

    @Test
    public void shouldResizeThenInsertAtIndex() {

        MyArrayList<String> list = new MyArrayListImpl<>(3);
        list.add("name");
        list.add("full name");
        list.add("nick");
        list.insert(2, "Bob");

        assertEquals(4, list.size());
        assertEquals("Bob", list.get(2));
    }

    @Test
    public void shouldResizeThenInsertAtIndex2() {

        MyArrayList<String> list = new MyArrayListImpl<>(1);
        list.add("name");
        list.add("full name");
        list.add("nick");
        list.insert(2, "Bob");

        assertEquals(4, list.size());
        assertEquals("Bob", list.get(2));
    }


}
