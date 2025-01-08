package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {

  public static void main(String[] args) {
        int k = 4;

    System.out.println(generateString(k));
    System.out.println();
    System.out.println(generateString1(k));
  }

  // Approach 1
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

  // Approach 2
  public static List<String> generateString1(int k) {
    List<String> res = new ArrayList<>();

    generateBinaryStrings(k, "0", res);
    generateBinaryStrings(k, "1", res);

    return res;
  }

  private static void generateBinaryStrings(int k, String curr, List<String> res) {
    if (curr.length() == k) {
      res.add(curr);
      return;
    }

    if (curr.charAt(curr.length() - 1) == '0') {
      generateBinaryStrings(k, curr + '0', res);
      generateBinaryStrings(k, curr + '1', res);
    } else {
      generateBinaryStrings(k, curr + '0', res);
    }
  }
}
