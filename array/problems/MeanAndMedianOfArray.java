package array.problems;

import java.util.Arrays;

public class MeanAndMedianOfArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 19, 28, 5};
        System.out.println(median(a, a.length));
        System.out.println(mean(a, a.length));
    }

    //Function to find median of the array elements.
    public static int median(int[] A, int N) {
        Arrays.sort(A);

        if (N % 2 != 0) {
            return A[N / 2];
        } else {
            return (A[N / 2] + A[(N - 1) / 2]) / 2;
        }
    }

    //Function to find median of the array elements.
    public static int mean(int[] A, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }

        return sum / N;
    }
}
