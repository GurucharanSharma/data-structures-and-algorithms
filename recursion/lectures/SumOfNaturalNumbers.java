package recursion.lectures;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {
        System.out.println(getSum(1000000000, 0));
//        System.out.println(getSum(1000000000));
    }

    static int getSum(int n, int k) {
        if (n <= 0) {
            return k;
        }

        return getSum(n - 1, k + n);
    }

    private static int getSum(int n) {
        if (n <= 0) {
            return 0;
        }

        return n + getSum(n - 1);
    }
}
