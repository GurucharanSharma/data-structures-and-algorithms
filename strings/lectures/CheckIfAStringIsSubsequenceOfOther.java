package strings.lectures;

public class CheckIfAStringIsSubsequenceOfOther {

  // Iterative approach
  private static boolean isSubSequence(String str, String sub) {

    assert sub.length() < str.length();

    int i = 0;
    int j = 0;

    while (i < str.length() && j < sub.length()) {
      if (str.charAt(i) == sub.charAt(j)) {
        i++;
        j++;
      } else {
        i++;
      }
    }

    return j == sub.length();
  }

  // Iterative approach: Returns immediately if the given string is a subsequence
  private static boolean isSubSequence1(String input, String str) {
    if (str.length() > input.length()) {
      return false;
    }

    int j = 0;
    for (int i = 0; i < input.length(); i++) {
      while (j < str.length() && i < input.length() && input.charAt(i) == str.charAt(j)) {
        i++;
        j++;
      }

      if (j == str.length()) {
        return true;
      }
    }

    return false;
  }

  // Recursive approach: Start from the end of both the strings
  private static boolean isSubSequence(String str, String sub, int n, int m) {

    assert sub.length() < str.length();

    if (m == 0) {
      return true;
    }

    if (n == 0) {
      return false;
    }

    if (str.charAt(n) == sub.charAt(m)) {
      return isSubSequence(str, sub, n - 1, m - 1);
    } else {
      return isSubSequence(str, sub, n - 1, m);
    }
  }

  private static boolean isSubSequence1(String input, String str, int i, int j) {
    if (j == str.length()) {
      return true;
    }

    if (i == input.length()) {
      return false;
    }

    if (input.charAt(i) != str.charAt(j)) {
      return isSubSequence1(input, str, i + 1, j);
    } else {
      return isSubSequence1(input, str, i + 1, j + 1);
    }
  }

  public static void main(String[] args) {
    testIsSubSequence();
    testIsSubSequence1();
    testIsSubSequence2();
  }

  private static void testIsSubSequence() {
    String s1 = "iojijegfthdergt";
    String s2 = "efdt";

    System.out.println(isSubSequence(s1, s2));
    System.out.println();
    System.out.println(isSubSequence(s1, s2, s1.length() - 1, s2.length() - 1));
    System.out.println();
    System.out.println(isSubSequence1(s1, s2));
    System.out.println();
    System.out.println(isSubSequence1(s1, s2, s1.length() - 1, s2.length() - 1));
  }

  private static void testIsSubSequence1() {
    String s1 = "ABC";
    String s2 = "AC";

    System.out.println(isSubSequence(s1, s2));
    System.out.println();
    System.out.println(isSubSequence(s1, s2, s1.length() - 1, s2.length() - 1));
    System.out.println();
    System.out.println(isSubSequence1(s1, s2));
    System.out.println();
    System.out.println(isSubSequence1(s1, s2, s1.length() - 1, s2.length() - 1));
  }

  private static void testIsSubSequence2() {
    String s1 = "ABC";
    String s2 = "CA";

    System.out.println(isSubSequence(s1, s2));
    System.out.println();
    System.out.println(isSubSequence(s1, s2, s1.length() - 1, s2.length() - 1));
    System.out.println();
    System.out.println(isSubSequence1(s1, s2));
    System.out.println();
    System.out.println(isSubSequence1(s1, s2, s1.length() - 1, s2.length() - 1));
  }
}
