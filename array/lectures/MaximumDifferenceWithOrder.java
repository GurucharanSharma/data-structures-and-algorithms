package array.lectures;

public class MaximumDifferenceWithOrder {

    public static void main(String[] args) {
        int[] array = new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1};

        System.out.println(findMaximumDifference(array));
    }

    static int findMaximumDifference(int[] array) {
        int n = array.length;
        int min = array[0];
        int difference = 0;

        for (int i = 1; i < n; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (difference < (array[i] - min)) {
                difference = array[i] - min;
            }
        }

        return difference;
    }
}
