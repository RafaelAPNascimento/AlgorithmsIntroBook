package ch01;

import _01Foundations.ch01.MaxSubArrayProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

// https://www.arhohuttunen.com/junit-5-parameterized-tests/
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
        Assertions.assertEquals(7, maxSubArray.resolveWithKadenes());
    }

    @Test
    public void shouldPassScenario2() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr3);
        Assertions.assertEquals(6, maxSubArray.resolveQuadratic());
        Assertions.assertEquals(6, maxSubArray.resolveWithKadenes());
    }

    @Test
    public void shouldBeOKwithRange() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr1);
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveQuadraticShowRange();

        Assertions.assertEquals(7, result.getMax());
        Assertions.assertEquals(2, result.getInitRange());
        Assertions.assertEquals(6, result.getEndRange());
    }

    @Test
    public void shouldBeOKwithRange2() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr2);
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveQuadraticShowRange();

        Assertions.assertEquals(7, result.getMax());
        Assertions.assertEquals(2, result.getInitRange());
        Assertions.assertEquals(6, result.getEndRange());
    }

    @Test
    public void shouldBeOKwithRange3() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr3);
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveQuadraticShowRange();

        Assertions.assertEquals(6, result.getMax());
        Assertions.assertEquals(3, result.getInitRange());
        Assertions.assertEquals(6, result.getEndRange());
    }

    @Test
    public void shouldBeOKwithRangeByKadenes() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr1);
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveWithKadenesShowRange();

        Assertions.assertEquals(7, result.getMax());
        Assertions.assertEquals(2, result.getInitRange());
        Assertions.assertEquals(6, result.getEndRange());
    }

    @Test
    public void shouldBeOKwithRange2ByKadenes() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr2);
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveQuadraticShowRange();

        Assertions.assertEquals(7, result.getMax());
        Assertions.assertEquals(2, result.getInitRange());
        Assertions.assertEquals(6, result.getEndRange());
    }

    @Test
    public void shouldBeOKwithRange3ByKadenes() {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(arr3);
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveWithKadenesShowRange();

        Assertions.assertEquals(6, result.getMax());
        Assertions.assertEquals(3, result.getInitRange());
        Assertions.assertEquals(6, result.getEndRange());
    }
}
