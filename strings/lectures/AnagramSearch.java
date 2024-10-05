package strings.lectures;

import java.util.Arrays;

public class AnagramSearch {

  public static void main(String[] args) {
    System.out.println("Naive: ");
    System.out.println(search("geeksforgeeks", "frog"));
    System.out.println(search("forgetfulness", "ness"));
    System.out.println();

    System.out.println("Naive - 1: ");
    System.out.println(search1("geeksforgeeks", "frog"));
    System.out.println(search1("forgetfulness", "ness"));
    System.out.println();

    System.out.println("Better: ");
    System.out.println(search2("geeksforgeeks", "frog"));
    System.out.println(search2("forgetfulness", "ness"));
    System.out.println();
  }

  /**
   * <b>Naive Approach</b> <br>
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static boolean search(String text, String pattern) {
    for (int i = 0; i <= (text.length() - pattern.length()); i++) {
      char[] txtArr = text.substring(i, i + pattern.length()).toCharArray();
      char[] patArr = pattern.toCharArray();

      Arrays.sort(txtArr);
      Arrays.sort(patArr);

      if (Arrays.equals(txtArr, patArr)) {
        return true;
      }
    }

    return false;
  }

  /**
   * <b>Naive Approach</b> <br>
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static boolean search1(String text, String pattern) {
    for (int i = 0; i < (text.length() - pattern.length()); i++) {
      if (isAnagram(text, pattern, i)) {
        return true;
      }
    }

    return false;
  }

  private static boolean isAnagram(String text, String pattern, int i) {
    int[] count = new int[256];

    for (int j = 0; j < pattern.length(); j++) {
      count[text.charAt(i + j)]++;
      count[pattern.charAt(j)]--;
    }

    for (int k : count) {
      if (k > 0) {
        return false;
      }
    }

    return true;
  }

  /**
   * <b>Better Approach</b> <br>
   * Time Complexity: O(n) <br> Auxiliary Space: O(1)
   */
  private static boolean search2(String text, String pattern) {
    int[] cT = new int[256];
    int[] cP = new int[256];

    for (int i = 0; i < pattern.length(); i++) {
      cT[text.charAt(i)]++;
      cP[pattern.charAt(i)]++;
    }

    for (int i = pattern.length(); i < text.length(); i++) {
      if (Arrays.equals(cT, cP)) {
        return true;
      } else {
        cT[text.charAt(i)]++;
        cT[text.charAt(i - pattern.length())]--;
      }
    }

    return Arrays.equals(cT, cP);
  }

  // Better approach: Single loop for initial population and then comparison
  // Time Complexity: O(n)
  // Auxiliary Space: O(1)
  private static boolean search3(String input, String str) {
    int[] inputFreq = new int[256];
    int[] strFreq = new int[256];

    for (int i = 0; i <= input.length() - str.length(); i++) {
      if (i < str.length()) {
        inputFreq[input.charAt(i)]++;
        strFreq[str.charAt(i)]++;
      } else {
        if (Arrays.equals(inputFreq, strFreq)) {
          return true;
        } else {
          inputFreq[input.charAt(i - str.length())]--;
          inputFreq[input.charAt(i)]++;
        }
      }
    }

    return Arrays.equals(inputFreq, strFreq);
  }
}
