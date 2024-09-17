package array.lectures;

public class SubArrayWithGivenSum {

  public static void main(String[] args) {
    int[] array = new int[]{1, 4};
    int givenSum = 3;

    System.out.println(hasSubarrayWithGivenSum(array, givenSum));
    System.out.println(hasSubarrayWithGivenSum1(array, givenSum));
  }

  static boolean hasSubarrayWithGivenSum(int[] array, int givenSum) {
    int start = 0;
    int sum = 0;

    for (int i = 0; i < array.length; i++) {
      sum = sum + array[i];
      while (sum > givenSum) {
        sum = sum - array[start++];
      }

      if (sum == givenSum && start <= i) {
        return true;
      }
    }

    return false;
  }

  static boolean hasSubarrayWithGivenSum1(int[] arr, int givenSum) {
    int n = arr.length;
    int sum = 0;
    int i = -1;
    int j = -1;

    while (true) {
      if (sum < givenSum) {
        j++;
        if (j >= n) {
          break;
        }

        sum = sum + arr[j];
      } else if (sum > givenSum) {
        i++;
        if (i >= n) {
          break;
        }

        sum = sum - arr[i];
      } else {
        if (i >= j) {
          break;
        }

        System.out.print((i + 1) + " " + j);
        return true;
      }
    }

    return false;
  }
}
