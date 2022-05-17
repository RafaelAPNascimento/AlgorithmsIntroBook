package ch03;

import _03DataStructures.Map;
import _03DataStructures.impl.MapImpl;
import org.junit.jupiter.api.Disabled;
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

        final int INITIAL_BUCKET_SIZE = 10;
        Map<Integer, String> map = new MapImpl<>(INITIAL_BUCKET_SIZE);

        for (int i = 0; i < 1_000; i++)
            map.add(i, "A");

        assertEquals(1_000, map.size());
    }

    @Test
    public void shouldRemoveSameIndexElementsFromBuckets() {

        Map<String, Integer> names = new MapImpl<>();
        names.add("A", 56);
        names.add("B", 91);
        names.add("C", 20);   // bucket 7
        names.add("a", 46);   // bucket 7
        names.add("b", 99);
        names.add("X", 5);

        assertEquals(6, names.size());

        Integer value = names.remove("a");

        assertEquals(46, value);
        assertEquals(5, names.size());

        value = names.remove("C");
        assertEquals(20, value);

        // should not be in the buckets anymore
        assertNull(names.get("a"));
        assertNull(names.get("C"));
    }

    @Test
    public void shouldPassWithDifferentObjectsSameBucket() {

        Map<String, Integer> map = new MapImpl<>((float) 9.9);

        for (int i = 65; i <= 90; i++) {
            char c = (char) i;
            map.add(String.valueOf(c), i);
        }
        for (int i = 97; i <= 120; i++) {
            char c = (char) i;
            map.add(String.valueOf(c), i);
        }

        Integer vA = map.remove("A");
        Integer vS = map.remove("s");
        Integer vI = map.remove("i");
        Integer vU = map.remove("U");

        assertEquals(vA, 65);
        assertEquals(vS, 115);
        assertEquals(vI, 105);
        assertEquals(vU, 85);

        assertNull(map.get("A"));
        assertNull(map.get("s"));
        assertNull(map.get("i"));
        assertNull(map.get("U"));

        Integer vK = map.get("K");
        assertEquals(75, vK);
        assertNotNull(map.get("K"));
    }

    @Disabled
    @Test
    public void checkThreshould() {
        //...
    }
}
