package strings.lectures;

public class CheckIfAStringIsSubsequenceOfOther {

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

  public static void main(String[] args) {
    testIsSubSequence();
    testIsSubSequence1();
    testIsSubSequence2();
  }

  private static void testIsSubSequence() {
    String s1 = "geeksforgeeks";
    String s2 = "grges";

    System.out.println(isSubSequence(s1, s2));
    System.out.println(isSubSequence(s1, s2, s1.length() - 1, s2.length() - 1));
    System.out.println();
  }

  private static void testIsSubSequence1() {
    String s1 = "ABC";
    String s2 = "AC";

    System.out.println(isSubSequence(s1, s2));
    System.out.println(isSubSequence(s1, s2, s1.length() - 1, s2.length() - 1));
    System.out.println();
  }

  private static void testIsSubSequence2() {
    String s1 = "ABC";
    String s2 = "CA";

    System.out.println(isSubSequence(s1, s2));
    System.out.println(isSubSequence(s1, s2, s1.length() - 1, s2.length() - 1));
    System.out.println();
  }
}
