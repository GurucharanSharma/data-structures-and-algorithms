package bitwise.problems;

/**
 * Given an integer N. The task is to return the position of first set bit found from the right side in the binary representation of the number.
 * <p>
 * Note: If there is no set bit in the integer N, then return 0 from the function.
 */
public class FindFirstSetBit {

    public static int getFirstSetBit(int n) {
        int pos = 0;
        while (n > 0) {
            pos++;
            if ((n & 1) == 1) {
                return pos;
            }
            n = n >> 1;
        }

        return 0;
    }
}
