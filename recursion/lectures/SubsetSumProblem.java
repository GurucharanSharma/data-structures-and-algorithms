package recursion.lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubsetSumProblem {

  public static void main(String[] args) {
    List<Integer> set = Arrays.asList(0, 10, 0);
//    int sum = 9;
    int sum = 0;

    subsetSum(set, new ArrayList<>(), 0, sum);
    System.out.println();
    System.out.println(subsetSum(set, 0, 0, sum));
    System.out.println();
    System.out.println("Subset count: " + countSubsets(set, 0, 0, sum));
    System.out.println();
    System.out.println("Subset count: " + countSubsets(set, set.size(), sum));
  }

  // Approach 1: Also prints the list of sub arrays
  static void subsetSum(List<Integer> set, List<Integer> curr, int i, int sum) {
    if (i >= set.size()) {
      if (curr.stream().mapToLong(a -> a).sum() == sum) {
        System.out.println(curr);
      }

      return;
    }

    subsetSum(set, curr, i + 1, sum);
    subsetSum(set, Stream.concat(curr.stream(), Stream.of(set.get(i))).collect(Collectors.toList()), i + 1, sum);
  }

  // Approach 2: If the list of sub arrays not required. Simple returns true is the subset is found.
  static boolean subsetSum(List<Integer> set, int curr, int i, int sum) {
    if (i >= set.size()) {
      return curr == sum;
    }

    return subsetSum(set, curr, i + 1, sum) || subsetSum(set, curr + set.get(i), i + 1, sum);
  }

  // Approach 1: Using an extra variable to hold current sum
  static int countSubsets(List<Integer> set, int curr, int i, int sum) {
    if (i == set.size()) {
      return (sum == curr) ? 1 : 0;
    }

    return countSubsets(set, curr, i + 1, sum) + countSubsets(set, curr + set.get(i), i + 1, sum);
  }

  // Approach 2: Without using an extra variable to hold current sum
  static int countSubsets(List<Integer> set, int n, int sum) {
    if (n == 0) {
      return (sum == 0) ? 1 : 0;
    }

    return countSubsets(set, n - 1, sum) + countSubsets(set, n - 1, sum - set.get(n - 1));
  }
}
