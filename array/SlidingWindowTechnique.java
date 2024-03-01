package array;

public class SlidingWindowTechnique {
    public static void main(String[] args) {
        int[] array = new int[] { 2, 3 };
        System.out.println(getMaximumSumInWindow(array, 3));
    }

    static int getMaximumSumInWindow(int[] array, int window) {
        if (window > array.length) return -1;

        int result = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (i < window) {
                sum += array[i];
                result = sum;
            } else {
                sum += array[i] - array[i - window];
                result = Math.max(sum, result);
            }
        }

        return result;
    }
}
