package ch01.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class LcsArgumentProvider implements ArgumentsProvider {

    TestElements[] testElements;

    public LcsArgumentProvider() {

        testElements = new TestElements[3];
        testElements[0] = new TestElements("ABCDGH", "AEDFHR", 3);
        testElements[1] = new TestElements("AGGTAB", "GXTXAYB", 4);
        testElements[2] = new TestElements("abdace", "babce", 4);
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Arrays.stream(testElements).map(Arguments::of);
    }

    public class TestElements {

        private String seq1;
        private String seq2;
        private int lcs;

        public TestElements(String seq1, String seq2, int lcs) {
            this.seq1 = seq1;
            this.seq2 = seq2;
            this.lcs = lcs;
        }

        public String getSeq1() {
            return seq1;
        }
        public String getSeq2() {
            return seq2;
        }
        public int getLcs() {
            return lcs;
        }
    }
}
