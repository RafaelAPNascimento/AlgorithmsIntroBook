package ch01.util;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUtil {

    /**
     * Returns an array whose length is some value between initRange and endRange
     * @param minPossibleSize
     * @param maxPossibleSize
     * @return
     */
    public static int[] getRandomIntArray(int minPossibleSize, int maxPossibleSize) {

        if (minPossibleSize > maxPossibleSize)
            throw new IllegalArgumentException("Minimum value must be smaller than maximum value");

        final int SIZE = ThreadLocalRandom.current().nextInt(minPossibleSize, maxPossibleSize);
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 999);
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    public static boolean isSorted(float[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    public static void assertRangesInSortedArray(int min, int max, int[] arr) {
        Assertions.assertEquals(min, arr[0], "Min value is incorrect");
        Assertions.assertEquals(max, arr[arr.length - 1], "Max Value is incorrect");
    }

    public static <T> boolean isSorted(List<T> list, Comparator<T> comparator) {

        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(list.get(i - 1), list.get(i)) > 0)
                return false;
        }
        return true;
    }

    public static void assertSortingProperties(int[] arr, int min, int max) {

        Objects.requireNonNull(arr, "Array is null");

        assertTrue(arr.length > 0, "Array size is ZERO!");
        assertEquals(min, arr[0], "Min value is incorrect");
        assertEquals(max, arr[arr.length - 1], "Max value is incorrect");
        assertTrue(isSorted(arr), "Array is not sorted");
    }
}
