package recursion.problems;

import java.util.ArrayList;

public class CombinationSumII {

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
}
