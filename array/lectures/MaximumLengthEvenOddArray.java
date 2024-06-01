package array.lectures;

public class MaximumLengthEvenOddArray {

    public static void main(String[] args) {
        int[] array = new int[]{10, 12, 8, 4, 7, 6, 2, 7, 6, 3, 8, 1};
        System.out.println(getMaximumLengthEvenOddArray(array));
        System.out.println(getMaximumLengthEvenOddArray1(array));
    }

    static int getMaximumLengthEvenOddArray(int[] array) {
        int length = 1;
        int maxLength = 0;

        for (int i = 1; i < array.length; i++) {
            if ((array[i] % 2 == 0 && array[i - 1] % 2 != 0) || (array[i] % 2 != 0 && array[i - 1] % 2 == 0)) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 1;
            }
        }

        return maxLength;
    }

    private static int getMaximumLengthEvenOddArray1(int[] arr) {
        int n = arr.length;
        int res = 0;

        for (int i = 1; i < n; i++) {
            int count = 1;
            while (i < n && ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0))) {
                count++;
                i++;
            }

            res = Math.max(count, res);
        }

        return res;
    }
}
