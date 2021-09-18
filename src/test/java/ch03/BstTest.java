package ch03;

import _03DataStructures.BST;
import _03DataStructures.BstImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("Should return node at rank k")
    @Test
    public void shouldSelect() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals("D", bst.select(2));       // there are 2 elements smaller than key D
        assertEquals("Y", bst.select(4));       // there are 4 elements smaller than key Y
    }

    @DisplayName("Should return the number of keys smaller than or equal to this")
    @Test
    public void shouldRank() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        assertEquals(2, bst.rank("D"));       // there are 2 elements smaller than key D
        assertEquals(4, bst.rank("Y"));       // there are 4 elements smaller than key Y
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

    @DisplayName("Should delete key")
    @Test
    public void shouldDeleteKey() {

        BST<String, Integer> bst = new BstImpl<>();
        bst.put("D", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

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


}
