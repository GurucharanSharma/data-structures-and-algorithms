package bitwise.problems;

/**
 * Given two numbers M and N. The task is to find the position of the rightmost different bit in the binary representation of numbers. If both M and N
 * are the same then return -1 in this case.
 */
public class RightmostDifferentBit {

    /**
     * Approach 1
     */
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n) {
        int bit = 0;
        while (m > 0 || n > 0) {
            bit++;

            if ((m & -m) != (n & -n)) {
                return bit;
            }

            m = m >> 1;
            n = n >> 1;
        }

        return -1;
    }

    /**
     * Approach 2
     */
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit1(int m, int n) {
        //if numbers are same then -1 is returned.
        if (m == n) {
            return -1;
        }

        //XOR operation only sets the dissimilar bits and unsets similar bits.
        //We do XOR operation on the numbers and return the rightmost set bit.
        return getRightMostSetBit(m ^ n);
    }

    public static int getRightMostSetBit(int n) {
        if (n == 0) {
            return 0;
        }

        //returning the rightmost set bit of a number.
        return (int) (Math.log(n & -n) / Math.log(2.0)) + 1;
    }

}
