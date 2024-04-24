package bitwise.lectures;

public class CheckKthBit {

    public static void main(String[] args) {
        System.out.println(isKthBitSet_1(5, 3));
        System.out.println(isKthBitSet_2(5, 3));
    }

    static boolean isKthBitSet_1(int n, int k) {
        int x = 1 << (k - 1);

        return (n & x) != 0;
    }

    static boolean isKthBitSet_2(int n, int k) {
        int x = n >> (k - 1);

        return (x & 1) != 0;
    }
}
