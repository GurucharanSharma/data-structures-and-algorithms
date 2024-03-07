package bitwise.lectures;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 0) return true;
        return ((n & (n - 1)) == 0);
    }
}
