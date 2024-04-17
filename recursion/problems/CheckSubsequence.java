package recursion.problems;

public class CheckSubsequence {

    public static boolean isSubsetPresent(int n, int k, int[] a) {
        return subsetSum(n, k, a, 0, 0);
    }

    private static boolean subsetSum(int n, int k, int[] a, int i, int s) {
        if (s == k) {
            return true;
        }

        if (i == n || s > k) {
            return false;
        }

        if (subsetSum(n, k, a, i + 1, s + a[i])) {
            return true;
        } else {
            return subsetSum(n, k, a, i + 1, s);
        }
    }
}
