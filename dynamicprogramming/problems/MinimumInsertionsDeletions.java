package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MinimumInsertionsDeletions {

    public void minimumInsertionsDeletions(String source, String target) {
        int lcsLen = longestSubSequence(source, target);

        System.out.println("# of deletions = " + (source.length() - lcsLen));
        System.out.println("# of insertions = " + (target.length() - lcsLen));
    }

    private int longestSubSequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            table[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            table[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return table[m][n];
    }

    @Nested
    class MinimumInsertionsDeletionsTest {

        @Test
        public void testBasicTransformation() {
            String source = "heap";
            String target = "pea";
            String expectedDeletions = "# of deletions = 2";
            String expectedInsertions = "# of insertions = 1";
            assertOutput(source, target, expectedDeletions, expectedInsertions);
        }

        @Test
        public void testIdenticalStrings() {
            String source = "abc";
            String target = "abc";
            String expectedDeletions = "# of deletions = 0";
            String expectedInsertions = "# of insertions = 0";
            assertOutput(source, target, expectedDeletions, expectedInsertions);
        }

        @Test
        public void testNoCommonSubsequence() {
            String source = "abc";
            String target = "def";
            String expectedDeletions = "# of deletions = 3";
            String expectedInsertions = "# of insertions = 3";
            assertOutput(source, target, expectedDeletions, expectedInsertions);
        }

        @Test
        public void testEmptySource() {
            String source = "";
            String target = "abc";
            String expectedDeletions = "# of deletions = 0";
            String expectedInsertions = "# of insertions = 3";
            assertOutput(source, target, expectedDeletions, expectedInsertions);
        }

        @Test
        public void testEmptyTarget() {
            String source = "abc";
            String target = "";
            String expectedDeletions = "# of deletions = 3";
            String expectedInsertions = "# of insertions = 0";
            assertOutput(source, target, expectedDeletions, expectedInsertions);
        }

        @Test
        public void testDeletions() {
            String source = "geeksforgeeks";
            String target = "geeks";
            String expectedDeletions = "# of deletions = 8";
            String expectedInsertions = "# of insertions = 0";
            assertOutput(source, target, expectedDeletions, expectedInsertions);
        }

        private void assertOutput(String source, String target, String expectedDeletions, String expectedInsertions) {
            MinimumInsertionsDeletions solver = new MinimumInsertionsDeletions();

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            solver.minimumInsertionsDeletions(source, target);

            String output = outContent.toString().trim();
            assertTrue(output.contains(expectedDeletions), "Missing expected deletions output");
            assertTrue(output.contains(expectedInsertions), "Missing expected insertions output");

            System.setOut(originalOut); // reset output
        }
    }
}
