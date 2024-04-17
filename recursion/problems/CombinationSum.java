package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /**
     * Approach 1
     */
    public static List<List<Integer>> combSum(int[] ARR, int B) {
        List<List<Integer>> result = new ArrayList<>();
        findComb(ARR, B, 0, 0, new ArrayList<>(), result);

        return result;
    }

    private static void findComb(int[] arr, int b, int s, int i, List<Integer> list, List<List<Integer>> result) {
        if (s == b) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (i == arr.length || s > b) {
            return;
        }

        list.add(arr[i]);
        findComb(arr, b, s + arr[i], i, list, result);

        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
        findComb(arr, b, s, i + 1, list, result);
    }

    /**
     * Approach 2
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }


}
