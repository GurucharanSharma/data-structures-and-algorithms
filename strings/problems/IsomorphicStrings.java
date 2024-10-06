package strings.problems;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  public static void main(String[] args) {
//    String str1 = "aab";
//    String str2 = "xxy";

//    String str1 = "aab";
//    String str2 = "xyz";

//    String str1 = "aba";
//    String str2 = "xyy";

    String str1 = "rfkqyuqf";
    String str2 = "jkxyqvnr";

    System.out.println(areIsomorphic(str1, str2));
    System.out.println();
    System.out.println(areIsomorphic1(str1, str2));
    System.out.println();
    System.out.println(areIsomorphic2(str1, str2));
  }

  // Function to check if two strings are isomorphic.
  // Check if two given strings are isomorphic to each other using Mapping
  public static boolean areIsomorphic(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    Map<Character, Character> charLookup = new HashMap<>();
    Map<Character, Boolean> visitLookup = new HashMap<>();

    for (int i = 0; i < str2.length(); i++) {
      if (charLookup.containsKey(str1.charAt(i))) {
        if (charLookup.get(str1.charAt(i)) != str2.charAt(i)) {
          return false;
        }
      } else {
        // The below statement means that the character is different in the first string but same characters in the second string
        // For e.g. str1 = "abc" and str2 = "xxy". Here visitLookup(x) is true for second x, but the key b is not there in the charLookup.
        // This will result is a different key for x in str1 and multiple keys for one value are not allowed. Hence, we return false.
        if (visitLookup.getOrDefault(str2.charAt(i), false)) {
          return false;
        }

        visitLookup.put(str2.charAt(i), true);
        charLookup.put(str1.charAt(i), str2.charAt(i));
      }
    }

    return true;
  }

  // Function to check if two strings are isomorphic.
  // Using array for keep track of the visited elements in str2.
  public static boolean areIsomorphic1(String str1, String str2) {
    Map<Character, Character> keyLookup = new HashMap<>();
    boolean[] visited = new boolean[256];

    for (int i = 0; i < str2.length(); i++) {
      if (keyLookup.containsKey(str1.charAt(i))) {
        if (keyLookup.get(str1.charAt(i)) != str2.charAt(i)) {
          return false;
        }
      } else {
        if (visited[str2.charAt(i)]) {
          return false;
        }

        visited[str2.charAt(i)] = true;
        keyLookup.put(str1.charAt(i), str2.charAt(i));
      }
    }

    return true;
  }

  // Function to check if two strings are isomorphic.
  // Check if two given strings are isomorphic to each other using single Hashmap.
  public static boolean areIsomorphic2(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    Map<Character, Character> charLookup = new HashMap<>();

    for (int i = 0; i < str2.length(); i++) {
      if (charLookup.containsKey(str1.charAt(i))) {
        if (charLookup.get(str1.charAt(i)) != str2.charAt(i)) {
          return false;
        }
      } else if (!charLookup.containsValue(str2.charAt(i))) {
        charLookup.put(str1.charAt(i), str2.charAt(i));
      } else {
        return false;
      }
    }

    return true;
  }
}
