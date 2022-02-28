package _04AdvancedDesignAnalisys;

public class RodCutting {


    /* https://www.techiedelight.com/rod-cutting/
        https://www.youtube.com/watch?v=re9rF9SqRFc
        https://www.youtube.com/watch?v=ElFrskby_7M
    */
    public static int recursiveOptimun(int[] prices, int length) {

        if (length == 0)
            return 0;

        int optimun = Integer.MIN_VALUE;

        for (int k = 1; k <= length; k++) {

            int current = prices[k - 1] + recursiveOptimun(prices, length - k);
            optimun = Math.max(optimun, current);
        }
        return optimun;
    }

    public static int dpOptmun() {
        return 0;
    }
}
