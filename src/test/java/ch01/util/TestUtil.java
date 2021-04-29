package ch01.util;

import java.util.concurrent.ThreadLocalRandom;

public class TestUtil {

    public static int[] getRandomIntArray(int init, int end) {

        final int SIZE = ThreadLocalRandom.current().nextInt(init, end);
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }
        return arr;
    }
}
