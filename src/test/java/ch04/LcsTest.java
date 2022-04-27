package ch04;

import _04AdvancedDesignAnalisys.LCS;
import ch01.util.LcsArgumentProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LcsTest {

    @ParameterizedTest
    @ArgumentsSource(LcsArgumentProvider.class)
    public void shouldPassLcsRecursiveApproach(LcsArgumentProvider.TestElements testElements, TestInfo testInfo) {

        LCS lcs = new LCS();
        int lcsREsult = lcs.lcsRecursive(testElements.getSeq1(), testElements.getSeq2());

        assertEquals(testElements.getLcs(), lcsREsult);
    }
}
