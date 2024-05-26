package bitwise.problems;

/**
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 */
public class CountTotalSetBits {

    private static final int MAX_BIT = 255;
    private static final int[] table = new int[256];

    static {
        table[0] = 0;

        for (int i = 1; i <= 255; i++) {
            table[i] = table[i & (i - 1)] + 1;
        }
    }

    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += (table[i & MAX_BIT] + table[(i >> 8) & MAX_BIT] + table[(i >> 16) & MAX_BIT] + table[(i >> 24)]);
        }

        return count;
    }

    public static int countSetBits1(int n) {

        int[] res = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            res[x] = res[x / 2] + (x % 2);
        }

        int count = 0;
        for (int i = 0; i < res.length; i++) {
            count = count + res[i];
        }

        return count;
    }

    public static int countSetBits2(int n) {
        // Ignoring 0 as all the bits are unset.
        n += 1;
        int count = 0;

        // Counting set bits from 1 to n.
        for (int x = 2; x / 2 < n; x = x * 2) {
            // Total count of pairs of 0s and 1s.
            int quotient = n / x;
            // quotient gives the complete count of pairs of 1s.
            // Multiplying it with the (current power of 2)/2 will give
            // the count of 1s in the current bit.
            count += quotient * x / 2;

            int remainder = n % x;
            // If the count of pairs is odd then we add the remaining 1s
            // which could not be grouped together.
            if (remainder > x / 2) {
                count += remainder - x / 2;
            }
        }

        //returning count of set bits.
        return count;
    }
}
