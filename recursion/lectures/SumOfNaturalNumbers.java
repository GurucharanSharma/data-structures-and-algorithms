package recursion.lectures;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(getSum(6, 0));
    }

    static int getSum(int n, int k) {
        if (n <= 0) return k;

        return getSum(n - 1, k + n);
    }
}
