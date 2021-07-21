package ch03;

import _03DataStructures.BST;
import _03DataStructures.BstImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BstTest {

    @Test
    public void t1() {

        Comparator<Integer> comparator = (i1, i2) -> i1 - i2;
        BST<Integer> bst = new BstImpl(String.class, comparator);
        //bst.insert(5);


        Set<String> s = new TreeSet(comparator);
        //s.add("d");

        Assertions.assertTrue(true);
    }

}
