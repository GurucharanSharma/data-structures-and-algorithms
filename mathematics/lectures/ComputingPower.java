package mathematics.lectures;

public class ComputingPower {
    public static void main(String[] args) {
        int x = 4;
        int n = 5;

        System.out.println(iterativeSolution(x, n));
    }

    private static int iterativeSolution(int x, int n) {
        int result = 1;
        while(n > 0) {
            if (n % 2 != 0) {
                // Bit is 1
                result = result * x;
            }

            x = x * x;
            n = n / 2; // shifts the bits of the number 1 position to the right (towards 0)
        }

        return result;
    }
}
