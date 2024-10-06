package strings.lectures;

import java.util.ArrayList;
import java.util.List;

public class CheckForRotations {

  public static void main(String[] args) {
//    String input = "ABCD";
//    String pattern = "CDAB";

//    String input = "ABAAA";
//    String pattern = "BAAAA";

    String input = "ABAB";
    String pattern = "ABBA";

    System.out.println(isRotation(input, pattern));
    System.out.println();
    System.out.println(isRotation1(input, pattern));
    System.out.println();
    System.out.println(isRotation2(input, pattern));
  }

  private static boolean isRotation(String input, String pattern) {
    if (input.length() != pattern.length()) {
      return false;
    }

    return (input.equals(pattern)) || (input + input).contains(pattern);
  }

  private static boolean isRotation1(String input, String pattern) {
    if (input.length() != pattern.length()) {
      return false;
    }

    List<Integer> indexLookup = new ArrayList<>();
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) == input.charAt(0)) {
        indexLookup.add(i);
      }
    }

    for (int index : indexLookup) {
      if (checkRotation(input, pattern, index, input.length())) {
        return true;
      }
    }

    return false;
  }

  private static boolean checkRotation(String input, String pattern, int index, int length) {
    for (int i = 0; i < input.length(); i++) {
      int pIndex = (i + index) % input.length();
      if (input.charAt(i) != pattern.charAt(pIndex)) {
        return false;
      }
    }

    return true;
  }

  private static boolean isRotation2(String input, String pattern) {
    if (input.length() != pattern.length()) {
      return false;
    }

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == pattern.charAt(0)) {
        if (input.substring(i).equals(pattern.substring(0, input.length() - i))) {
          if (input.substring(0, i).equals(pattern.substring(input.length() - i))) {
            return true;
          }
        }
      }
    }

    return false;
  }
}
