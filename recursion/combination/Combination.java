package recursion.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

  public static void main(String[] args) {
    int[] arr = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;

    Solution solution = new Solution();
    System.out.println(solution.getCombinations(arr, target));
    System.out.println();
    System.out.println(solution.getCombinations1(arr, target));
    System.out.println();

    Solution1 solution1 = new Solution1();
    System.out.println(solution1.combinationSum2(arr, target));
  }
}

class Solution {

  public List<List<Integer>> getCombinations(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    findCombinations(arr, target, 0, new ArrayList<>(), result, 0);

    return result;
  }

  private void findCombinations(int[] arr, int target, int curr, List<Integer> list, List<List<Integer>> result, int i) {
    if (curr == target) {
      result.add(new ArrayList<>(list));
      return;
    }

    if (i >= arr.length || curr > target) {
      return;
    }

    list.add(arr[i]);
    findCombinations(arr, target, curr + arr[i], list, result, i);

    list.remove(list.size() - 1);
    findCombinations(arr, target, curr, list, result, i + 1);
  }

  public List<List<Integer>> getCombinations1(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    findCombinations1(arr, target, 0, new ArrayList<>(), result, 0);

    return result;
  }

  private void findCombinations1(int[] arr, int target, int curr, List<Integer> list, List<List<Integer>> result, int i) {
    if (i >= arr.length) {
      if (curr == target) {
        result.add(new ArrayList<>(list));
      }

      return;
    }

    if (curr < target) {
      list.add(arr[i]);
      findCombinations1(arr, target, curr + arr[i], list, result, i);
      list.remove(list.size() - 1);
    }

    findCombinations1(arr, target, curr, list, result, i + 1);
  }
}

class Solution1 {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    findCombinations(candidates, target, 0, new ArrayList<>(), result, 0);

    return result;
  }

  private void findCombinations(int[] arr, int target, int curr, List<Integer> list, List<List<Integer>> result, int index) {
    if (curr == target) {
      result.add(new ArrayList<>(list));
      return;
    }

    if (curr > target) {
      return;
    }

    for (int i = index; i < arr.length; i++) {
      if (i > index && arr[i] == arr[i - 1]) {
        continue;
      }

      list.add(arr[i]);
      findCombinations(arr, target, curr + arr[i], list, result, i + 1);
      list.remove(list.size() - 1);
    }
  }
}