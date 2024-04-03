package recursion.lectures;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(generateFibonacci(3));
    }

    static int generateFibonacci(int n) {
        if (n <= 1) return n;

        return generateFibonacci(n - 1) + generateFibonacci(n - 2);
    }
}
