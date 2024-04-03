package recursion.lectures;

public class NToOne {
    public static void main(String[] args) {
        printNto1(4);
    }

    private static void printNto1(int n) {
        if (n <= 0) return;

        System.out.println(n);
        printNto1(n - 1);
    }
}
