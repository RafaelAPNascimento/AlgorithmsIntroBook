package ch01;

import _01Foundations.ch01.MaxSubArrayProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MaxSubArrayTest {

    private MaxSubArrayProblem maxSubArray;

    private int[] arr1 =  {-2, -3, 4, -1, -2, 1, 5, -3};     // 7
    private int[] arr2 = {-2, -5, 6, -2, -3, 1, 5, -6};    // 7
    private int[] arr3 = {-3, 1, -8, 4, -1, 2, 1, -5, 5};   // 6

    @Test
    public void shouldPassScenario1() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr1);
        Assertions.assertEquals(7, maxSubArray.resolveQuadratic());
    }
}
