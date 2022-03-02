package _04AdvancedDesignAnalisys;

public class RodCutting {

    /*      https://www.techiedelight.com/rod-cutting/
            https://www.youtube.com/watch?v=re9rF9SqRFc
            https://www.youtube.com/watch?v=ElFrskby_7M
        */
    public int optimun(int[] prices, int length) {

        if (length == 0)
            return 0;

        int optimun = Integer.MIN_VALUE;

        for (int k = 1; k <= length; k++) {

            int current = prices[k - 1] + optimun(prices, length - k);
            optimun = Math.max(optimun, current);
        }
        return optimun;
    }

    // https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
    public int dpOptimun(int[] price, int n) {

        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        return val[n];
    }
}
