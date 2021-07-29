package ch01.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestUtil {

    /**
     * Returns an array whose length is some value between initRange and endRange
     * @param initRange
     * @param endRange
     * @return
     */
    public static int[] getRandomIntArray(int initRange, int endRange) {

        final int SIZE = ThreadLocalRandom.current().nextInt(initRange, endRange);
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

    public static <T> boolean isSorted(List<T> list, Comparator<T> comparator) {

        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(list.get(i - 1), list.get(i)) > 0)
                return false;
        }
        return true;
    }
}
