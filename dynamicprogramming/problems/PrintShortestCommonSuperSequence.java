package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest supersequence exists, print any
 * one of them.
 * <p>
 * Examples:
 * <p>
 * Input: X = "AGGTAB",  Y = "GXTXAYB" Output: "AGXGTXAYB" OR "AGGXTXAYB" OR Any string that represents shortest supersequence of X and Y
 * <p>
 * Input: X = "HELLO",  Y = "GEEK" Output: "GEHEKLLO" OR "GHEEKLLO" OR Any string that represents shortest supersequence of X and Y
 */
public class PrintShortestCommonSuperSequence {

    public String shortestSuperSequence(String str1, String str2) {
        int[][] table = longestSubSequence(str1, str2);

        for (int[] ints : table) {
            System.out.println(Arrays.toString(ints));
        }

        int m = str1.length(), n = str2.length();
        StringBuilder builder = new StringBuilder();

        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                builder.append(str1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (table[m - 1][n] > table[m][n - 1]) {
                    builder.append(str1.charAt(m - 1));
                    m--;
                } else {
                    builder.append(str2.charAt(n - 1));
                    n--;
                }
            }
        }

        while (m > 0) {
            builder.append(str1.charAt(m - 1));
            m--;
        }

        while (n > 0) {
            builder.append(str2.charAt(n - 1));
            n--;
        }

        return builder.reverse().toString();
    }

    private int[][] longestSubSequence(String str1, String str2) {
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

        return table;
    }

    @Nested
    class PrintShortestCommonSuperSequenceTest {

        PrintShortestCommonSuperSequence solver = new PrintShortestCommonSuperSequence();

        @Test
        public void testCommonCharacters() {
            String str1 = "abac";
            String str2 = "cab";
            assertEquals("cabac", solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testIdenticalStrings() {
            String str1 = "abc";
            String str2 = "abc";
            assertEquals("abc", solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testNoCommonCharacters() {
            String str1 = "abc";
            String str2 = "def";
            assertEquals("abcdef", solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testOneEmptyString() {
            String str1 = "";
            String str2 = "abc";
            assertEquals("abc", solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testBothEmptyStrings() {
            String str1 = "";
            String str2 = "";
            assertEquals("", solver.shortestSuperSequence(str1, str2));
        }

        @Test
        public void testPartialOverlap() {
            String str1 = "geek";
            String str2 = "eke";
            assertEquals("geeke", solver.shortestSuperSequence(str1, str2));
        }
    }
}