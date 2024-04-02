package mathematics.problems;

public class DigitsInFactorial {

    public int digitsInFactorial(long N) {
        double sum = 0.0;
        for (int j = 1; j <= N; j++) {
            // sum stores log(j) + log(j+1) + ... + log(N)
            sum += Math.log10(j);

        }
        return (int) (1 + Math.floor(sum));
    }
}
