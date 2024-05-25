package bitwise.problems;

public class SwapOddAndEvenBits {

    //Function to swap odd and even bits.
    public static int swapBits(int n) {
        // Masks for even and odd bits
        int EVEN_MASK = 0xAAAAAAAA; // binary 10101010101010101010101010101010
        int ODD_MASK = 0x55555555;  // binary 01010101010101010101010101010101

        // Extract even bits and shift right
        int evenBits = (n & EVEN_MASK) >> 1;

        // Extract odd bits and shift left
        int oddBits = (n & ODD_MASK) << 1;

        // Combine the shifted bits
        return evenBits | oddBits;
    }
}
