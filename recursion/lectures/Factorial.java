package recursion.lectures;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorialTail(3, 1));
    }

    static int factorial(int n) {
        if (n <= 0) return 1;

        return n * factorial(n - 1);
    }

    static int factorialTail(int n, int k) {
        if (n <= 0) return k;

        return factorialTail(n - 1, k * n);
    }
}
