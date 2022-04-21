package ch03;

import _03DataStructures.Map;
import _03DataStructures.impl.MapImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void shouldRetrieveByKey() {

        Map<Integer, String> names = new MapImpl<>();
        names.add(1, "Adão");
        names.add(2, "Paulo");
        names.add(3, "Pedro");
        names.add(4, "Maria");

        assertEquals("Paulo", names.get(2));
        assertEquals("Maria", names.get(4));
        assertEquals("Adão", names.get(1));
        assertEquals("Pedro", names.get(3));
    }

    @Test
    public void shouldReturnNullByKey() {

        Map<Integer, String> names = new MapImpl<>();
        names.add(1, "Adão");
        names.add(2, "Paulo");
        names.add(3, "Pedro");
        names.add(4, "Maria");

        assertNull(names.get(0));
        assertNull(names.get(5));
    }

    @Test
    public void shouldReturnCorrectSize() {

        Map<Integer, String> map = new MapImpl<>();

        for (int i = 0; i < 1_000; i++)
            map.add(i, "A");

        assertEquals(1_000, map.size());
    }

    @Test
    public void shouldBeEmptyAfterRemovingAll() {

        Map<Integer, String> map = new MapImpl<>();

        for (int i = 0; i < 1_000; i++)
            map.add(i, "A");

        for (int i = map.size(); i >= 0; i--)
            map.remove(i);

        assertTrue(map.isEmpty());
    }

    @Test
    public void shouldRemoveElement() {

        Map<Integer, String> names = new MapImpl<>();
        names.add(1, "Adão");
        names.add(2, "Paulo");
        names.add(3, "Pedro");
        names.add(4, "Maria");
        names.add(5, "Tiago");

        String name = names.remove(3);

        assertEquals("Pedro", name);
        assertNull(names.get(3));
    }

    @Test
    public void shouldUpdateElement() {

        Map<Integer, String> names = new MapImpl<>();
        names.add(1, "Adão");
        names.add(2, "Paulo");
        names.add(3, "Pedro");
        names.add(4, "Maria");
        names.add(5, "Tiago");

        names.add(4, "Jose");

        assertEquals("Jose", names.get(4));
    }

    @Test
    public void shouldIncreaseLoadFactor() {

        final int INITIAL_LOAD_FACTOR = 10;
        Map<Integer, String> map = new MapImpl<>(INITIAL_LOAD_FACTOR);

        for (int i = 0; i < 1_000; i++)
            map.add(i, "A");

        assertEquals(1_000, map.size());
    }

    @Test
    public void shouldUpdateElement2() {

        Map<String, Object> names = new MapImpl<>();
        names.add("A", new Object());
        names.add("B", new Object());
        names.add("C", new Object());
        names.add("a", new Object());
        names.add("b", new Object());

        names.add("X", "K");

        assertEquals("K", names.get("X"));
    }

    @Test
    public void shouldPassWithDifferentObjectsSameHash() {

        // create a test that adds different objects with same hash code to test if the buckets are working correctly
        // how to generate same hash for different objects?
    }

}
