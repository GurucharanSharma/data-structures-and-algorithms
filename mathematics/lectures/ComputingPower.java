package mathematics.lectures;

public class ComputingPower {

    public static void main(String[] args) {
        int x = 3;
        int n = 5;

        System.out.println(iterativeSolution(x, n));
        System.out.println(recursiveSolution(x, n));
    }

    private static int iterativeSolution(int x, int n) {
        int result = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                // Bit is 1
                result = result * x;
            }

            x = x * x;
            n = n / 2; // shifts the bits of the number 1 position to the right (towards 0)
        }

        return result;
    }

    private static int recursiveSolution(int x, int y) {
        int temp;
        if (y == 0) {
            return 1;
        }

        temp = recursiveSolution(x, y / 2);
        
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}
