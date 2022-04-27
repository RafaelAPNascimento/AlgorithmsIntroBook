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

    private int lcs(char[] x, char[] y, int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        if (x[m - 1] == y[n - 1])
            return 1 + lcs(x, y, m - 1, n - 1);

        else
            return max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
    }
}
