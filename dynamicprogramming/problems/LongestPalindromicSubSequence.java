package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LongestPalindromicSubSequence {

    public int longestPalindromicSubSequence(String str) {
        String rev = (new StringBuilder(str).reverse().toString());
        return longestSubSequence(str, rev);
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
    class LongestPalindromicSubSequenceTest {

        LongestPalindromicSubSequence solver = new LongestPalindromicSubSequence();

        @Test
        public void testBasicPalindrome() {
            String input = "bbbab";
            assertEquals(4, solver.longestPalindromicSubSequence(input));
        }

        @Test
        public void testWholePalindrome() {
            String input = "racecar";
            assertEquals(7, solver.longestPalindromicSubSequence(input));
        }

        @Test
        public void testNoPalindrome() {
            String input = "abcd";
            assertEquals(1, solver.longestPalindromicSubSequence(input));
        }

        @Test
        public void testEmptyString() {
            String input = "";
            assertEquals(0, solver.longestPalindromicSubSequence(input));
        }

        @Test
        public void testSingleCharacter() {
            String input = "a";
            assertEquals(1, solver.longestPalindromicSubSequence(input));
        }

        @Test
        public void testRepeatingCharacters() {
            String input = "aaabaaa";
            assertEquals(7, solver.longestPalindromicSubSequence(input));
        }
    }
}
