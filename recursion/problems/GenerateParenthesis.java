package recursion.problems;

import java.util.ArrayList;

public class GenerateParenthesis {

    public static ArrayList<String> validParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }

    private static void generate(ArrayList<String> result, String curr, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(curr);
            return;
        }

        if (left > 0) {
            generate(result, curr + "(", left - 1, right);
        }

        if (right > left) {
            generate(result, curr + ")", left, right - 1);
        }
    }
}
