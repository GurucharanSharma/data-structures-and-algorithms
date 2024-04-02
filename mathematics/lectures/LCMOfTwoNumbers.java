package mathematics.lectures;

public class LCMOfTwoNumbers {

    public static void main(String[] args) {
        int a = 15;
        int b = 25;

        int lcm = (a * b) / gcd(a, b);
        System.out.println(lcm);
    }

    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        if (a == 1 || b == 1) {
            return 1;
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    public static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}
