package bitwise.problems;

/**
 * You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].
 */
public class FindXOR {

    /**
     * Naive approach
     */
    public static int findXOR(int l, int r) {
        int xor = 0;
        for (int i = l; i <= r; i++) {
            xor = xor ^ i;
        }

        return xor;
    }

    // Function to find XOR of all elements in range [L, R]
    public static int findXOR1(int l, int r) {
        return xorFromZeroTo(r) ^ xorFromZeroTo(l - 1);
    }

    // Function to compute XOR from 0 to n
    private static int xorFromZeroTo(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            default:
                return 0;
        }
    }

}
