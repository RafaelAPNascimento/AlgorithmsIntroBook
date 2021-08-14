package ch03;

import _03DataStructures.BST_;
import _03DataStructures.BstImpl_;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BstTest_ {

    @DisplayName("Should insert then get")
    @Test
    public void shouldInsertThenGet() {

        BST_<String, Integer> bst = new BstImpl_<>();
        bst.put("A", 3);
        bst.put("B", 9);
        bst.put("C", 2);

        Assertions.assertEquals(3, bst.get("A"));
        Assertions.assertEquals(9, bst.get("B"));
        Assertions.assertEquals(2, bst.get("C"));
    }

    @DisplayName("Should get correct size")
    @Test
    public void shouldGetCorrectSize() {

        BST_<String, Integer> bst = new BstImpl_<>();
        bst.put("A", 3); bst.put("B", 5); bst.put("C", 2); bst.put("X", 5); bst.put("Y", 3);

        Assertions.assertEquals(5, bst.size());
    }

}
