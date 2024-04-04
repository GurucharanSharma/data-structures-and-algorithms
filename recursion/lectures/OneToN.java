package recursion.lectures;

public class OneToN {
    public static void main(String[] args) {
        print1toN(10);
        System.out.println();
        print1toNTail(10, 1);
    }

    private static void print1toN(int n) {
        if (n <= 0) return; // Base case or terminating condition
        
        print1toN(n - 1);
        System.out.print(n + " ");
    }

    private static void print1toNTail(int n, int k) {
        if (n <= 0) return; // Base case or terminating condition
        
        System.out.print(k + " ");
        print1toNTail(n - 1, k + 1);
    }
}
