package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * <pre><code>
 * Given a boolean expression with the following symbols:
 *
 * Symbols:
 *     'T' --- true
 *     'F' --- false
 *
 * Operators (filled between symbols):
 *     &   --- boolean AND
 *     |   --- boolean OR
 *     ^   --- boolean XOR
 *
 * Task:
 *     Count the number of ways we can parenthesize the expression so that the
 *     value of the expression evaluates to true.
 *
 * Example:
 *     Input:  symbol[]   = {T, F, T}
 *             operator[] = {^, &}
 *     Output: 2
 *
 * Explanation:
 *     The given expression is "T ^ F & T". It evaluates to true in two ways:
 *       1. ((T ^ F) & T)
 *       2. (T ^ (F & T))
 * </code></pre>
 */
public class EvaluateTrue {

    /// Recursive
    public int evaluateTrue(String str, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            if (isTrue) {
                return str.charAt(i) == 'T' ? 1 : 0;
            } else {
                return str.charAt(i) == 'F' ? 1 : 0;
            }
        }

        int count = 0;
        for (int k = i + 1; k <= j; k = k + 2) {
            int leftTrue = evaluateTrue(str, i, k - 1, true);
            int leftFalse = evaluateTrue(str, i, k - 1, false);
            int rightTrue = evaluateTrue(str, k + 1, j, true);
            int rightFalse = evaluateTrue(str, k + 1, j, false);

            char operator = str.charAt(k);

            switch (operator) {
                case '&':
                    if (isTrue) {
                        count += (leftTrue * rightTrue);
                    } else {
                        count += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                    }
                    break;
                case '|':
                    if (isTrue) {
                        count += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                    } else {
                        count += (leftFalse * rightFalse);
                    }
                    break;
                case '^':
                    if (isTrue) {
                        count += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    } else {
                        count += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                    }
                    break;
            }
        }

        return count;
    }

    /// Memoization
    public int evaluateTrue(String str, int i, int j, boolean isTrue, Map<String, Integer> memory) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            if (isTrue) {
                return str.charAt(i) == 'T' ? 1 : 0;
            } else {
                return str.charAt(i) == 'F' ? 1 : 0;
            }
        }

        String key = i + "-" + j + "-" + isTrue;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        int count = 0;
        for (int k = i + 1; k <= j; k += 2) {
            int leftTrue = evaluateTrue(str, i, k - 1, true, memory);
            int leftFalse = evaluateTrue(str, i, k - 1, false, memory);
            int rightTrue = evaluateTrue(str, k + 1, j, true, memory);
            int rightFalse = evaluateTrue(str, k + 1, j, false, memory);

            char operator = str.charAt(k);
            switch (operator) {
                case '&':
                    if (isTrue) {
                        count += (leftTrue * rightTrue);
                    } else {
                        count += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                    }
                    break;
                case '|':
                    if (isTrue) {
                        count += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                    } else {
                        count += (leftFalse * rightFalse);
                    }
                    break;
                case '^':
                    if (isTrue) {
                        count += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    } else {
                        count += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                    }
                    break;
            }
        }

        memory.put(key, count);
        return count;
    }

    @Nested
    class EvaluateTrueTest {

        EvaluateTrue solver = new EvaluateTrue();

        @Test
        public void testSingleTrueSymbol() {
            String expr = "T";
            assertEquals(1, solver.evaluateTrue(expr, 0, expr.length() - 1, true));
            assertEquals(1, solver.evaluateTrue(expr, 0, expr.length() - 1, true, new HashMap<>()));
        }

        @Test
        public void testSingleFalseSymbol() {
            String expr = "F";
            assertEquals(0, solver.evaluateTrue(expr, 0, expr.length() - 1, true));
            assertEquals(0, solver.evaluateTrue(expr, 0, expr.length() - 1, true, new HashMap<>()));
        }

        @Test
        public void testSimpleExpression1() {
            String expr = "T|F";
            assertEquals(1, solver.evaluateTrue(expr, 0, expr.length() - 1, true));
            assertEquals(1, solver.evaluateTrue(expr, 0, expr.length() - 1, true, new HashMap<>()));
        }

        @Test
        public void testSimpleExpression2() {
            String expr = "T^F";
            assertEquals(1, solver.evaluateTrue(expr, 0, expr.length() - 1, true));
            assertEquals(1, solver.evaluateTrue(expr, 0, expr.length() - 1, true, new HashMap<>()));
        }

        @Test
        public void testSimpleExpression3() {
            String expr = "T^F&T";
            assertEquals(2, solver.evaluateTrue(expr, 0, expr.length() - 1, true));
            assertEquals(2, solver.evaluateTrue(expr, 0, expr.length() - 1, true, new HashMap<>()));
        }

        @Test
        public void testComplexExpression() {
            String expr = "T|T&F^T";
            assertEquals(4, solver.evaluateTrue(expr, 0, expr.length() - 1, true));
            assertEquals(4, solver.evaluateTrue(expr, 0, expr.length() - 1, true, new HashMap<>()));
        }

        @Test
        public void testMemoizationImpact() {
            String expr = "T^F&T|T^F&T|T^F&T|T^F&T|T^F&T"; // long expression
//            assertEquals(1947439, solver.evaluateTrue(expr, 0, expr.length() - 1, true));   // Takes too long
            assertEquals(1947439, solver.evaluateTrue(expr, 0, expr.length() - 1, true, new HashMap<>()));
        }
    }
}
