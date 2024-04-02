package mathematics.problems;

public class CheckArmstrong {

    public static boolean checkArmstrong(int n) {
        int digits = String.valueOf(n).length();
        int res = 0;
        int num = n;

        while (num > 0) {
            res = (int) (res + Math.pow(num % 10, digits));
            num = num / 10;
        }

        return (res == n);
    }
}
