package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Example:
 * “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 * <p>
 * We have to minimize the partitions.
 */
public class PalindromePartitioning {

    /// Recursive
    public int partitions(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans = partitions(str, i, k) + partitions(str, k + 1, j) + 1;
            res = Math.min(res, ans);
        }

        return res;
    }

    /// Memoization
    public int partitions(String str, int i, int j, Integer[][] memory) {
        if (i >= j) {
            return 0;
        }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        if (memory[i][j] != null) {
            return memory[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans = partitions(str, i, k, memory) + partitions(str, k + 1, j, memory) + 1;
            res = Math.min(res, ans);
        }

        memory[i][j] = res;
        return res;
    }

    /// Memoization (Optimised)
    public int partitions1(String str, int i, int j, Integer[][] memory) {
        if (i >= j) {
            return 0;
        }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        if (memory[i][j] != null) {
            return memory[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (memory[i][k] == null) {
                memory[i][k] = partitions1(str, i, k, memory);
            }

            if (memory[k + 1][j] == null) {
                memory[k + 1][j] = partitions1(str, k + 1, j, memory);
            }

            int ans = memory[i][k] + memory[k + 1][j] + 1;
            res = Math.min(res, ans);
        }

        memory[i][j] = res;
        return res;
    }

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    @Nested
    class PalindromePartitioningTest {

        PalindromePartitioning solver = new PalindromePartitioning();

        @Test
        public void testSingleCharacter() {
            String str = "a";
            assertEquals(0, solver.partitions(str, 0, str.length() - 1));
            assertEquals(0, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(0, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }

        @Test
        public void testPalindromeString() {
            String str = "aba";
            assertEquals(0, solver.partitions(str, 0, str.length() - 1));
            assertEquals(0, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(0, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }

        @Test
        public void testNonPalindrome() {
            String str = "abc";
            assertEquals(2, solver.partitions(str, 0, str.length() - 1));
            assertEquals(2, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(2, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }

        @Test
        public void testMixedString() {
            String str = "aab";
            assertEquals(1, solver.partitions(str, 0, str.length() - 1)); // "aa" | "b"
            assertEquals(1, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(1, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }

        @Test
        public void testExampleFromComment() {
            String str = "ababbbabbababa";
            assertEquals(3, solver.partitions(str, 0, str.length() - 1)); // as per typical optimal cuts
            assertEquals(3, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(3, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }

        @Test
        public void testEmptyString() {
            String str = "";
            assertEquals(0, solver.partitions(str, 0, str.length() - 1));
            assertEquals(0, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(0, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }

        @Test
        public void testVeryComplexCase() {
            String str = "noonmadamnooncivicradar";
            // "noonmadamnoon" | "civic" | "radar" (2 partitions)

//            assertEquals(2, solver.partitions(str, 0, str.length() - 1));
            assertEquals(2, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(2, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }

        @Test
        public void testMemoizationOptimizationImpact() {
            String str = "abacdgfdcabaefghhgfeaabacdgfdcabaefghhgfea";

//            assertEquals(12, solver.partitions(str, 0, str.length() - 1));
//            assertEquals(12, solver.partitions(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
            assertEquals(12, solver.partitions1(str, 0, str.length() - 1, new Integer[str.length()][str.length()]));
        }
    }
}
