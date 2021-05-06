package ch01;

import _01Foundations.ch01.MaxSubArrayProblem;
import ch01.util.MaxSubArrayTestArgumentProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MaxSubArrayTest {

    @Tag("Calculate max subarray sum in quadratic time")
    @ParameterizedTest
    @ArgumentsSource(MaxSubArrayTestArgumentProvider.class)
    public void shouldResolveQuadratic(MaxSubArrayTestArgumentProvider.TestElements testElements, TestInfo testInfo) {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(testElements.getArrayParameter());
        Assertions.assertEquals(testElements.getExpectedMaxSum(), maxSubArray.resolveQuadratic());
    }

    @Tag("Calculate in linear time")
    @ParameterizedTest
    @ArgumentsSource(MaxSubArrayTestArgumentProvider.class)
    public void shouldResolveLinear(MaxSubArrayTestArgumentProvider.TestElements testElements, TestInfo testInfo) {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(testElements.getArrayParameter());
        Assertions.assertEquals(testElements.getExpectedMaxSum(), maxSubArray.resolveWithKadenes());
    }


    @Tag("Calculate in quadratic time, show ranges")
    @ParameterizedTest
    @ArgumentsSource(MaxSubArrayTestArgumentProvider.class)
    public void shouldBeOKwithRangeQuadratic(MaxSubArrayTestArgumentProvider.TestElements testElements, TestInfo testInfo) {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(testElements.getArrayParameter());
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveQuadraticShowRange();

        Assertions.assertEquals(testElements.getExpectedMaxSum(), result.getMax(), "Max sum is incorrect");
        Assertions.assertEquals(testElements.getInitRange(), result.getInitRange(), "Init range is incorrect");
        Assertions.assertEquals(testElements.getFinalRange(), result.getEndRange(), "End range is incorrect");
    }

    @Tag("Calculate in linear time, show range")
    @ParameterizedTest
    @ArgumentsSource(MaxSubArrayTestArgumentProvider.class)
    public void shouldBeOKwithRangeLinear(MaxSubArrayTestArgumentProvider.TestElements testElements, TestInfo testInfo) {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(testElements.getArrayParameter());
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveWithKadenesShowRange();

        Assertions.assertEquals(testElements.getExpectedMaxSum(), result.getMax());
        Assertions.assertEquals(testElements.getInitRange(), result.getInitRange());
        Assertions.assertEquals(testElements.getFinalRange(), result.getEndRange());
    }
}
