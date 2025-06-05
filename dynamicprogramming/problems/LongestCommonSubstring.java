package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LongestCommonSubstring {

    /// Recursion
    public int longestSubstring(String str1, String str2) {
        return longestSubstring(str1, str2, str1.length(), str2.length(), 0);
    }

    private int longestSubstring(String str1, String str2, int m, int n, int count) {
        if (m == 0 || n == 0) {
            return count;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            count = longestSubstring(str1, str2, m - 1, n - 1, count + 1);
        }

        int lCount = longestSubstring(str1, str2, m - 1, n, 0);
        int rCount = longestSubstring(str1, str2, m, n - 1, 0);

        return Math.max(count, Math.max(lCount, rCount));
    }

    /// Tabulation
    public int longestSubstring1(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            table[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            table[0][i] = 0;
        }

        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                    max = Math.max(max, table[i][j]);
                } else {
                    table[i][j] = 0;
                }
            }
        }

        return max;
    }

    @Nested
    class LongestCommonSubstringTest {

        LongestCommonSubstring lcs = new LongestCommonSubstring();

        @Test
        public void testFullMatchAtEnd() {
            String str1 = "abcde";
            String str2 = "cde";
            assertEquals(3, lcs.longestSubstring(str1, str2));
            assertEquals(3, lcs.longestSubstring1(str1, str2));
        }

        @Test
        public void testPartialMatchAtEnd() {
            String str1 = "abcde";
            String str2 = "xyzde";
            assertEquals(2, lcs.longestSubstring(str1, str2));
            assertEquals(2, lcs.longestSubstring1(str1, str2));
        }

        @Test
        public void testSingleCharacterMatch() {
            String str1 = "hello";
            String str2 = "piano";
            assertEquals(1, lcs.longestSubstring(str1, str2));
            assertEquals(1, lcs.longestSubstring1(str1, str2));
        }

        @Test
        public void testNoMatch() {
            String str1 = "abc";
            String str2 = "def";
            assertEquals(0, lcs.longestSubstring(str1, str2));
            assertEquals(0, lcs.longestSubstring1(str1, str2));
        }

        @Test
        public void testEmptyStrings() {
            String str1 = "";
            String str2 = "";
            assertEquals(0, lcs.longestSubstring(str1, str2));
            assertEquals(0, lcs.longestSubstring1(str1, str2));
        }

        @Test
        public void testMatchNotAtEnd() {
            String str1 = "abcdef";
            String str2 = "xyzcde";
            assertEquals(3, lcs.longestSubstring(str1, str2));
            assertEquals(3, lcs.longestSubstring1(str1, str2));
        }

        @Test
        public void testMatchAtBeginning() {
            String str1 = "GeeksforGeeks";
            String str2 = "GeeksQuiz";
            assertEquals(5, lcs.longestSubstring(str1, str2));
            assertEquals(5, lcs.longestSubstring1(str1, str2));
        }
    }
}