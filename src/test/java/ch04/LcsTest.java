package ch04;

import _04AdvancedDesignAnalisys.LCS;
import ch01.util.LcsArgumentProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LcsTest {

    @Test
    public void shouldPassLcsRecursiveApproach() {

        LCS lcs = new LCS();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int expected = 4;

        assertEquals(expected, lcs.lcsRecursive(s1, s2));
    }

    @ParameterizedTest
    @ArgumentsSource(LcsArgumentProvider.class)
    public void shouldPassLcsDPApproach(LcsArgumentProvider.TestElements testElements, TestInfo testInfo) {

        LCS lcs = new LCS();
        int lcsResult = lcs.lcsDP(testElements.getSeq1(), testElements.getSeq2());

        assertEquals(testElements.getLcs(), lcsResult);
    }
}
