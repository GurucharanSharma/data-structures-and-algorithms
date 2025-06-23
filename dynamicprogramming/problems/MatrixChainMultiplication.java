package dynamicprogramming.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to  perform the
 * multiplications, but merely to decide in which order to perform the multiplications.
 */
public class MatrixChainMultiplication {

    /// Recursive 1
    public int matrixMultiplication(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans = matrixMultiplication(arr, i, k) + matrixMultiplication(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            res = Math.min(ans, res);
        }

        return res;
    }

    /// Recursive 2
    public int matrixMultiplication1(int[] arr, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int ans = matrixMultiplication1(arr, i, k) + matrixMultiplication1(arr, k, j) + (arr[i] * arr[k] * arr[j]);
            res = Math.min(ans, res);
        }

        return res;
    }

    /// Recursive 3
    public int matrixMultiplication2(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k <= j; k++) {
            int ans = matrixMultiplication2(arr, i, k - 1) + matrixMultiplication2(arr, k, j) + (arr[i] * arr[k] * arr[j + 1]);
            res = Math.min(ans, res);
        }

        return res;
    }

    /// Memoization 1
    public int matrixMultiplication(int[] arr, int i, int j, Integer[][] table) {
        if (i >= j) {
            return 0;
        }

        if (table[i][j] != null) {
            return table[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans = matrixMultiplication(arr, i, k) + matrixMultiplication(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            res = Math.min(ans, res);
        }

        table[i][j] = res;
        return res;
    }

    // Memoization 2
    public int matrixMultiplication1(int[] arr, int i, int j, Integer[][] table) {
        if (i + 1 == j) {
            return 0;
        }

        if (table[i][j] != null) {
            return table[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int ans = matrixMultiplication1(arr, i, k, table) + matrixMultiplication1(arr, k, j, table) + (arr[i] * arr[k] * arr[j]);
            res = Math.min(ans, res);
        }

        table[i][j] = res;
        return res;
    }

    @Nested
    class MatrixChainMultiplicationTest {

        MatrixChainMultiplication solver = new MatrixChainMultiplication();

        @Test
        public void testTwoMatrices() {
            int[] arr = {10, 20, 30}; // One multiplication: (10x20)*(20x30)
            assertEquals(6000, solver.matrixMultiplication(arr, 1, arr.length - 1));
            assertEquals(6000, solver.matrixMultiplication1(arr, 0, arr.length - 1));
            assertEquals(6000, solver.matrixMultiplication2(arr, 0, arr.length - 2));

            Integer[][] table = new Integer[arr.length][arr.length];
            assertEquals(6000, solver.matrixMultiplication1(arr, 0, arr.length - 1, table));
        }

        @Test
        public void testThreeMatrices() {
            int[] arr = {40, 20, 30, 10, 30};
            assertEquals(26000, solver.matrixMultiplication(arr, 1, arr.length - 1));
            assertEquals(26000, solver.matrixMultiplication1(arr, 0, arr.length - 1));
            assertEquals(26000, solver.matrixMultiplication2(arr, 0, arr.length - 2));

            Integer[][] table = new Integer[arr.length][arr.length];
            assertEquals(26000, solver.matrixMultiplication1(arr, 0, arr.length - 1, table));
        }

        @Test
        public void testSingleMatrix() {
            int[] arr = {10, 20};
            assertEquals(0, solver.matrixMultiplication(arr, 1, 1));
            assertEquals(0, solver.matrixMultiplication1(arr, 0, arr.length - 1));
            assertEquals(0, solver.matrixMultiplication2(arr, 0, arr.length - 2));

            Integer[][] table = new Integer[arr.length][arr.length];
            assertEquals(0, solver.matrixMultiplication1(arr, 0, arr.length - 1, table));
        }

        @Test
        public void testComplexCase() {
            int[] arr = {10, 20, 30, 40, 30};
            assertEquals(30000, solver.matrixMultiplication(arr, 1, arr.length - 1));
            assertEquals(30000, solver.matrixMultiplication1(arr, 0, arr.length - 1));
            assertEquals(30000, solver.matrixMultiplication2(arr, 0, arr.length - 2));

            Integer[][] table = new Integer[arr.length][arr.length];
            assertEquals(30000, solver.matrixMultiplication1(arr, 0, arr.length - 1, table));
        }

        @Test
        public void testLargerChain() {
            int[] arr = {5, 10, 3, 12, 5, 50, 6};
            assertEquals(2010, solver.matrixMultiplication(arr, 1, arr.length - 1));
            assertEquals(2010, solver.matrixMultiplication1(arr, 0, arr.length - 1));
            assertEquals(2010, solver.matrixMultiplication2(arr, 0, arr.length - 2));

            Integer[][] table = new Integer[arr.length][arr.length];
            assertEquals(2010, solver.matrixMultiplication1(arr, 0, arr.length - 1, table));
        }
    }
}