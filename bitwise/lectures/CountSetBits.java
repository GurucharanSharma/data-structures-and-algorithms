package bitwise.lectures;

public class CountSetBits {

    private static final int[] table = new int[256];

    static {
        table[0] = 0;

        for (int i = 1; i <= 255; i++) {
            table[i] = table[i & (i - 1)] + 1;
        }
    }

    /**
     * Approach 1: Lookup Table
     */
    static int countSetBits(int x) {
        return table[x & 255] + table[(x >> 8) & 255] + table[(x >> 16) & 255] + table[x >> 24];
    }

    /**
     * Approach 2: Naive
     */
    private static int countSetBits1(int x) {
        int res = 0;
        while (x != 0) {
            if (x % 2 == 1) {
                res++;
            }

            x = x / 2;
        }

        return res;
    }

    /**
     * Approach 3: Brian and Kerningham Algorithm.
     * <p>
     * We keep making last set bit as 0 until all the set bits are 0.
     */
    private static int countSetBits2(int n) {
        int count = 0;

        while (n > 0) {
            n = n & (n - 1); // This expression makes the last set bit as 0
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int x = 255;
        System.out.println(countSetBits(x));
        System.out.println(countSetBits1(x));
        System.out.println(countSetBits2(x));
    }
}
