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
    private int[] arr4 = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};   // 187
    private int[] arr5 = {1000, -41, 59, 26, -53, 58, 97, -93, -23, 84};   // 1000
    private int[] arr6 = {31, -41, 59, 26, -53, 58, 97, -93, -23, 1000};   // 1000

    private TestElements[] testElements;

    public MaxSubArrayTestArgumentProvider() {

        testElements = new TestElements[6];
        testElements[0] = new TestElements(arr1, 7, 2, 6);
        testElements[1] = new TestElements(arr2, 7, 2, 6);
        testElements[2] = new TestElements(arr3, 6, 3, 6);
        testElements[3] = new TestElements(arr4, 187, 2, 6);
        testElements[4] = new TestElements(arr5, 1146, 0, 6);
        testElements[5] = new TestElements(arr6, 1061, 2, 9);
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
