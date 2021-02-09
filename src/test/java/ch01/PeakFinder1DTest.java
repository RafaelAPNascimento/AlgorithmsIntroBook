package ch01;

import _01Foundations.ch01.peakfinder.PeakFinder1D;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class PeakFinder1DTest {

    final int NUMBER_OF_TESTS = 10_000;

    @TestFactory
    public DynamicTest[] myDTest() {

        DynamicTest[] dynamicTests = new DynamicTest[NUMBER_OF_TESTS];

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {

            int[] randomArray = getRandomIntArr();
            PeakFinder1D peakFinder = new PeakFinder1D(randomArray);
            int peak = peakFinder.findPeak();
            dynamicTests[i] = dynamicTest(String.format("Dynamic test %s", i + 1), () -> assertTrue(isPeak(randomArray, peak)));
        }
        return dynamicTests;
    }

    private static boolean isPeak(int[] arr, int index) {

        if (index == 0)
            return arr[0] >= arr[1];
        else if (index == arr.length - 1)
            return arr[index] >= arr[index - 1];
        else
            return arr[index] >= arr[index - 1] && arr[index] >= arr[index + 1];
    }

    private static int[] getRandomIntArr() {

        final int SIZE = ThreadLocalRandom.current().nextInt(2, 100_000);
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 10_000);
        }
        return arr;
    }
}
