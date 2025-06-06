package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * <b>Problem Statement 1</b>
 * <p>
 * Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is
 * palindrome. Examples :
 * <p>
 * Input : aebcbda Output : 2 Remove characters 'e' and 'd' Resultant string will be 'abcba' which is a palindromic string
 * <p>
 * <b>Problem Statement 2</b>
 * <p>
 * Given a string, find the minimum number of characters to be inserted to form Palindrome string out of given string
 * <p>
 * Examples: ab: Number of insertions required is 1. bab aa: Number of insertions required is 0. aa
 */
public class MinimumInsertionsDeletionsToPalindrome {

    public int minimumDeletions(String str) {
        return str.length() - longestPalindromicSubSequence(str);
    }

    public int minimumInsertions(String str) {
        // The minimum number of insertions = minimum number of deletions.
        return str.length() - longestPalindromicSubSequence(str);
    }

    private int longestPalindromicSubSequence(String str) {
        return longestSubSequence(str, new StringBuilder(str).reverse().toString());
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
    class MinimumDeletionsToPalindromeTest {

        MinimumInsertionsDeletionsToPalindrome solver = new MinimumInsertionsDeletionsToPalindrome();

        @Test
        public void testAlreadyPalindrome() {
            String input = "racecar";
            assertEquals(0, solver.minimumDeletions(input));
        }

        @Test
        public void testSingleCharacter() {
            String input = "a";
            assertEquals(0, solver.minimumDeletions(input));
        }

        @Test
        public void testEmptyString() {
            String input = "";
            assertEquals(0, solver.minimumDeletions(input));
        }

        @Test
        public void testSimpleCase() {
            String input = "abcda";
            assertEquals(2, solver.minimumDeletions(input)); // Remove 'b' and 'c'
        }

        @Test
        public void testAllDifferentCharacters() {
            String input = "abcd";
            assertEquals(3, solver.minimumDeletions(input));
        }

        @Test
        public void testPalindromeWithExtraChar() {
            String input = "abcbda";
            assertEquals(1, solver.minimumDeletions(input));
        }
    }
}
