package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

  public static void main(String[] args) {
    int n = 3;

    System.out.println(generateParenthesis(n));
    System.out.println();
    System.out.println(generateParenthesis1(n));
  }

  // Approach 1
  public static ArrayList<String> generateParenthesis(int n) {
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

  // Approach 2
  public static List<String> generateParenthesis1(int n) {
    List<String> result = new ArrayList<>();
    generateParenthesis(new StringBuilder(), result, n, n);

    return result;
  }

  private static void generateParenthesis(StringBuilder builder, List<String> result, int left, int right) {
    if (left == 0 && right == 0) {
      result.add(builder.toString());
      return;
    }

    if (left > 0) {
      builder.append("(");
      generateParenthesis(builder, result, left - 1, right);
      builder.deleteCharAt(builder.length() - 1);
    }

    if (right > left) {
      builder.append(")");
      generateParenthesis(builder, result, left, right - 1);
      builder.deleteCharAt(builder.length() - 1);
    }
  }
}
