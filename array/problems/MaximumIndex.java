package array.problems;

/**
 * Given an array a of n positive integers. The task is to find the maximum of j - i subjected to the constraint of a[i] < a[j] and i < j.
 */
public class MaximumIndex {

    public static void main(String[] args) {
        int[] a = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(a, a.length));
    }

    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int[] a, int n) {
        int[] prefixMin = new int[n];
        int[] suffixMax = new int[n];

        prefixMin[0] = a[0];
        suffixMax[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], a[i]);
            suffixMax[n - (i + 1)] = Math.max(suffixMax[n - i], a[n - (i + 1)]);
        }

        int i = 0;  
        int j = 0;
        int difference = 0;
        while (i < n && j < n) {
            if (prefixMin[i] > suffixMax[j]) {
                i++;
            } else {
                difference = Math.max(j - i, difference);
                j++;
            }
        }

        return difference;
    }
}
