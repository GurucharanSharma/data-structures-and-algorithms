package recursion.lectures;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial(3, 1));
    }

    // It is a normal recursion.
    static int factorial(int n) {
        if (n <= 0) return 1;

        return n * factorial(n - 1);
    }

    // It is tail recursion as the last statement is the recursive method call.
    static int factorial(int n, int k) {
        if (n <= 0) return k;

        return factorial(n - 1, k * n);
    }
}
