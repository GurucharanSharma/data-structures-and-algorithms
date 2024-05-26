package bitwise.problems;

public class BinaryToGrayCode {

    /**
     * Approach 1: Naive approach
     */
    public static int greyConverter(int n) {
        if (n == 0) {
            return 0;
        }

        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n = n / 2;
        }

        StringBuilder gray = new StringBuilder();
        gray.append(binary.charAt(0));

        for (int i = 1; i < binary.length(); i++) {
            int xor = (int) binary.charAt(i) ^ (int) binary.charAt(i - 1);
            gray.append(xor);
        }

        return generateNumber(gray.toString());
    }

    private static int generateNumber(String binary) {
        int res = 0;
        int temp = 1;

        for (int i = 0; i < binary.length(); i++) {
            int bit = binary.charAt(binary.length() - i - 1);
            if (bit == '1') {
                res = res + temp;
            }

            temp = temp * 2;
        }

        return res;
    }

    /**
     * Approach 2: Efficient solution
     */
    // Function to convert binary to gray code
    public static int greyConverter1(int n) {
        // Directly calculate the Gray code using bitwise operations
        return n ^ (n >> 1);
    }
}
