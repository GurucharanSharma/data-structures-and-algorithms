package array.lectures;

/**
 * Given two arrays L[ ] and R[ ] of size N where L[i] and R[i] (0 ? L[i], R[i] < 106) denotes a range of numbers, the task is to find the
 * maximum occurred integer in all the ranges. If more than one such integer exists, print the smallest one. Our Task: Given two arrays L[ ] and R[ ]
 * of size N where L[i] and R[i] (0 ? L[i], R[i] < 106) denotes a range of numbers, the task is to find the maximum occurred integer in all the
 * ranges. If more than one such integer exists, print the smallest one.
 */
public class MaximumAppearingElement {

    public static void main(String[] args) {
        int[] L = {0, 0};
        int[] R = {1, 1};

        int maxx = R[0];
        for (int i = 1; i < R.length; i++) {
            maxx = Math.max(maxx, R[i]);
        }

        System.out.println("Maximum in R: " + maxx);
        System.out.println(maxOccured(L, R, L.length, maxx));
    }

    /**
     * Efficient approach: <br> Time Complexity: O(N + MAX) <br> Auxiliary space: O(MAX)
     */
    public static int maxOccured(int[] L, int[] R, int n, int maxx) {
        int[] freq = new int[maxx + 2];
        for (int i = 0; i < n; i++) {
            freq[L[i]] += 1;
            freq[R[i] + 1] += -1;

        }

        int max = freq[0];
        int index = 0;
        for (int i = 1; i < freq.length; i++) {
            freq[i] = Math.max(freq[i] + freq[i - 1], 0);
            if (freq[i] > max) {
                max = freq[i];
                index = i;
            }

        }

        return index;
    }
}
