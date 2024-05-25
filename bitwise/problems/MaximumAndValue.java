package bitwise.problems;

public class MaximumAndValue {

    /**
     * Approach 1: Function for finding maximum AND value.
     */
    public static int maxAND(int[] arr, int N) {
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                res = Math.max(calculateAnd(arr[i], arr[j]), res);
            }
        }

        return res;
    }

    private static int calculateAnd(int i, int j) {
        return i & j;
    }

    /**
     * Approach 2: Function to find the maximum AND value generated by any pair.
     * <p>
     * Why use result | (1 << bit)?
     * <p>
     * The reason we use result | (1 << bit) is to incrementally build the maximum AND value by considering each bit from
     * the most significant to the least significant. Here's the logic:
     * <p>
     * Start with Zero: Initially, result is set to 0. This is the base value we will modify to maximize the AND value.
     * <p>
     * Check Each Bit: We iterate from the most significant bit to the least significant bit. For each bit position, we consider whether setting this
     * bit in our result would still allow us to have at least two elements in the array that can produce this bit pattern when ANDed together.
     * <p>
     * Form Candidate: For each bit position bit, we form a candidate result by setting the current bit. This is done using result | (1 << bit). Here,
     * 1 << bit creates a number with only the current bit set, and OR-ing it with result sets that bit in the candidate.
     * <p>
     * result is the accumulated value of previous bit checks. 1 << bit is a number with only the bit position set to 1. result | (1 << bit) means we
     * are setting the bit position to 1 in our candidate result. Validate Candidate: We then count how many numbers in the array have this candidate
     * as a subset of their bits. If at least two numbers can support this candidate (i.e., have the current bit set along with all the bits set in
     * result), we update result to this candidate.
     * <p>
     * Repeat: We repeat this process for all bits from the most significant to the least significant, ensuring that each bit we set in the result is
     * valid.
     * <p>
     * By following this process, we build the maximum possible AND value one bit at a time, ensuring that at each step, there are still at least two
     * numbers that can form this bit pattern when ANDed together.
     * <p>
     * Example Consider an example array: [4, 8, 12, 16].
     * <p>
     * In binary: 4: 0100 8: 1000 12: 1100 16: 10000 Let's go through the algorithm:
     * <p>
     * Initial result: 0 (binary: 00000)
     * <p>
     * Checking bit position 4:
     * <p>
     * Candidate: result | (1 << 4) = 0 | 10000 = 10000 Check how many numbers have this bit pattern: Only 16 matches. Not enough pairs, so do not set
     * this bit. Checking bit position 3:
     * <p>
     * Candidate: result | (1 << 3) = 0 | 01000 = 01000 Check how many numbers have this bit pattern: Only 8 and 12 match. Update result to 01000.
     * Checking bit position 2:
     * <p>
     * Candidate: result | (1 << 2) = 01000 | 00100 = 01100 Check how many numbers have this bit pattern: Only 12 matches. Not enough pairs, so do not
     * set this bit. Continue for lower bits:
     * <p>
     * None of the lower bits can produce enough pairs. Final result is 01000 (binary) = 8 (decimal), which is the maximum AND value we can get.
     */
    public static int maxAND1(int[] arr, int n) {
        int result = 0; // Initialize result

        // Iterate over each bit position from the most significant to the least significant
        for (int bit = 31; bit >= 0; bit--) {
            // Find the candidate result by setting the current bit
            // This is done because candidate is currently the maximum AND value we have. Next value should be greater or else we do not
            //need that value. Hence, to only consider the incremental values, we OR with the result.
            int candidate = result | (1 << bit);

            // Count how many elements in the array have this bit set
            int count = countPairsWithBitSet(arr, n, candidate);

            // If at least two elements have this bit set, update the result
            if (count >= 2) {
                result = candidate;
            }
        }

        return result;
    }

    // Function to count pairs with the current bit set in the candidate result
    private static int countPairsWithBitSet(int[] arr, int n, int candidate) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if ((arr[i] & candidate) == candidate) {
                count++;
            }
        }

        return count;
    }
}
