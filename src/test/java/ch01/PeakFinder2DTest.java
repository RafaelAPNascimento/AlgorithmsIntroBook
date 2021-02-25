package ch01;

import _01Foundations.ch01.peakfinder.PeakFinder2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PeakFinder2DTest {

    final int[][] matrix = {{ 10, 8, 10, 10, 2 },
                            { 14, 13, 12, 11, 5 },
                            { 15, 59, 11, 21, 8 },
                            { 16, 17, 2, 21, 9 }};

    final int[][] matrix2 = {{ 1, 2, 3, 4, 5 },
                             { 1, 9, 2, 5, 3 },
                             { 2, 3, 6, 7, 3 },
                             { 3, 2, 4, 8, 1 },
                             { 1, 9, 2, 3, 7 }};

    @Test
    @DisplayName("Should pass")
    public void test01() {

        PeakFinder2D peakFinder = new PeakFinder2D(matrix);
        int[] result = peakFinder.findPeak();

        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Should pass matrix2")
    public void test02() {

        PeakFinder2D peakFinder = new PeakFinder2D(matrix2);
        int[] result = peakFinder.findPeak();

        int[] expected = {3, 3};
        Assertions.assertArrayEquals(expected, result);
    }

}
