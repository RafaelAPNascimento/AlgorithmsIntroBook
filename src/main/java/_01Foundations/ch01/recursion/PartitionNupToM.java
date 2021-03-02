package _01Foundations.ch01.recursion;

/**
 *  Write a function that counts the number of ways you can partition N objects using parts up to M (assuming m >= 0)
 *  exemple: partition 6 objects in parts not greater than 4
 1  ****    **
 2  ****    *   *
 3  ***     ***
 4  ***     **      *
 5  ***     *   *   *
 6  **      **      **
 7  **      **      *   *
 9  **      *   *   *   *
 9  *   *   *   *   *   *
 *
 *  result = 9 ways
 */
public class PartitionNupToM {

    public int partition(int n, int m) {

        if (n == 0)
            return 1;

        if (n < 0 || m == 0)
            return 0;

        return partition(n, m - 1) + partition(n - m, m);
    }
}
