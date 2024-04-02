package mathematics.problems;

public class GPTerm {

    public double termOfGP(int A, int B, int N) {
        return A * calculatePower(B / (double) A, N - 1);
    }

    private double calculatePower(double x, int n) {
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
