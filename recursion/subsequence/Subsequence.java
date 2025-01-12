package recursion.subsequence;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

  public static void main(String[] args) {
    int[] digits = {0, 10, 0};
    String str = "abcd";

//    Solution solution = new Solution();
//    System.out.println(solution.printAllSubsequences(digits));
//    System.out.println();
//    System.out.println(solution.printAllSubsequences(digits));
//    System.out.println();
//    System.out.println(solution.printAllSubsequences(str));
//    System.out.println();

    int target = 0;

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.printAllSubsequences(digits, target));
    System.out.println();
    System.out.println(solution1.printAnySubsequence(digits, target));
    System.out.println();
    System.out.println(solution1.countSubsequences(digits, target));
    System.out.println();
    System.out.println(solution1.countSubsequences1(digits, target));
  }
}

/**
 * All subsequences
 */
class Solution {

  public List<List<Integer>> printAllSubsequences(int[] arr) {
    List<List<Integer>> result = new ArrayList<>();
    findAllSubsequences(arr, new ArrayList<>(), result, 0);

    return result;
  }

  private void findAllSubsequences(int[] arr, List<Integer> list, List<List<Integer>> result, int i) {
    if (i == arr.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    list.add(arr[i]);
    findAllSubsequences(arr, list, result, i + 1);

    list.remove(list.size() - 1);
    findAllSubsequences(arr, list, result, i + 1);
  }

  public List<String> printAllSubsequences(String str) {
    List<String> result = new ArrayList<>();
    findAllSubsequences(str, "", result, 0);

    return result;
  }

  private void findAllSubsequences(String str, String curr, List<String> result, int i) {
    if (i == str.length()) {
      result.add(curr);
      return;
    }

    findAllSubsequences(str, curr, result, i + 1);
    findAllSubsequences(str, curr + str.charAt(i), result, i + 1);
  }
}

/**
 * Target based subsequences
 */
class Solution1 {

  public List<List<Integer>> printAllSubsequences(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    findAllSubsequence(arr, new ArrayList<>(), result, 0, 0, target);

    return result;
  }

  private void findAllSubsequence(int[] arr, List<Integer> list, List<List<Integer>> result, int i, int sum, int target) {
    if (i == arr.length) {
      if (sum == target) {
        result.add(new ArrayList<>(list));
      }

      return;
    }

    list.add(arr[i]);
    findAllSubsequence(arr, list, result, i + 1, sum + arr[i], target);

    list.remove(list.size() - 1);
    findAllSubsequence(arr, list, result, i + 1, sum, target);
  }

  public List<List<Integer>> printAnySubsequence(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    findAnySubsequence(arr, new ArrayList<>(), result, 0, 0, target);

    return result;
  }

  private boolean findAnySubsequence(int[] arr, List<Integer> list, List<List<Integer>> result, int i, int sum, int target) {

//    // 1: Terminating on length
//    if (i == arr.length) {
//      if (sum == target) {
//        result.add(new ArrayList<>(list));
//        return true;
//      }
//
//      return false;
//    }
//    ///////////////////////////

    // 2: Terminating on first possible match
    if (sum == target) {
      result.add(new ArrayList<>(list));
      return true;
    }

    if (sum > target || i >= arr.length) {
      return false;
    }
    ////////////////////////////////////////

    list.add(arr[i]);
    if (findAnySubsequence(arr, list, result, i + 1, sum + arr[i], target)) {
      return true;
    }

    list.remove(list.size() - 1);
    return findAnySubsequence(arr, list, result, i + 1, sum, target);
  }

  public int countSubsequences(int[] arr, int target) {
    return findSubsequences(arr, target, 0, 0);
  }

  private int findSubsequences(int[] arr, int target, int curr, int i) {
    // 1: Only possible terminating condition
    if (i == arr.length) {
      if (curr == target) {
        return 1;
      }

      return 0;
    }

    // Cannot be used. Returns on the first match and we need all.
//    if (curr == target) {
//      return 1;
//    }
//
//    if (curr > target || i >= arr.length) {
//      return 0;
//    }

    return findSubsequences(arr, target, curr + arr[i], i + 1) + findSubsequences(arr, target, curr, i + 1);
  }

  public int countSubsequences1(int[] arr, int target) {
    return findSubsequences1(arr, target, 0, 0);
  }

  private int findSubsequences1(int[] arr, int target, int curr, int i) {
    int count = 0;

    // Here this base case can be used, but this cannot be a terminating condition.
    if (curr == target) {
      count++;
    }

    if (curr > target || i >= arr.length) {
      return count;
    }

    return findSubsequences1(arr, target, curr + arr[i], i + 1) + findSubsequences(arr, target, curr, i + 1);
  }
}