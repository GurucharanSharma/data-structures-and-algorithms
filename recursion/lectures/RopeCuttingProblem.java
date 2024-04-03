package recursion.lectures;

public class RopeCuttingProblem {
    public static void main(String[] args) {
        System.out.println(divide(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
    }

    static int divide(int n, int a, int b, int c) {
        if (n == 0) return 0;
        if (n < 0) return -1;

        int res = Math.max(Math.max(divide(n - a, a, b, c), divide(n - b, a, b, c)), divide(n - c, a, b, c));
        
        if (res == -1) return -1;
        return res + 1;
    }
}
