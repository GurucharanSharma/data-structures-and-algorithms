package mathematics.problems;

public class MultiplicationUnderModulo {

    private static final long MODULO = 1000000007;

    public static long multiplicationUnderModulo(long a, long b) {
        return ((a % MODULO) * (b % MODULO)) % MODULO;
    }
}
