package recursion.problems;

public class AtoI {

    public static int atoi(String str) {
        str = str.trim();
        if (str.charAt(0) == '-') {
            return -1 * myAtoI(str.replaceFirst("-", ""), 0, 0, true);
        } else if (str.charAt(0) == '+') {
            return myAtoI(str.replaceFirst("\\+", ""), 0, 0, false);
        } else {
            return myAtoI(str, 0, 0, false);
        }
    }

    private static int myAtoI(String str, int i, int num, boolean negative) {
        if (i == str.length() || !Character.isDigit(str.charAt(i))) {
            return num;
        }

        int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
        if (negative) {
            if (-num < (Integer.MIN_VALUE + digit) / 10) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            }
        }

        num = num * 10 + digit;
        return myAtoI(str, i + 1, num, negative);
    }
}
