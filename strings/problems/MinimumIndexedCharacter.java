package strings.problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexedCharacter {

  public static void main(String[] args) {
//    String str = "geeksforgeeks";
//    String patt = "set";

    String str = "adcffaet";
    String patt = "onkl";

    System.out.println(minIndexChar(str, patt));
    System.out.println();
    System.out.println(minIndexChar1(str, patt));
    System.out.println();
    System.out.println(minIndexChar2(str, patt));
    System.out.println();
    System.out.println(minIndexChar3(str, patt));
  }

  // Function to find the minimum indexed character.
  // Naive approach: Using 2 loops to check for minumum index
  // Time Complexity: O(n^2)
  // Auxiliary Space: O(1)
  public static int minIndexChar(String str, String patt) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = 0; j < patt.length(); j++) {
        if (str.charAt(i) == patt.charAt(j)) {
          return i;
        }
      }
    }

    return -1;
  }

  // Function to find the minimum indexed character.
  // Time Complexity: O(n)
  // Auxiliary Space: O(1)
  public static int minIndexChar1(String str, String patt) {
    int[] fStr = new int[256];
    int[] fPatt = new int[256];

    for (int i = 0; i < str.length(); i++) {
      fStr[str.charAt(i)]++;
    }

    for (int i = 0; i < patt.length(); i++) {
      fPatt[patt.charAt(i)]++;
    }

    for (int i = 0; i < str.length(); i++) {
      if (fStr[str.charAt(i)] != 0 && fPatt[str.charAt(i)] != 0) {
        return i;
      }
    }

    return -1;
  }

  // Function to find the minimum indexed character.
  // Time Complexity: O(n)
  // Auxiliary Space: O(1)
  public static int minIndexChar2(String str, String patt) {
    Map<Character, Integer> indexLookup = new HashMap<>();
    int minIndex = Integer.MAX_VALUE;

    for (int i = 0; i < str.length(); i++) {
      indexLookup.put(str.charAt(i), indexLookup.getOrDefault(str.charAt(i), i));
    }

    for (int i = 0; i < patt.length(); i++) {
      if (indexLookup.containsKey(patt.charAt(i))) {
        minIndex = Math.min(minIndex, indexLookup.get(patt.charAt(i)));
      }
    }

    return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
  }

  public static int minIndexChar3(String str, String patt) {
    int[] freq = new int[256];
    for (int i = 0; i < patt.length(); i++) {
      freq[patt.charAt(i)]++;
    }

    for (int i = 0; i < str.length(); i++) {
      if (freq[str.charAt(i)] > 0) {
        return i;
      }
    }

    return -1;
  }

  public static int minIndexChar4(String str, String patt) {
    Map<Character, Integer> indexLookup = new HashMap<>();
    for (int i = 0; i < patt.length(); i++) {
      indexLookup.put(patt.charAt(i), i);
    }

    for (int i = 0; i < str.length(); i++) {
      if (indexLookup.containsKey(str.charAt(i))) {
        return i;
      }
    }

    return -1;
  }
}
