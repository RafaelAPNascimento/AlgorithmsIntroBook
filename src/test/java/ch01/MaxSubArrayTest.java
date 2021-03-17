package ch01;

import _01Foundations.ch01.MaxSubArrayProblem;
import ch01.util.MaxSubArrayTestArgumentProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MaxSubArrayTest {

    @ParameterizedTest
    @ArgumentsSource(MaxSubArrayTestArgumentProvider.class)
    public void shouldResolveQuadratic(MaxSubArrayTestArgumentProvider.TestElements testElements, TestInfo testInfo) {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(testElements.getArrayParameter());
        Assertions.assertEquals(testElements.getExpectedMaxSum(), maxSubArray.resolveQuadratic());
    }

    @ParameterizedTest
    @ArgumentsSource(MaxSubArrayTestArgumentProvider.class)
    public void shouldResolveLinear(MaxSubArrayTestArgumentProvider.TestElements testElements, TestInfo testInfo) {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(testElements.getArrayParameter());
        Assertions.assertEquals(testElements.getExpectedMaxSum(), maxSubArray.resolveWithKadenes());
    }


    @ParameterizedTest
    @ArgumentsSource(MaxSubArrayTestArgumentProvider.class)
    public void shouldBeOKwithRangeQuadratic(MaxSubArrayTestArgumentProvider.TestElements testElements, TestInfo testInfo) {

        MaxSubArrayProblem maxSubArray = new MaxSubArrayProblem(testElements.getArrayParameter());
        MaxSubArrayProblem.MaxSubArrayResult result = maxSubArray.resolveQuadraticShowRange();

        Assertions.assertEquals(testElements.getExpectedMaxSum(), result.getMax());
        Assertions.assertEquals(testElements.getInitRange(), result.getInitRange());
        Assertions.assertEquals(testElements.getFinalRange(), result.getEndRange());
    }

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
