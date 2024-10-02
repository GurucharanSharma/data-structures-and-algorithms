package recursion;

public class RecursionRunner {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1, 1, 1};

    System.out.println(subsetSum(arr, 0, 0, 3));
    System.out.println();
    System.out.println(countSubsets(arr, 0, 3));
  }

  private static boolean subsetSum(int[] arr, int i, int curr, int sum) {
    if (i == arr.length) {
      return curr == sum;
    }

    return subsetSum(arr, i + 1, curr, sum) || subsetSum(arr, i + 1, curr + arr[i], sum);
  }

  private static int countSubsets(int[] arr, int i, int sum) {
    if (i == arr.length) {
      if (sum == 0) {
        return 1;
      }

      return 0;
    }

    return countSubsets(arr, i + 1, sum) + countSubsets(arr, i + 1, sum - arr[i]);
  }

  private static int countSubsets(int[] arr, int curr, int i, int sum) {
    if (i == arr.length) {
      if (sum == 0) {
        return 1;
      }

      return 0;
    }

    return countSubsets(arr, i + 1, sum) + countSubsets(arr, i + 1, sum - arr[i]);
  }
}
