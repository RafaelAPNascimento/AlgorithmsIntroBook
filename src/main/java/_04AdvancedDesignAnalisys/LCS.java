package _04AdvancedDesignAnalisys;

import static java.lang.Math.max;

// Longest Common subsequence
// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
public class LCS {


    public int lcsRecursive(String s1, String s2) {

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        return lcs(x, y, x.length, y.length);
    }

    public int lcsDP(String s1, String s2) {

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        return lcsDP(x, y, x.length, y.length);
    }

    private int lcs(char[] x, char[] y, int m, int n)  {

        if (m == 0 || n == 0)
            return 0;

        if (x[m - 1] == y[n - 1])
            return 1 + lcs(x, y, m - 1, n - 1);

        else
            return max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
    }

    private int lcsDP(char[] x, char[] y, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (x[i - 1] == y[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }
        return dp[m][n];
    }

}
