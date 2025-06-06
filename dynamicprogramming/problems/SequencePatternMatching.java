package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1: Input: s = "abc", t = "ahbgdc" Output: true
 * <p>
 * Example 2: Input: s = "axc", t = "ahbgdc" Output: false
 */
public class SequencePatternMatching {

    public boolean isSubSequence(String seq, String input) {
        return longestSubsequence(seq, input) == seq.length();
    }

    private int longestSubsequence(String str1, String str2) {
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
    class SequencePatternMatchingTest {

        SequencePatternMatching matcher = new SequencePatternMatching();

        @Test
        public void testSubsequenceTrue() {
            String seq = "abc";
            String input = "ahbgdc";
            assertTrue(matcher.isSubSequence(seq, input));
        }

        @Test
        public void testSubsequenceFalse() {
            String seq = "axc";
            String input = "ahbgdc";
            assertFalse(matcher.isSubSequence(seq, input));
        }

        @Test
        public void testEmptySeq() {
            String seq = "";
            String input = "ahbgdc";
            assertTrue(matcher.isSubSequence(seq, input));
        }

        @Test
        public void testEmptyInput() {
            String seq = "abc";
            String input = "";
            assertFalse(matcher.isSubSequence(seq, input));
        }

        @Test
        public void testIdenticalStrings() {
            String seq = "abc";
            String input = "abc";
            assertTrue(matcher.isSubSequence(seq, input));
        }

        @Test
        public void testNonContinuousSubsequence() {
            String seq = "ace";
            String input = "abcde";
            assertTrue(matcher.isSubSequence(seq, input));
        }

        @Test
        public void testIncorrectOrder() {
            String seq = "aec";
            String input = "abcde";
            assertFalse(matcher.isSubSequence(seq, input));
        }
    }
}
