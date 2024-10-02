package recursion.lectures;

public class NToOne {
    public static void main(String[] args) {
        printNto1(4);
    }

    // It is a tail recursion as the last statement is the recursive method call
    private static void printNto1(int n) {
        if (n <= 0) return;

        System.out.println(n);
        printNto1(n - 1);
    }
}
