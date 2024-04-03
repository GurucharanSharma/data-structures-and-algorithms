package recursion.lectures;

public class OneToN {
    public static void main(String[] args) {
        printNto1(10);
        System.out.println();
        printNto1Tail(10, 1);
    }

    private static void printNto1(int n) {
        if (n <= 0) return; // Base case or terminating condition
        
        printNto1(n - 1);
        System.out.print(n + " ");
    }

    private static void printNto1Tail(int n, int k) {
        if (n <= 0) return; // Base case or terminating condition
        
        System.out.print(k + " ");
        printNto1Tail(n - 1, k + 1);
    }
}
