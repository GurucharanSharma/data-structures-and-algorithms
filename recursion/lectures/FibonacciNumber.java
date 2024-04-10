package recursion.lectures;

import java.util.Arrays;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println("Approach 1");
        System.out.println(generateFibonacci(10));

        System.out.println("Approach 3");
        int sum = 0;
        for (int i: generateFibonacci1(10)) {
            sum = sum + i;
        }
        System.out.println(Arrays.toString(generateFibonacci1(10)));
        System.out.println(sum);
    }

    /**
     * Find nth fibonacci number
     */
    static int generateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return generateFibonacci(n - 1) + generateFibonacci(n - 2);
    }

    /**
     * Generate all n fibonacci numbers
     */
    public static int[] generateFibonacci1(int n) {
        int[] arr = new int[n];
        fillNumbers(arr, 0, 1, n);

        return arr;
    }

    private static void fillNumbers(int[] arr, int first, int second, int n) {
        if (n <= 0) {
            return;
        }

        arr[arr.length - n] = first;
        fillNumbers(arr, first + second, first, --n);
    }
}
