package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ShortestCommonSuperSequence {

    public int shortestSuperSequence(String str1, String str2) {
        int subSequenceLen = longestSubSequence(str1, str2);
        return str1.length() + str2.length() - subSequenceLen;
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
    class ShortestCommonSuperSequenceTest {

        ShortestCommonSuperSequence solver = new ShortestCommonSuperSequence();

        @Test
        public void testCommonCharacters() {
            String str1 = "abac";
            String str2 = "cab";
            assertEquals(5, solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testIdenticalStrings() {
            String str1 = "abc";
            String str2 = "abc";
            assertEquals(3, solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testCompletelyDifferent() {
            String str1 = "abc";
            String str2 = "def";
            assertEquals(6, solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testOneEmptyString() {
            String str1 = "";
            String str2 = "abc";
            assertEquals(3, solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testBothEmptyStrings() {
            String str1 = "";
            String str2 = "";
            assertEquals(0, solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testPartialOverlap() {
            String str1 = "geek";
            String str2 = "eke";
            assertEquals(5, solver.shortestSuperSequence(str1, str2));
        }
    }
}
