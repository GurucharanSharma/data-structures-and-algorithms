package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesWithGivenSum {

    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        List<List<Integer>> result = new ArrayList<>();

        int count = countSubArrays(a, 0, 0, k);
        System.out.println(count);

        return result;
    }

    private static int countSubArrays(int[] a, int i, long s, long k) {
        if (i == a.length) {
            System.out.println("> " + i);
            if (s == k) {
                System.out.println("- " + s);
                return 1;
            }

            return 0;
        }

        int left = countSubArrays(a, i + 1, s, k);
        int right = countSubArrays(a, i + 1, s + a[i], k);

        return left + right;
    }
}
