package _01Foundations.ch01;

public class MaxSubArrayProblem {

    private int[] arr;

    public MaxSubArrayProblem(int[] arr) {
        this.arr = arr;
    }

    public int resolveQuadratic() {

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int localMax = arr[i - 1];

            for (int j = i; j < arr.length; j++) {

                localMax += arr[j];
                if (localMax > max)
                    max = localMax;
            }

        }
        return max;
    }

    public MaxSubArrayResult resolveQuadraticShowRange() {

        int max = arr[0];
        int init = 0;
        int end = 0;

        for (int i = 1; i < arr.length; i++) {
            int localMax = arr[i - 1];
            for (int j = i; j < arr.length; j++) {
                localMax += arr[j];
                if (localMax > max) {
                    max = localMax;
                    init = i - 1;
                    end = j;
                }
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
    }

}
