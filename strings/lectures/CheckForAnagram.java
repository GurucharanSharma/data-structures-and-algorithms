package strings.lectures;

import java.util.Arrays;

public class CheckForAnagram {

  private static final int CHAR = 256;

  /**
   * Time Complexity: O(n * log(n)) <br> Auxiliary Space: O(n + m) - (we create extra array for each string to sort it)
   */
  private static boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();

    Arrays.sort(charArray1);
    Arrays.sort(charArray2);

    str1 = new String(charArray1);
    str2 = new String(charArray2);

    return str1.equals(str2);
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(1) - (The extra array created is always of constant length)
   */
  private static boolean isAnagram1(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    int[] count = new int[CHAR];
    for (int i = 0; i < str1.length(); i++) {
      count[str1.charAt(i)]++;
      count[str2.charAt(i)]--;
    }

    for (int j : count) {
      if (j != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    testIsAnagram();
  }

  private static void testIsAnagram() {
    String str1 = "anbjkhjd";
    String str2 = "djhkjbna";

    System.out.println("Naive:");
    System.out.println(isAnagram(str1, str2));

    System.out.println("\nOptimised:");
    System.out.println(isAnagram1(str1, str2));
  }
}
