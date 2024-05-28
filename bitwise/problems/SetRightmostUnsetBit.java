package bitwise.problems;

/**
 * Given a non-negative number N. The problem is to set the rightmost unset bit in the binary representation of N. If there are no unset bits, then
 * just leave the number as it is.
 */
public class SetRightmostUnsetBit {

    public static int setBit(int N) {
        if ((N & (N + 1)) == 0) {
            return N;
        }

        return (N | (N + 1));
    }
}
