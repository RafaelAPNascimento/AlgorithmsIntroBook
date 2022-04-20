package _04AdvancedDesignAnalisys;

import _03DataStructures.Map;

public class RodCutting {


    /*      https://www.techiedelight.com/rod-cutting/
            https://www.youtube.com/watch?v=re9rF9SqRFc
            https://www.youtube.com/watch?v=ElFrskby_7M
        */
    public int optimum(int[] prices, int length) {

        if (length == 0)
            return 0;

        int optimun = Integer.MIN_VALUE;

        for (int k = 1; k <= length; k++) {

            int current = prices[k - 1] + optimum(prices, length - k);
            optimun = Math.max(optimun, current);
        }
        return optimun;
    }

    public int optimumDp(int[] v, int n) {

        int[] opts = new int[n + 1];

        int optimum = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= i; k++) {

                int tmp = v[k - 1] + opts[i - k];
                optimum = Math.max(tmp, optimum);

                // store maximums in the table so we don't need to calculate any optimum twice
                if (i == k) {
                    opts[i] = optimum;
                }
            }
        }
        return optimum;
    }
}

