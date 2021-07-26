package ch01.util;

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
}
