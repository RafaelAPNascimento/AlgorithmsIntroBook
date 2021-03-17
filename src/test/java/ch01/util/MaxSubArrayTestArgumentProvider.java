package ch01.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaxSubArrayTestArgumentProvider implements ArgumentsProvider {

    private int[] arr1 =  {-2, -3, 4, -1, -2, 1, 5, -3};     // 7
    private int[] arr2 = {-2, -5, 6, -2, -3, 1, 5, -6};    // 7
    private int[] arr3 = {-3, 1, -8, 4, -1, 2, 1, -5, 5};   // 6

    private TestElements[] testElements;

    public MaxSubArrayTestArgumentProvider() {

        testElements = new TestElements[3];
        testElements[0] = new TestElements(arr1, 7, 2, 6);
        testElements[1] = new TestElements(arr2, 7, 2, 6);
        testElements[2] = new TestElements(arr3, 6, 3, 6);
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Arrays.stream(testElements).map(Arguments::of);
    }


    public class TestElements {

        private int[] arrayParameter;
        private int expectedMaxSum;
        private int initRange;
        private int finalRange;

        public TestElements(int[] arr, int expected, int initRange, int finalRange) {

            this.arrayParameter = arr;
            this.expectedMaxSum = expected;
            this.initRange = initRange;
            this.finalRange = finalRange;
        }

        public int[] getArrayParameter() {
            return arrayParameter;
        }

        public int getExpectedMaxSum() {
            return expectedMaxSum;
        }

        public int getInitRange() {
            return initRange;
        }

        public int getFinalRange() {
            return finalRange;
        }
    }

}
