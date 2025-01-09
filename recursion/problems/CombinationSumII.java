package recursion.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

  public static void main(String[] args) {
    ArrayList<Integer> candidates = new ArrayList<>(List.of(2, 5, 2, 1, 2));
    int target = 5;

    System.out.println(combinationSum2(candidates, candidates.size(), target));
    System.out.println();
    System.out.println(combinationSum2_1(candidates, candidates.size(), target));
    System.out.println();
    System.out.println(combinationSum2_2(candidates, candidates.size(), target));
  }

  /**
   * Approach 1
   */
  public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    arr.sort(Integer::compareTo);
    findCombination(arr, n, target, 0, 0, new ArrayList<>(), result);
    return result;
  }

  private static void findCombination(ArrayList<Integer> arr, int n, int target, int sum, int i, ArrayList<Integer> list,
      ArrayList<ArrayList<Integer>> result) {
    if (sum == target) {
      list.sort(Integer::compareTo);
      if (!result.contains(list)) {
        result.add(new ArrayList<>(list));
      }
      return;
    }

    if (i == n || sum > target) {
      return;
    }

    list.add(arr.get(i));
    findCombination(arr, n, target, sum + arr.get(i), i + 1, list, result);

    if (!list.isEmpty()) {
      list.remove(list.size() - 1);
    }
    findCombination(arr, n, target, sum, i + 1, list, result);
  }

  /**
   * Approach 2
   */
  public static ArrayList<ArrayList<Integer>> combinationSum2_1(ArrayList<Integer> arr, int n, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    arr.sort(Integer::compareTo);
    findCombination_1(arr, n, target, 0, 0, new ArrayList<>(), result);
    return result;
  }

  private static void findCombination_1(ArrayList<Integer> arr, int n, int target, int sum, int i, ArrayList<Integer> list,
      ArrayList<ArrayList<Integer>> result) {
    if (sum == target) {
      result.add(new ArrayList<>(list));
      return;
    }

    if (i == n || sum > target) {
      return;
    }

    for (int j = i; j < arr.size(); j++) {
      if (j > i && arr.get(j).intValue() == arr.get(j - 1)) {
        continue;
      }

      if (arr.get(j) > target) {
        break;
      }

      list.add(arr.get(j));
      findCombination_1(arr, n, target, sum + arr.get(j), j + 1, list, result);

      if (!list.isEmpty()) {
        list.remove(list.size() - 1);
      }
    }
  }

  // Approach 3
  public static ArrayList<ArrayList<Integer>> combinationSum2_2(ArrayList<Integer> arr, int n, int target) {
    Set<ArrayList<Integer>> result = new HashSet<>();
    findCombination_2(arr, n, target, 0, 0, new ArrayList<>(), result);

    return new ArrayList<>(result);
  }

  private static void findCombination_2(ArrayList<Integer> arr, int n, int target, int sum, int i, ArrayList<Integer> list,
      Set<ArrayList<Integer>> result) {
    if (i == arr.size()) {
      if (sum == target) {
        result.add(new ArrayList<>(list));
      }

      return;
    }

    if (arr.get(i) <= target) {
      list.add(arr.get(i));
      findCombination_2(arr, n, target, sum + arr.get(i), i + 1, list, result);
      list.remove(list.size() - 1);
    }

    findCombination_2(arr, n, target, sum, i + 1, list, result);
  }
}
