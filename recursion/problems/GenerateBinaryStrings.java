package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {

    public static List<String> generateString(int N) {
        List<String> result = new ArrayList<>();
        generate("", N, result);
        return result;
    }

    private static void generate(String curr, int n, List<String> result) {
        if (curr.length() == n) {
            result.add(curr);
            return;
        }

        generate(curr + "0", n, result);

        if (curr.isEmpty() || curr.charAt(curr.length() - 1) != '1') {
            generate(curr + "1", n, result);
        }
    }
}
