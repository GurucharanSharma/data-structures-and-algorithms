package mathematics.problems;

public class PalindromeNumber {

    public static boolean palindromeNumber(int n) {
        String num = String.valueOf(n);
        StringBuilder builder = new StringBuilder(num);
        return (num.contentEquals(builder.reverse()));
    }

    public static boolean palindromeNumber1(int n) {
        int num = n;
        int reverse = 0;

        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }

        return (reverse == n);
    }

    public static boolean palindromeNumber2(int n) {
        if (n == 0) {
            return true;
        }

        if (n < 0 || n % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (n > reverse) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }

        return reverse == n || reverse / 10 == n;
    }
}
