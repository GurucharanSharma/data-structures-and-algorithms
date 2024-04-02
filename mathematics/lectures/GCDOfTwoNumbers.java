package mathematics.lectures;

public class GCDOfTwoNumbers {

    public static int gcdOfTwoNumbers(int a, int b) {
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

    public static int gcdOfTwoNumbers1(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcdOfTwoNumbers1(b % a, a);
    }
}
