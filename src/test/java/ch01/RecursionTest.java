package ch01;

import _01Foundations.ch01.recursion.PartitionNupToM;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecursionTest {

    @ParameterizedTest
    @CsvSource({"6, 4", "7, 4", "7, 3", "5, 3", "5, 1", "5, 0"})
    public void test1(int n, int m, TestInfo testInfo) {

        PartitionNupToM part = new PartitionNupToM();
        if (n == 6 && m == 4)
            assertEquals(9, part.partition(n, m));

        else if (n == 7 && m == 4)
            assertEquals(11, part.partition(n, m));

        else if (n == 7 && m == 3)
            assertEquals(8, part.partition(n, m));

        else if (n == 5 && m == 3)
            assertEquals(5, part.partition(n, m));

        else if (n == 5 && m == 1)
            assertEquals(1, part.partition(n, m));

        else if (n == 5 && m == 0)
            assertEquals(0, part.partition(n, m));
    }
}
