package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PrintLongestCommonSubSequence {

    public String printLongestSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] table = longestSubsequence(str1, str2);
        StringBuilder builder = new StringBuilder();

        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                builder.append(str1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (table[m - 1][n] > table[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }
            }
        }

        return builder.reverse().toString();
    }

    private int[][] longestSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
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

        return table;
    }

    @Nested
    class PrintLongestCommonSubsequenceTest {

        PrintLongestCommonSubSequence solver = new PrintLongestCommonSubSequence();

        @Test
        public void testCommonSubsequence() {
            String str1 = "abcde";
            String str2 = "ace";
            assertEquals("ace", solver.printLongestSubsequence(str1, str2));
        }

        @Test
        public void testIdenticalStrings() {
            String str1 = "abc";
            String str2 = "abc";
            assertEquals("abc", solver.printLongestSubsequence(str1, str2));
        }

        @Test
        public void testNoCommonSubsequence() {
            String str1 = "abc";
            String str2 = "def";
            assertEquals("", solver.printLongestSubsequence(str1, str2));
        }

        @Test
        public void testOneEmptyString() {
            String str1 = "";
            String str2 = "abc";
            assertEquals("", solver.printLongestSubsequence(str1, str2));
        }

        @Test
        public void testBothEmptyStrings() {
            String str1 = "";
            String str2 = "";
            assertEquals("", solver.printLongestSubsequence(str1, str2));
        }

        @Test
        public void testRepeatedCharacters() {
            String str1 = "aab";
            String str2 = "azb";
            assertEquals("ab", solver.printLongestSubsequence(str1, str2));
        }
    }
}
