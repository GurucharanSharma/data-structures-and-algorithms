package array.lectures;

public class MaximumDifferenceWithOrder {

  public static void main(String[] args) {
    int[] array = new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1};

    System.out.println(findMaximumDifference(array));
    System.out.println(findMaximumDifference1(array));
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

  static int findMaximumDifference1(int[] arr) {
    int min = arr[0];
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      min = Math.min(arr[i], min);
      max = Math.max(arr[i] - min, max);
    }

    return max;
  }
}
