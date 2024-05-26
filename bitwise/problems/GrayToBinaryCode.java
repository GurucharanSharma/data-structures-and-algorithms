package bitwise.problems;

public class GrayToBinaryCode {

    /**
     * Approach 1: Function to convert a given Gray equivalent n to Binary equivalent.
     */
    public static int grayToBinary(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n = n / 2;
        }

        StringBuilder gray = new StringBuilder();
        int xor = Integer.parseInt(String.valueOf(binary.charAt(0))) ^ Integer.parseInt(String.valueOf(binary.charAt(1)));
        gray.append(binary.charAt(0));
        gray.append(xor);

        for (int i = 2; i < binary.length(); i++) {
            xor = xor ^ Integer.parseInt(String.valueOf(binary.charAt(i)));
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
     * Approach 2: Function to convert gray code to binary
     */
    public static int grayToBinary1(int gray) {
        int binary = 0;
        for (; gray > 0; gray = gray >> 1) {
            binary ^= gray;
        }

        return binary;
    }
}
