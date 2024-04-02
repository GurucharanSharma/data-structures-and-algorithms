package mathematics.lectures;

public class CountDigits {

    public static int countDigitsIterative(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    public static int countDigitsRecursive(int n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + countDigitsRecursive(n / 10);
    }

}