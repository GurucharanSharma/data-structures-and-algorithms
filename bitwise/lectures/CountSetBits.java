package bitwise.lectures;

public class CountSetBits {

    private static final int[] table = new int[256];

    static {
        table[0] = 0;

        for (int i = 1; i <= 255; i++) {
            table[i] = table[i & (i - 1)] + 1;
            //System.out.println(table[i]);
        }
    }

    static int countSetBits(int x) {
        return table[x & 255] + table[x >> 8 & 255] + table[x >> 16 & 255] + table[x >> 24];
    }

    public static void main(String[] args) {
        int x = 255;
        System.out.println(countSetBits(x));
    }
}
