package recursion.lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubsetSumProblem {
    public static void main(String[] args) {
        List<Integer> set = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        subsetSum(set, new ArrayList<>(), 0, 9);

        System.out.println("Subset count: " + countSubsets(set, set.size(), 9));
    }

    static void subsetSum(List<Integer> set, List<Integer> curr, int i, int sum) {
        if (i >= set.size()) {
            if (curr.stream().mapToLong(a -> a).sum() == sum) {
                System.out.println(curr.toString());
            }
            
            return;
        }

        subsetSum(set, curr, i + 1, sum);
        subsetSum(set, Stream.concat(curr.stream(), Stream.of(set.get(i))).collect(Collectors.toList()), i + 1, sum);
    }

    static int countSubsets(List<Integer> set, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        return countSubsets(set, n - 1, sum) + countSubsets(set, n - 1, sum - set.get(n - 1));
    }
}
