package strings.problems;

import java.util.HashMap;
import java.util.Map;

public class Isogram {

  public static void main(String[] args) {
//    String data = "geeks";
    String data = "machine";

    System.out.println(isIsogram(data));
    System.out.println();
    System.out.println(isIsogram1(data));
    System.out.println();
    System.out.println(isIsogram2(data));
  }

  // Naive Approach
  private static boolean isIsogram(String data) {
    for (int i = 0; i < data.length(); i++) {
      for (int j = i + 1; j < data.length(); j++) {
        if (data.charAt(i) == data.charAt(j)) {
          return false;
        }
      }
    }

    return true;
  }

  // Efficient Approach 1: Using Array
  static boolean isIsogram1(String data) {
    boolean[] visited = new boolean[256];
    for (int i = 0; i < data.length(); i++) {
      if (visited[data.charAt(i)]) {
        return false;
      } else {
        visited[data.charAt(i)] = true;
      }
    }

    return true;
  }

  // Efficient Approach 2: Using HashMap
  private static boolean isIsogram2(String data) {
    Map<Character, Boolean> lookup = new HashMap<>();
    for (int i = 0; i < data.length(); i++) {
      char ch = data.charAt(i);
      if (lookup.getOrDefault(ch, false)) {
        return false;
      } else {
        lookup.put(ch, true);
      }
    }

    return true;
  }
}
