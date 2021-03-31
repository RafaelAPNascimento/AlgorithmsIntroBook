package ch02;

import _02SortingAndOrderStatistics.QuickSelection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuickSelectionTest {

    @Test
    public void test1() {

        int[] arr = {7, 4, 6, 3, 9, 1};
        QuickSelection qs = new QuickSelection(arr);
        Assertions.assertEquals(3, qs.findKthSmalest(2));
    }

    @Test
    public void test2() {

        int[] arr = {7, 4, 6, 3, 9, 1};
        QuickSelection qs = new QuickSelection(arr);
        Assertions.assertEquals(4, qs.findKthSmalest(3));
    }

    @Test
    public void test3() {

        int[] arr = {10, 4, 5, 8, 6, 11, 26};
        QuickSelection qs = new QuickSelection(arr);
        Assertions.assertEquals(5, qs.findKthSmalest(2));
    }

    @Test
    public void test4() {

        int[] arr = {10, 4, 5, 8, 6, 11, 26};
        QuickSelection qs = new QuickSelection(arr);
        Assertions.assertEquals(26, qs.findKthSmalest(7));
    }
}
