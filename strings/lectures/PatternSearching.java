package strings.lectures;

public class PatternSearching {

  public static void main(String[] args) {
    System.out.println("Naive");
    search("Geeks for Geeks", "for");
    search("Hello World", "o Wo");
    System.out.println();

    System.out.println("Better - 1");
    search1("Geeks for Geeks", "for");
    search1("Hello World", "o Wo");
    System.out.println();

    System.out.println("Better - 2");
    search2("Geeks for Geeks", "for");
    search2("Hello World", "o Wo");
    System.out.println();

    System.out.println("Better - 2");
    search2("eeeeeeeeeeeeeeee", "eeeee");
    System.out.println();
  }

  /**
   * Time Complexity: O(m * n) <br> Space Complexity: O(1)
   */
  private static void search(String text, String pattern) {
    int m = text.length();
    int n = pattern.length();

    for (int i = 0; i <= m - n; i++) {
      boolean flag = true;
      for (int j = 0; j < n; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          flag = false;
          break;
        }
      }

      if (flag) {
        System.out.println(i);
      }
    }
  }

  /**
   * Time Complexity: O(m * n) <br> Space Complexity: O(1)
   */
  private static void search1(String text, String pattern) {
    int m = text.length();
    int n = pattern.length();

    for (int i = 0; i <= m - n; i++) {
      String matcher = text.substring(i, i + n);
      if (matcher.matches(pattern)) {
        System.out.println(i);
      }
    }
  }

  /**
   * Time Complexity: O(m * n) <br>
   * Space Complexity: O(1) <br>
   * NOTE: At least the <code>pattern.length()</code> characters in the string should not be repeating.
   */
  private static void search2(String text, String pattern) {
    int m = text.length();
    int n = pattern.length();

    for (int i = 0; i <= m - n; ) {
      boolean flag = true;
      int j = 0;

      while (j < n) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          flag = false;
          break;
        }

        j++;
      }

      if (flag) {
        System.out.println(i);
      }

      if (j == 0) {
        i++;
      } else {
        i = i + j;
      }
    }
  }
}
