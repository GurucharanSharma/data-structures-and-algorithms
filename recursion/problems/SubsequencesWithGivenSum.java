package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesWithGivenSum {

  public static void main(String[] args) {
    int[] nums = {0, 10, 0};
    int target = 0;

    System.out.println(subarraysWithSumK(nums, target));
    System.out.println();
    System.out.println(countSubArrays(nums, 0, target));
  }

  public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
    List<List<Integer>> result = new ArrayList<>();
    countSubArrays(a, 0, 0, k, new ArrayList<>(), result);
    return result;
  }

  /**
   * Approach 1
   */
  private static int countSubArrays(int[] a, int i, long s, long k, List<Integer> curr, List<List<Integer>> result) {
    if (s == k) {
      result.add(new ArrayList<>(curr));
      return 1;
    }

    if (i == a.length || s > k) {
      return 0;
    }

    curr.add(a[i]);
    int left = countSubArrays(a, i + 1, s + a[i], k, curr, result);

    curr.remove(curr.size() - 1);
    int right = countSubArrays(a, i + 1, s, k, curr, result);

    return left + right;
  }

  /**
   * Approach 2
   */
  public static int countSubArrays(int[] arr, int index, long K) {
    // Base case: if sum becomes K
    if (K == 0) {
      return 1;
    }
    // Base case: if index exceeds the array length or sum becomes negative
    if (index == arr.length || K < 0) {
      return 0;
    }

    // Recursive case: include the current element in the subsequence
    int include = countSubArrays(arr, index + 1, K - arr[index]);

    // Recursive case: exclude the current element from the subsequence
    int exclude = countSubArrays(arr, index + 1, K);

    // Return the sum of subsequences including and excluding the current element
    return include + exclude;
  }
}
