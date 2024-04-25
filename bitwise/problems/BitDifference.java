package bitwise.problems;

/**
 * You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.
 */
public class BitDifference {

    /**
     * Approach 1
     */
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b) {
        int count = 0;
        while (a > 0 || b > 0) {
            int aLsb = a % 2;
            int bLsb = b % 2;

            if (aLsb != bLsb) {
                count++;
            }

            a = a / 2;
            b = b / 2;
        }

        return count;
    }

    /**
     * Approach 2
     */
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip1(int a, int b) {

        //XOR operation gives set bits only when there are dissimilar bits.
        //We store the value of XOR operation of a and b.
        int ans = a ^ b;

        //returning the number of set bits in resultant.
        return countSetBits(ans);

    }

    //Function to count set bits
    public static int countSetBits(int n) {

        //We use a counter variable.
        int count = 0;
        while (n > 0) {

            //AND operation of n and 1 gives us the rightmost bit.
            //counter variable is increased if we get 1 as the rightmost bit.
            count += n & 1;

            //Right Shift n by 1 to remove the rightmost bit.
            n >>= 1;
        }

        return count;
    }
}
