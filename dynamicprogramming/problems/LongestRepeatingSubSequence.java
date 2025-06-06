package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any
 * i’th character in the two subsequences shouldn’t have the same index in the original string. Example: Input: str = "aab" Output: "a" The two
 * subsequence are 'a'(first) and 'a' (second). Note that 'b' cannot be considered as part of subsequence as it would be at same index in both.
 */
public class LongestRepeatingSubSequence {

    public int longestRepeatingSubSequence(String str) {
        int n = str.length();
        int[][] table = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
            table[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return table[n][n];
    }

    @Nested
    class LongestRepeatingSubSequenceTest {

        LongestRepeatingSubSequence solver = new LongestRepeatingSubSequence();

        @Test
        public void testTypicalCase() {
            String input = "aab";
            assertEquals(1, solver.longestRepeatingSubSequence(input)); // "a" is the repeating subsequence
        }

        @Test
        public void testLongerRepeat() {
            String input = "aabb";
            assertEquals(2, solver.longestRepeatingSubSequence(input)); // "ab" is the repeating subsequence
        }

        @Test
        public void testNoRepeats() {
            String input = "abc";
            assertEquals(0, solver.longestRepeatingSubSequence(input)); // no repeating characters
        }

        @Test
        public void testIdenticalCharacters() {
            String input = "aaaa";
            assertEquals(3, solver.longestRepeatingSubSequence(input)); // "aaa"
        }

        @Test
        public void testEmptyString() {
            String input = "";
            assertEquals(0, solver.longestRepeatingSubSequence(input));
        }

        @Test
        public void testSingleCharacter() {
            String input = "a";
            assertEquals(0, solver.longestRepeatingSubSequence(input));
        }

        @Test
        public void testComplexCase() {
            String input = "axxxy";
            assertEquals(2, solver.longestRepeatingSubSequence(input)); // "xx"
        }
    }
}