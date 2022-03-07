package ch04;

import _04AdvancedDesignAnalisys.RodCutting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.logging.Logger;

public class RodCutTest {

    private int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

    @DisplayName("Should return optimun by length 4, using recursive approach")
    @Test
    public void shouldPassByLength4() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimun(prices, 4);
        Assertions.assertEquals(10, opt);
    }


    @DisplayName("Should return optimun by length 8, using recursive approach")
    @Test
    public void shouldPassByLength8() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimun(prices, 8);
        Assertions.assertEquals(22, opt);
    }

    @DisplayName("Should return optimun by length 4, using memoized approach")
    @Test
    public void shouldPassByLength4mem() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.dpOptimun(prices, 4);
        Assertions.assertEquals(10, opt);
    }

    @DisplayName("Should return optimun by length 8, using memoized approach")
    @Test
    public void shouldPassByLength8mem() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.dpOptimun(prices, 8);
        Assertions.assertEquals(22, opt);
    }

    @DisplayName("comparing execution time between recursive and memoized approach")
    @Test
    public void compareBothApproaches() {

        RodCutting rodCutting = new RodCutting();

        long start = Instant.now().toEpochMilli();
        int opt1 = rodCutting.optimun(prices, 8);
        long end = Instant.now().toEpochMilli();

        long timeRecursiveApproach = end - start;

        start = Instant.now().toEpochMilli();
        int opt2 = rodCutting.dpOptimun(prices, 8);
        end = Instant.now().toEpochMilli();

        long timeMemoizedApproach = end - start;

        LOG.info("Recursive approach " + timeRecursiveApproach);
        LOG.info("DP approach " + timeMemoizedApproach);

        Assertions.assertEquals(opt1, opt2);
        Assertions.assertEquals(22, opt1);
        Assertions.assertTrue(timeMemoizedApproach <= timeRecursiveApproach, "Memoized approach was not more efficient than recursive");
    }

    Logger LOG = Logger.getLogger(RodCutTest.class.getName());
}
