package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * <pre><code>
 * Problem statement: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:
 *
 * If egg breaks at ith floor then it also breaks at all greater floors.
 * If egg does not break at ith floor then it does not break at all lower floors.
 * Unbroken egg can be used again.
 * Note: You have to find minimum trials required to find the critical floor not the critical floor.
 *
 * Example:
 * Input:
 *     4
 *     2
 *
 * Output:
 * Number of trials when number of eggs is 2 and number of floors is 4: 3
 * </code></pre>
 */
public class EggDroppingProblem {

    /// Recursive
    public int findMaxAttempts(int N, int K) {
        if (K <= 0) {
            return -1; // Cannot calculate the attempts with no eggs
        }

        if (N == 0 || N == 1) {
            return N;
        }

        if (K == 1) {
            return N;
        }

        int result = Integer.MAX_VALUE;
        for (int f = 1; f <= N; f++) {
            int attempts = 1 + Math.max(findMaxAttempts(f - 1, K - 1), findMaxAttempts(N - f, K));
            result = Math.min(result, attempts);
        }

        return result;
    }

    /// Memoization + Optimisation
    public int findMaxAttempts(int N, int K, Integer[][] memory) {
        if (K <= 0) {
            return -1;
        }

        if (K == 1) {
            return N;
        }

        if (N == 0 || N == 1) {
            return N;
        }

        if (Objects.nonNull(memory[N][K])) {
            return memory[N][K];
        }

        int result = Integer.MAX_VALUE;
        for (int f = 1; f <= N; f++) {
            if (Objects.isNull(memory[f - 1][K - 1])) {
                memory[f - 1][K - 1] = findMaxAttempts(f - 1, K - 1, memory);
            }

            if (Objects.isNull(memory[N - f][K])) {
                memory[N - f][K] = findMaxAttempts(N - f, K, memory);
            }

            int attempt = Math.max(memory[f - 1][K - 1], memory[N - f][K]) + 1;
            result = Math.min(result, attempt);
        }

        memory[N][K] = result;
        return result;
    }

    @Nested
    class EggDroppingProblemTest {

        EggDroppingProblem solver = new EggDroppingProblem();

        @Test
        public void testZeroEggs() {
            int N = 10, K = 0;
            assertEquals(-1, solver.findMaxAttempts(N, K));
            Integer[][] memory = new Integer[N + 1][K + 1];
            assertEquals(-1, solver.findMaxAttempts(N, K, memory));
        }

        @Test
        public void testNegativeEggs() {
            int N = 5, K = -2;
            assertEquals(-1, solver.findMaxAttempts(N, K));
            Integer[][] memory = new Integer[N + 1][0]; // K cannot be negative
            assertEquals(-1, solver.findMaxAttempts(N, K, memory));
        }

        @Test
        public void testZeroFloors() {
            int N = 0, K = 2;
            assertEquals(0, solver.findMaxAttempts(N, K));
            Integer[][] memory = new Integer[N + 1][K + 1];
            assertEquals(0, solver.findMaxAttempts(N, K, memory));
        }

        @Test
        public void testOneFloor() {
            int N = 1, K = 2;
            assertEquals(1, solver.findMaxAttempts(N, K));
            Integer[][] memory = new Integer[N + 1][K + 1];
            assertEquals(1, solver.findMaxAttempts(N, K, memory));
        }

        @Test
        public void testOneEgg() {
            int N = 5, K = 1;
            assertEquals(5, solver.findMaxAttempts(N, K));
            Integer[][] memory = new Integer[N + 1][K + 1];
            assertEquals(5, solver.findMaxAttempts(N, K, memory));
        }

        @Test
        public void testTwoEggsFourFloors() {
            int N = 4, K = 2;
            assertEquals(3, solver.findMaxAttempts(N, K));
            Integer[][] memory = new Integer[N + 1][K + 1];
            assertEquals(3, solver.findMaxAttempts(N, K, memory));
        }

        @Test
        public void testTwoEggsTenFloors() {
            int N = 10, K = 2;
            assertEquals(4, solver.findMaxAttempts(N, K));
            Integer[][] memory = new Integer[N + 1][K + 1];
            assertEquals(4, solver.findMaxAttempts(N, K, memory));
        }
    }
}