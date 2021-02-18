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
}
