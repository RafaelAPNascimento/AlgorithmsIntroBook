package ch03;

import _03DataStructures.BST;
import _03DataStructures.BstImpl;
import ch01.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BstTest {

    @DisplayName("Should return in order after insert")
    @Test
    public void shouldReturnInOrderAfterInsert() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        List<Integer> list = bst.inOrderWalk();

        boolean sorted = TestUtil.isSorted(list, comparator);
        Assertions.assertTrue(sorted);
    }

    @DisplayName("Should return correct size after inserting")
    @Test
    public void shouldReturnCorrectSize() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        Assertions.assertEquals(6, bst.getSize());
    }

    @DisplayName("Should return max")
    @Test
    public void shouldReturnMax() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        Assertions.assertEquals(10, bst.maximum());
    }

    @DisplayName("Should return min")
    @Test
    public void shouldReturnMin() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        Assertions.assertEquals(3, bst.minimum());
    }

    @DisplayName("Should contain")
    @Test
    public void shouldContain() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        Assertions.assertTrue(bst.contains(9));
    }

    @DisplayName("Should not contain")
    @Test
    public void shouldNotContain() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        Assertions.assertFalse(bst.contains(11));
    }

    @DisplayName("Should return correct higher")
    @Test
    public void shouldReturnCorrectHigher() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        Assertions.assertEquals(7, bst.higher(5));
    }

    @DisplayName("Should return correct higher")
    @Test
    public void shouldReturnCorrectLower() {

        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        BST<Integer> bst = new BstImpl(Integer.class, comparator);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);

        Assertions.assertEquals(7, bst.lower(8));
    }



}
