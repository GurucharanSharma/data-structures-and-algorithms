package recursion.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MoreSubsequence {

    /**
     * Approach 1
     */
    public static String moreSubsequence(int n, int m, String a, String b) {
        int countA = countSubsequence(a, n, "", 0, new HashMap<>());
        int countB = countSubsequence(b, m, "", 0, new HashMap<>());

        if (countA >= countB) {
            return a;
        } else {
            return b;
        }
    }

    private static int countSubsequence(String str, int n, String curr, int i, Map<String, Integer> map) {
        if (i == n) {
            if (!curr.isEmpty() && !map.containsKey(curr)) {
                map.put(curr, 1);
                return 1;
            }

            return 0;
        }

        int left = countSubsequence(str, n, curr, i + 1, map);
        int right = countSubsequence(str, n, curr + str.charAt(i), i + 1, map);

        return left + right;
    }

    /**
     * Approach 2
     */
    public static String moreSubsequence1(int n, int m, String a, String b) {
        int countA = countSubsequence(a, n, "", 0, new HashSet<>());
        int countB = countSubsequence(b, m, "", 0, new HashSet<>());

        if (countA >= countB) {
            return a;
        } else {
            return b;
        }
    }

    private static int countSubsequence(String str, int n, String curr, int i, Set<String> subsequences) {
        if (i == n) {
            if (!curr.isEmpty() && !subsequences.contains(curr)) {
                subsequences.add(curr);
                return 1;
            }

            return 0;
        }

        int count = countSubsequence(str, n, curr, i + 1, subsequences);
        return count + countSubsequence(str, n, curr + str.charAt(i), i + 1, subsequences);
    }
}
