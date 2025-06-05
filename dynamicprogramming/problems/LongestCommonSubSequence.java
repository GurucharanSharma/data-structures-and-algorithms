package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LongestCommonSubSequence {

    /// Recursive
    public int longestSubsequence(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return 1 + longestSubsequence(str1, str2, m - 1, n - 1);
        } else {
            return Math.max(longestSubsequence(str1, str2, m - 1, n), longestSubsequence(str1, str2, m, n - 1));
        }
    }

    /// Recursive + Memoized
    public int longestSubsequence(String str1, String str2, int m, int n, Integer[][] memory) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (memory[m][n] != null) {
            return memory[m][n];
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            memory[m][n] = 1 + longestSubsequence(str1, str2, m - 1, n - 1);
        } else {
            memory[m][n] = Math.max(longestSubsequence(str1, str2, m - 1, n), longestSubsequence(str1, str2, m, n - 1));
        }

        return memory[m][n];
    }

    /// Tabulation
    public int longestSubsequence(String str1, String str2) {
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
    class LongestCommonSubsequenceTest {

        LongestCommonSubSequence lcs = new LongestCommonSubSequence();

        @Test
        public void testBasicMatch() {
            String str1 = "ABCBDAB";
            String str2 = "BDCAB";

            assertEquals(4, lcs.longestSubsequence(str1, str2, str1.length(), str2.length()));
            assertEquals(4, lcs.longestSubsequence(str1, str2, str1.length(), str2.length(), new Integer[str1.length() + 1][str2.length() + 1]));
            assertEquals(4, lcs.longestSubsequence(str1, str2));
        }

        @Test
        public void testCompletelyDifferent() {
            String str1 = "ABC";
            String str2 = "XYZ";

            assertEquals(0, lcs.longestSubsequence(str1, str2, str1.length(), str2.length()));
            assertEquals(0, lcs.longestSubsequence(str1, str2, str1.length(), str2.length(), new Integer[str1.length() + 1][str2.length() + 1]));
            assertEquals(0, lcs.longestSubsequence(str1, str2));
        }

        @Test
        public void testOneEmpty() {
            String str1 = "ABC";
            String str2 = "";

            assertEquals(0, lcs.longestSubsequence(str1, str2, str1.length(), 0));
            assertEquals(0, lcs.longestSubsequence(str1, str2, str1.length(), str2.length(), new Integer[str1.length() + 1][str2.length() + 1]));
            assertEquals(0, lcs.longestSubsequence(str1, str2));
        }

        @Test
        public void testBothEmpty() {
            String str1 = "";
            String str2 = "";

            assertEquals(0, lcs.longestSubsequence(str1, str2, 0, 0));
            assertEquals(0, lcs.longestSubsequence(str1, str2, str1.length(), str2.length(), new Integer[str1.length() + 1][str2.length() + 1]));
            assertEquals(0, lcs.longestSubsequence(str1, str2));
        }

        @Test
        public void testIdenticalStrings() {
            String str1 = "ABCDEF";
            String str2 = "ABCDEF";

            assertEquals(6, lcs.longestSubsequence(str1, str2, str1.length(), str2.length()));
            assertEquals(6, lcs.longestSubsequence(str1, str2, str1.length(), str2.length(), new Integer[str1.length() + 1][str2.length() + 1]));
            assertEquals(6, lcs.longestSubsequence(str1, str2));
        }

        @Test
        public void testSubsequenceAtEnd() {
            String str1 = "XYZABC";
            String str2 = "ABC";

            assertEquals(3, lcs.longestSubsequence(str1, str2, str1.length(), str2.length()));
            assertEquals(3, lcs.longestSubsequence(str1, str2, str1.length(), str2.length(), new Integer[str1.length() + 1][str2.length() + 1]));
            assertEquals(3, lcs.longestSubsequence(str1, str2));
        }
    }
}
