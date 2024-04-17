package recursion.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Problem statement
 * <p>
 * Given a digit string 's', return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * <p>
 * Note: You don’t need to print anything. Just implement the given function.
 */
public class LetterPhone {

    private static final HashMap<String, String> digitLetterMap = new HashMap<>() {{
        put("1", "1");
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
        put("0", "0");
        put("*", "*");
        put("#", "#");
    }};

    public static List<String> letterCombinations(String a) {
        if (a.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        generateCombinations(a, 0, "", result);

        return result;
    }

    private static void generateCombinations(String a, int index, String curr, List<String> result) {
        if (index >= a.length()) {
            result.add(curr);
            return;
        }

        String letters = digitLetterMap.get(String.valueOf(a.charAt(index)));
        for (int i = 0; i < letters.length(); i++) {
            String word = curr + letters.charAt(i);
            generateCombinations(a, index + 1, word, result);
        }
    }
}
