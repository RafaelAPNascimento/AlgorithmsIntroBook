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

    @Test
    @DisplayName("Deve retornar")
    public void test01() {

        PeakFinder2D peakFinder = new PeakFinder2D(matrix);
        int[] result = peakFinder.findPeak();

        int[] expected = {2, 1};
        System.out.println(result[0]+", "+result[1]);
        Assertions.assertArrayEquals(expected, result);
    }

}
