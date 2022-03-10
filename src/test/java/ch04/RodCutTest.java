package ch04;

import _04AdvancedDesignAnalisys.RodCutting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.logging.Logger;

public class RodCutTest {

    Logger LOG = Logger.getLogger(RodCutTest.class.getName());

    private int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
    private int[] pricesBig = null;

    @DisplayName("Should return optimun by length 4, using recursive approach")
    @Test
    public void shouldPassByLength4() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimum(prices, 4);
        Assertions.assertEquals(10, opt);
    }


    @DisplayName("Should return optimun by length 8, using recursive approach")
    @Test
    public void shouldPassByLength8() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimum(prices, 8);
        Assertions.assertEquals(22, opt);
    }

    @DisplayName("Should return optimun by length 4, using memoized approach")
    @Test
    public void shouldPassByLength4mem() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimumDp(prices, 4);
        Assertions.assertEquals(10, opt);
    }

    @DisplayName("Should return optimun by length 8, using memoized approach")
    @Test
    public void shouldPassByLength8mem() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimumDp(prices, 8);
        Assertions.assertEquals(22, opt);
    }

    @DisplayName("comparing execution time between recursive and memoized approach")
    @Test
    public void compareBothApproaches() {

        //fillBig();

        RodCutting rodCutting = new RodCutting();

        long start = System.nanoTime();
        int opt1 = rodCutting.optimum(prices, prices.length);
        long end = System.nanoTime();

        long timeRecursiveApproach = end - start;

        start = System.nanoTime();
        int opt2 = rodCutting.optimumDp(prices, prices.length);
        end = System.nanoTime();

        long timeMemoizedApproach = end - start;

        LOG.info("Recursive approach " + timeRecursiveApproach);
        LOG.info("DP approach " + timeMemoizedApproach);

        Assertions.assertEquals(opt1, opt2);
        Assertions.assertEquals(22, opt1);
        Assertions.assertTrue(timeMemoizedApproach < (timeRecursiveApproach / 3), "Memoized approach was not more efficient than recursive");
    }

    private void fillBig() {

        Random random = new Random();
        pricesBig = new int[10_000];
        pricesBig[0] = 1;

        for (int i = 1; i < pricesBig.length; i++) {

            int v = random.nextInt(5 - 0);
            pricesBig[i] = pricesBig[i - 1] + v;
        }
    }
}
