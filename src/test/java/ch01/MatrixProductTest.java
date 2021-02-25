package ch01;

import _01Foundations.ch01.MatrixProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixProductTest {

    int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}};
    int[][] b = new int[][]{{7, 8}, {9, 10}, {11, 12}};
    int[][] expected = new int[][]{{58, 64}, {139, 154}};

    @Test
    public void shouldPass() {

        int[][] c = MatrixProduct.multiply(a, b);

        assertArrayEquals(expected[0], c[0]);
        assertArrayEquals(expected[1], c[1]);
    }
}
