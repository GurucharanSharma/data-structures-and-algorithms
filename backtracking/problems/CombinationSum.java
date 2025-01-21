package backtracking.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    int N = 4;
    ArrayList<Integer> arr = new ArrayList<>(List.of(9, 7, 9, 6, 12, 12, 8, 7, 7));
    int B = 28;

    System.out.println(Solution.combinationSum(arr, B));
  }

  static class Solution {

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
      Collections.sort(A);

      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      getCombinations(A, B, new ArrayList<>(), result, 0);

      result.sort((list1, list2) -> Integer.compare(list2.size(), list1.size()));

      return result;
    }

    private static void getCombinations(ArrayList<Integer> A, int B, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, int index) {
      if (B == 0) {
        ArrayList<Integer> ans = new ArrayList<>(list);
        Collections.sort(ans);
        result.add(ans);
        return;
      }

      if (B < 0 || index >= A.size()) {
        return;
      }

      for (int i = index; i < A.size(); i++) {
        if (i > index && A.get(i) == A.get(i - 1)) {
          continue;
        }

        list.add(A.get(i));
        getCombinations(A, B - A.get(i), list, result, i);
        list.remove(list.size() - 1);
      }
    }
  }
}
