package recursion.lectures;

public class GenerateSubsets {

  public static void main(String[] args) {
    generateSubsets(args[0], "", 0);
  }

  static void generateSubsets(String str, String curr, int i) {
    if (i == str.length()) {
      System.out.println(curr);
      return;
    }

    generateSubsets(str, curr, i + 1);
    generateSubsets(str, curr + str.charAt(i), i + 1);
  }
}
