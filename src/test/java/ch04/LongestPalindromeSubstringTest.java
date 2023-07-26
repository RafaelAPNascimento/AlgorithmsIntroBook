package ch04;

import _04AdvancedDesignAnalisys.LongestPalindromeSubstring;
import ch01.util.LongestPalindromeSubstringArgsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class LongestPalindromeSubstringTest {

    @ParameterizedTest
    @ArgumentsSource(LongestPalindromeSubstringArgsProvider.class)
    public void shouldBeOkByBruteForceApproach(LongestPalindromeSubstringArgsProvider.TestElements provider, TestInfo info) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        String result = lps.longestPalindromeBruteforce(provider.getString());
        Assertions.assertEquals(provider.getLongestPalindromeSubstring(), result);
    }

    @ParameterizedTest
    @ArgumentsSource(LongestPalindromeSubstringArgsProvider.class)
    public void shouldBeOkByDPApproach(LongestPalindromeSubstringArgsProvider.TestElements provider, TestInfo info) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        String result = lps.longestPalindromeDP(provider.getString());
        Assertions.assertEquals(result, provider.getLongestPalindromeSubstring());
    }
}
