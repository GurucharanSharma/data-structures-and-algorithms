package mathematics.problems;

public class AdditionUnderModulo {

    private static final long MODULO = 1000000007;

    public static long sumUnderModulo(long a, long b) {
        return ((a % MODULO) + (b % MODULO)) % MODULO;
    }
}
