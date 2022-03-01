package ch04;

import _04AdvancedDesignAnalisys.RodCutting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RodCutTest {

    private int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

    @DisplayName("Should return optimun by length 4")
    @Test
    public void shouldPassByLength4() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimun(prices, 4);
        Assertions.assertEquals(10, opt);
    }

    @DisplayName("Should return optimun by length 8")
    @Test
    public void shouldPassByLength8() {

        RodCutting rodCutting = new RodCutting();
        int opt = rodCutting.optimun(prices, 8);
        Assertions.assertEquals(22, opt);
    }
}
