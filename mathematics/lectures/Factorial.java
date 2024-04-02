package mathematics.lectures;

public class Factorial {

    public static int factorialOfANumber(int n) {
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact = fact * i;
        }

        return fact;
    }

    public static int factorialOfANumber1(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorialOfANumber1(n - 1);
    }
}
