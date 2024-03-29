package ch03DataStructures;

import _03DataStructures.BST;
import _03DataStructures.impl.BstImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BstTest {

    @DisplayName("Should insert then get")
    @Test
    public void shouldInsertThenGet() {
        
        BST<String, Integer> bst = new BstImpl<>();
        bst.put("A", 3);
        bst.put("B", 5);
        bst.put("C", 2);
        bst.put("K", 1);
        bst.put("K", 9);    // replace K value from 1 to 9

        assertEquals(3, bst.get("A"));
        assertEquals(5, bst.get("B"));
        assertEquals(2, bst.get("C"));
        assertEquals(9, bst.get("K"));

    }

    @DisplayName("Should get correct size")
    @Test
    public void shouldGetCorrectSize() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("A", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals(5, bst.size());
    }

    @DisplayName("Should replace value then get correct size")
    @Test
    public void shouldReplaceValueThenGetCorrectSize() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("A", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);
        bst.put("C", 9);
        assertEquals(5, bst.size());
    }

    @DisplayName("Should get correct min")
    @Test
    public void shouldGetMin() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals("B", bst.min());
    }

    @DisplayName("Should get correct max")
    @Test
    public void shouldGetMax() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals("Y", bst.max());
    }

    @DisplayName("Should return null when calling max() on a empty bst")
    @Test
    public void shouldGetMax2() {

        BST<String, Integer> bst = new BstImpl<>();
        assertNull(bst.max());
    }

    @DisplayName("Should get largest smaller than this")
    @Test
    public void shouldFloor() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("L", 5); bst.put("Y", 3);

        assertEquals("D", bst.floor("H"));
        assertEquals("Y", bst.floor("Z"));
        assertEquals(null, bst.floor("A"));
        assertEquals("Y", bst.floor("Z"));
        assertEquals("L", bst.floor("O"));
        assertEquals("L", bst.floor("L"));
    }

    @DisplayName("Should get largest smaller than this")
    @Test
    public void shouldFloor2() {

        BST<Integer, Integer> bst = new BstImpl<>();
        bst.put(65, 65); bst.put(60, 60); bst.put(55, 55);bst.put(70, 70); bst.put(80, 80);
            bst.put(50, 50); bst.put(30, 30); bst.put(40, 40); bst.put(20, 20);

        assertEquals(55, bst.floor(58));
        assertEquals(70, bst.floor(72));
        assertEquals(null, bst.floor(19));
        assertEquals(40, bst.floor(49));
    }

    @DisplayName("Should return node at rank k")
    @Test
    public void shouldSelect() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals("D", bst.select(2));       // there are 2 elements smaller than key D
        assertEquals("Y", bst.select(4));       // there are 4 elements smaller than key Y
        assertEquals(null, bst.select(9));      // there is no element greater than 9 elements
    }

    @DisplayName("Should return the number of keys smaller than or equal to this")
    @Test
    public void shouldRank() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals(2, bst.rank("D"));       // there are 2 elements smaller than key D
        assertEquals(4, bst.rank("Y"));       // there are 4 elements smaller than key Y
    }

    @DisplayName("Should return the number of keys smaller than or equal to this")
    @Test
    public void shouldRank2() {

        BST<Integer, Integer> bst = new BstImpl<>();
        bst.put(3, 3); bst.put(7, 7); bst.put(4, 4); bst.put(6, 6); bst.put(1, 1);
        bst.put(8, 8); bst.put(10, 10); bst.put(14, 14); bst.put(13,13);

        assertEquals(2, bst.rank(4));       // there are 2 elements smaller than key 4
        assertEquals(6, bst.rank(10));       // there are 6 elements smaller than key 10
    }

    @DisplayName("Should delete min")
    @Test
    public void shouldDeleteMin() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        bst.deleteMin();
        assertEquals("C", bst.min());

        bst.deleteMin();
        assertEquals("D", bst.min());
    }

    @DisplayName("Should delete min")
    @Test
    public void shouldDeleteMin2() {

        BST<Integer, Integer> bst = new BstImpl<>();
        bst.put(3, 3); bst.put(1, 1); bst.put(8, 8); bst.put(6, 6); bst.put(7, 7); bst.put(4, 4);
        bst.put(10, 10); bst.put(14, 14); bst.put(13, 13);

        bst.deleteMin();
        assertEquals(3, bst.min());

        bst.deleteMin();
        assertEquals(4, bst.min());
    }

    @DisplayName("Should delete key")
    @Test
    public void shouldDeleteKey() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals("B", bst.min());

        bst.delete("B");
        assertEquals("C", bst.min());

        assertEquals("Y", bst.max());
        bst.delete("Y");
        assertEquals("X", bst.max());
    }

    @DisplayName("After several operation, BST should keep its invariants")
    @Test
    public void shouldKeepInvariantsAfterOperations() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals(5, bst.size());

        bst.put("J", 9);
        assertEquals(6, bst.size());

        assertEquals("X", bst.floor("X"));
        bst.delete("X");
        assertEquals("J", bst.floor("X"));

        assertEquals(5, bst.size());

        assertEquals(3, bst.rank("J"));

        assertEquals("D", bst.select(2));
    }

    @Test
    public void shouldCeil() {

        BST<Integer, String> bst = new BstImpl<>();
        bst.put(14, "A");
        bst.put(10, "A");
        bst.put(12, "A");
        bst.put(6, "A");
        bst.put(2, "A");
        bst.put(4, "A");
        bst.put(8, "A");

        assertEquals(12, bst.ceiling(11));
        assertEquals(2, bst.ceiling(1));
        assertEquals(14, bst.ceiling(13));
        assertEquals(12, bst.ceiling(12));
        assertNull(bst.ceiling(15));
    }

}
