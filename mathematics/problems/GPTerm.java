package mathematics.problems;

public class GPTerm {

    public static double termOfGP(int A, int B, int N) {
        return A * calculatePower(B / (double) A, N - 1);
    }

    private static double calculatePower(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        double result = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                result = result * x;
            }

            x = x * x;
            n = n / 2;
        }

        return result;
    }
}
