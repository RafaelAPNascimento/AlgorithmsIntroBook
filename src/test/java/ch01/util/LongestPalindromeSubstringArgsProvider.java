package ch01.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class LongestPalindromeSubstringArgsProvider implements ArgumentsProvider {

    TestElements[] testElements;

    public LongestPalindromeSubstringArgsProvider() {
        testElements = new TestElements[6];
        testElements[0] = new TestElements("findnitianhere", "indni");
        testElements[1] = new TestElements("forgeeksskeegfor", "geeksskeeg");
        testElements[2] = new TestElements("Geeks", "ee");
        testElements[3] = new TestElements("bananas", "anana");
        testElements[4] = new TestElements("abdcbcdbdcbbc", "bdcbcdb");
        testElements[5] = new TestElements("mojologiccigolmojo", "logiccigol");
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Arrays.stream(testElements).map(Arguments::of);
    }

    public class TestElements {

        private String string;
        private String longestPalindromeSubstring;

        public TestElements(String string, String longestPalindromeSubstring) {
            this.string = string;
            this.longestPalindromeSubstring = longestPalindromeSubstring;
        }

        public String getString() {
            return string;
        }

        public String getLongestPalindromeSubstring() {
            return longestPalindromeSubstring;
        }
    }
}
