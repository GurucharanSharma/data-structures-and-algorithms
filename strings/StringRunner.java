package strings;

import java.util.Arrays;

public class StringRunner {

  public static void main(String[] args) {
    String input = "iojijegfthdergt";
    String str = "iijo";

    System.out.println(isAnagram(input, str));
  }

  private static boolean isAnagram(String input, String str) {
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

    return false;
  }
}
