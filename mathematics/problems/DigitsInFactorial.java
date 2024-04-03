package mathematics.problems;

public class DigitsInFactorial {

    /**
     * We know, log(a*b) = log(a) + log(b)
     * <p>
     * Therefore log( n! ) = log(1*2*3……. * n) = log(1) + log(2) + …….. +log(n)
     * <p>
     * Now, observe that the floor value of log base 10 increased by 1, of any number, gives the number of digits present in that number. Hence,
     * output would be : floor(log(n!)) + 1.
     */
    public int digitsInFactorial(long N) {
        if (N < 0) {
            return 0;
        }

        if (N <= 1) {
            return 1;
        }

        double sum = 0.0;
        for (int j = 1; j <= N; j++) {
            // sum stores log(j) + log(j+1) + ... + log(N)
            sum += Math.log10(j);
        }

        return (int) (1 + Math.floor(sum));
    }
}
