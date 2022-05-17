package _01Foundations.ch01;

import java.util.Objects;

public class MaxSubArrayProblem {

    private int[] arr;

    public MaxSubArrayProblem(int[] arr) {
        this.arr = arr;
    }

    public int resolveQuadratic() {

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int local = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                local += arr[j];
                max = Math.max(local, max);
            }
        }
        return max;
    }

    public MaxSubArrayResult resolveQuadraticShowRange() {

        int max = arr[0];
        int init = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {

            int local = arr[i];

            for (int j = i + 1; j < arr.length; j++) {

                local += arr[j];
                if (local > max) {  // if I use >= it may return a smaller range
                    max = local;
                    init = i;
                    end = j;
                }
            }
        }
        return new MaxSubArrayResult(max, init, end);
    }

    public int resolveWithKadenes() {

        int max = arr[0];
        int localMax = max;
        for (int i = 1; i < arr.length; i++) {
            localMax = Math.max(arr[i], localMax + arr[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }

    public MaxSubArrayResult resolveWithKadenesShowRange() {

        int max = arr[0];
        int local = arr[0];
        int init = 0, end = 0;

        for (int i = 1; i < arr.length; i++) {

            local += arr[i];
            if (arr[i] > local) {
                local = arr[i];
                init = i;
            }
            if (local > max) {
                max = local;
                end = i;
            }

        }

        return new MaxSubArrayResult(max, init, end);
    }

    public class MaxSubArrayResult {
        private int max;
        private int initRange = -1;
        private int endRange = -1;

        public MaxSubArrayResult(int max) {
            this.max = max;
        }

        public MaxSubArrayResult(int max, int initRange, int endRange) {
            this.max = max;
            this.initRange = initRange;
            this.endRange = endRange;
        }

        public int getMax() {
            return max;
        }

        public int getInitRange() {
            return initRange;
        }

        public int getEndRange() {
            return endRange;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MaxSubArrayResult that = (MaxSubArrayResult) o;
            return max == that.max &&
                    initRange == that.initRange &&
                    endRange == that.endRange;
        }

        @Override
        public int hashCode() {
            return Objects.hash(max, initRange, endRange);
        }
    }

}
