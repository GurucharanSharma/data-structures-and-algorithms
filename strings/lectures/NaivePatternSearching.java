package strings.lectures;

public class NaivePatternSearching {

  public static void main(String[] args) {
    System.out.println("Naive");
    search("Geeks for Geeks", "for");
    search("Hello World", "o Wo");
    search("eeeeeeeeeeeeeeee", "eeeee");
    System.out.println();

    System.out.println("Better - 1");
    search1("Geeks for Geeks", "for");
    search1("Hello World", "o Wo");
    search1("eeeeeeeeeeeeeeee", "eeeee");
    System.out.println();

    System.out.println("Better - 2");
    search2("Geeks for Geeks", "for");
    search2("Hello World", "o Wo");
    search2("eeeeeeeeeeeeeeee", "eeeee");
    System.out.println();

    System.out.println("Better - 3");
    search3("Geeks for Geeks", "for");
    search3("Hello World", "o Wo");
    search3("eeeeeeeeeeeeeeee", "eeeee");
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

  // Improved naive pattern searching for distinct characters
  // NOTE: At least the <code>pattern.length()</code> characters in the string should not be repeating.
  // Time Complexity: O(m * n)
  // Auxiliary Space: O(1)
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

      if (flag) {               // Rather than a flag, j == pattern.length() function can also be used.
        System.out.println(i);
      }

      if (j == 0) {
        i++;
      } else {
        i = i + j;
      }
    }
  }

  // Improved naive pattern searching for distinct characters. Only 1 loop.
  static void search3(String text, String pattern) {
    int m = text.length();
    int n = pattern.length();
    boolean found = false;

    if (m < n) {
      System.out.println("Not Found");
      return;
    }

    int j = 0;
    int start = -1;
    for (int i = 0; i < m; i++) {
      if (text.charAt(i) == pattern.charAt(j)) {
        j++;

        if (start == -1) {
          start = i;
        }

        if (j == n) {
          found = true;
          System.out.println("Found at: " + start);
          start = -1;
          j = 0;
        }
      } else {
        start = -1;
        j = 0;
      }
    }

    if (!found) {
      System.out.println("Not Found");
    }
  }

  private static int search4(String input, String pattern) {
    if (input.isEmpty() || pattern.isEmpty()) {
      return -1;
    }

    int j = 0;
    int pos = -1;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == pattern.charAt(j)) {
        if (pos == -1) {
          pos = i;
        }

        j++;
      } else {
        j = 0;
        pos = -1;
      }

      if (j == pattern.length()) {
        return pos;
      }
    }

    return -1;
  }

  private static int search5(String input, String pattern) {
    if (input.isEmpty() || pattern.isEmpty()) {
      return -1;
    }

    int j = 0;
    int pos = -1;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == pattern.charAt(j)) {
        pos = i;
        while (i < input.length() && j < pattern.length() && input.charAt(i) == pattern.charAt(j)) {
          i++;
          j++;
        }

        if (j == pattern.length()) {
          return pos;
        } else {
          pos = -1;
          j = 0;
        }
      }
    }

    return pos;
  }

  private static int search6(String input, String pattern) {
    if (input.isEmpty() || pattern.isEmpty()) {
      return -1;
    }

    int i = 0;
    int pos = -1;
    while (i < input.length()) {
      boolean flag = true;
      int j = 0;
      while (j < pattern.length()) {
        if (input.charAt(i + j) != pattern.charAt(j)) {
          flag = false;
          break;
        }

        j++;
      }

      if (flag) {
        return i;
      } else {
        i += (j + 1);
      }
    }

    return pos;
  }
}
