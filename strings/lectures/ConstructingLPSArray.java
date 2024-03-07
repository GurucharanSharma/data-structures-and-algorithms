package strings.lectures;

import java.util.Arrays;

public class ConstructingLPSArray {

  public static void main(String[] args) {
    System.out.println("Naive: ");
    constructLPS("abacabad");
    constructLPS("abbabb");
    constructLPS("aabcadaabe");
    System.out.println();

    System.out.println("Better: ");
    constructLPS1("abacabad");
    constructLPS1("abbabb");
    constructLPS("aabcadaabe");
    System.out.println();
  }

  /**
   * <b>Naive Approach</b> <br>
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(n)
   */
  private static void constructLPS(String text) {
    int[] lps = new int[text.length()];

    for (int i = 0; i < text.length(); i++) {
      lps[i] = calculateLPS(text, i + 1);
    }

    System.out.println(Arrays.toString(lps));
  }

  private static int calculateLPS(String text, int n) {
    for (int len = n - 1; len > 0; len--) {
      boolean match = true;
      for (int i = 0; i < len; i++) {
        if (text.charAt(n - len + i) != text.charAt(i)) {
          match = false;
          break;
        }
      }

      if (match) {
        return len;
      }
    }

    return 0;
  }

  /**
   * <b>Better Approach</b> <br>
   * Time Complexity: O(n) <br> Auxiliary Space: O(n)
   */
  private static void constructLPS1(String text) {
    int[] lps = new int[text.length()];
    lps[0] = 0;
    int len = 0, i = 1;

    while (i < text.length()) {
      if (text.charAt(i) == text.charAt(len)) {
        lps[i++] = ++len;
      } else {
        if (len == 0) {
          lps[i++] = 0;
        } else {
          len = lps[len - 1];
        }
      }
    }

    System.out.println(Arrays.toString(lps));
  }
}
