package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * <pre><code>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of A = “great”:
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that “rgeat” is a scrambled string of “great”.
 *
 * Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that “rgtae” is a scrambled string of “great”.
 * </code></pre>
 */
public class ScrambledString {

    /// Recursive
    public boolean isScrambled(String input, String scrambled) {
        if (input.isEmpty() && scrambled.isEmpty()) {
            return true;
        } else if (input.length() != scrambled.length()) {
            return false;
        } else if (input.equals(scrambled)) {
            return true;
        }

        int n = input.length();

        // Swapped
        for (int i = 1; i < n; i++) {
            if (isScrambled(input.substring(0, i), scrambled.substring(n - i)) && isScrambled(input.substring(n - i), scrambled.substring(0, i))) {
                return true;
            }

            if (isScrambled(input.substring(0, i), scrambled.substring(0, i)) && isScrambled(input.substring(i), scrambled.substring(i))) {
                return true;
            }
        }

        return false;
    }

    /// Memoization
    public boolean isScrambled(String input, String scrambled, Map<String, Boolean> memory) {
        if (input.isEmpty() && scrambled.isEmpty()) {
            return true;
        } else if (input.length() != scrambled.length()) {
            return false;
        } else if (input.equals(scrambled)) {
            return true;
        }

        String key = input + "-" + scrambled;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        int n = input.length();
        boolean result = false;

        for (int i = 1; i < n; i++) {
            if (isScrambled(input.substring(0, i), scrambled.substring(n - i), memory) &&
                isScrambled(input.substring(n - i), scrambled.substring(0, i), memory)) {
                result = true;
                break;
            }

            if (isScrambled(input.substring(0, i), scrambled.substring(0, i), memory) &&
                isScrambled(input.substring(i), scrambled.substring(i), memory)) {
                result = true;
                break;
            }
        }

        memory.put(key, result);
        return result;
    }

    @Nested
    class ScrambledStringTest {

        ScrambledString solver = new ScrambledString();

        @Test
        public void testExactMatch() {
            assertTrue(solver.isScrambled("great", "great"));
            assertTrue(solver.isScrambled("great", "great", new java.util.HashMap<>()));
        }

        @Test
        public void testValidScramble() {
            assertTrue(solver.isScrambled("great", "rgeat"));
            assertTrue(solver.isScrambled("great", "rgeat", new java.util.HashMap<>()));
            assertTrue(solver.isScrambled("great", "rgtae"));
            assertTrue(solver.isScrambled("great", "rgtae", new java.util.HashMap<>()));
        }

        @Test
        public void testInvalidScramble() {
            assertFalse(solver.isScrambled("great", "grate"));
            assertFalse(solver.isScrambled("great", "grate", new java.util.HashMap<>()));
            assertFalse(solver.isScrambled("abcde", "caebd"));
            assertFalse(solver.isScrambled("abcde", "caebd", new java.util.HashMap<>()));
        }

        @Test
        public void testEmptyStrings() {
            assertTrue(solver.isScrambled("", ""));
            assertTrue(solver.isScrambled("", "", new java.util.HashMap<>()));
        }

        @Test
        public void testOneEmptyString() {
            assertFalse(solver.isScrambled("abc", ""));
            assertFalse(solver.isScrambled("abc", "", new java.util.HashMap<>()));
            assertFalse(solver.isScrambled("", "abc"));
            assertFalse(solver.isScrambled("", "abc", new java.util.HashMap<>()));
        }

        @Test
        public void testSingleCharacter() {
            assertTrue(solver.isScrambled("a", "a"));
            assertTrue(solver.isScrambled("a", "a", new java.util.HashMap<>()));
            assertFalse(solver.isScrambled("a", "b"));
            assertFalse(solver.isScrambled("a", "b", new java.util.HashMap<>()));
        }

        @Test
        public void testPerformanceComparison() {
            String s1 = "greatgreatgreatgreatgreatgreatgreatgreatgreatgreat";
            String s2 = "rgtaergtaegreatgreatreatgrgtaergtaegreatgreatreatg";

            long start1 = System.currentTimeMillis();
            boolean res1 = solver.isScrambled(s1, s2);
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            boolean res2 = solver.isScrambled(s1, s2, new java.util.HashMap<>());
            long end2 = System.currentTimeMillis();

            Assertions.assertEquals(res1, res2);
            System.out.println("Recursive time (ms): " + (end1 - start1));
            System.out.println("Memoized time  (ms): " + (end2 - start2));
        }
    }
}