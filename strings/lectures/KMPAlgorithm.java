package strings.lectures;

public class KMPAlgorithm {

  public static void main(String[] args) {
    search("ababcababaad", "ababa");
    search1("ababcababaad", "ababa");
    System.out.println();
    search("adiabatically", "tica");
    search1("adiabatically", "tica");
    System.out.println();
    search("aaaaabaaaaa", "aaaa");
    search1("aaaaabaaaaa", "aaaa");
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(n) <br> NOTE: Here n is the length of the text.
   */
  private static void search(String text, String pattern) {
    int[] lps = new int[pattern.length()];
    constructLPS(pattern, lps);
    int i = 0, j = 0;

    while (i < text.length()) {
//      System.out.println("i: " + i + " | j: " + j);
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }

      if (j == pattern.length()) {
        System.out.println(i - j); // or System.out.println(i - pattern.length());
        j = lps[j - 1]; // because j is already increment by 1 too many, hence decrementing it by 1.
      } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
        if (j == 0) {
          i++;
        } else {
          j = lps[j - 1];
        }
      }
    }
  }

  // Approach 2
  private static void search1(String text, String pattern) {
    int[] lps = new int[pattern.length()];
    constructLPS(pattern, lps);
    int i = 0, j = 0;

    while (i < text.length()) {
      if (text.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;

        if (j == pattern.length()) {
          System.out.println(i - j); // or System.out.println(i - pattern.length());
          j = lps[j - 1]; // because j is already increment by 1 too many, hence decrementing it by 1.
        }
      } else {
        if (j == 0) {
          i++;
        } else {
          j = lps[j - 1];
        }
      }
    }
  }

  private static void constructLPS(String str, int[] lps) {
    int i = 1, len = 0;
    lps[0] = 0;

    while (i < str.length()) {
      if (str.charAt(i) == str.charAt(len)) {
        lps[i++] = ++len;
      } else {
        if (len == 0) {
          lps[i++] = 0;
        } else {
          len = lps[len - 1];
        }
      }
    }
  }
}
