package ch04;

import _04AdvancedDesignAnalisys.RodCutting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RodCutTest {

    private int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

    @Disabled
    @DisplayName("Should return optimun by length 4, using recursive approach")
    @Test
    public void shouldPassByLength4() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimun(prices, 4);
        Assertions.assertEquals(10, opt);
    }

    @Disabled
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
}
