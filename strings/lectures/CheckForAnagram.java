package strings.lectures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

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

  // Using HashMap
  private static boolean isAnagram2(String input, String pattern) {
    assert input.length() == pattern.length();

    HashMap<Character, Integer> freqLookup = new HashMap<>();
    for (int i = 0; i < input.length(); i++) {
      freqLookup.put(input.charAt(i), freqLookup.getOrDefault(input.charAt(i), 0) + 1);
      freqLookup.put(pattern.charAt(i), freqLookup.getOrDefault(pattern.charAt(i), 0) - 1);
    }

    for (Entry<Character, Integer> entry : freqLookup.entrySet()) {
      if (entry.getValue() != 0) {
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

    System.out.println("\nOptimised - 1:");
    System.out.println(isAnagram1(str1, str2));

    System.out.println("\nOptimised - 2:");
    System.out.println(isAnagram2(str1, str2));
  }
}
