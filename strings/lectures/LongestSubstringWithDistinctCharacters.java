package strings.lectures;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithDistinctCharacters {

  public static void main(String[] args) {
    System.out.println("Naive Approach: ");
    System.out.println(longestDistinct("applesauce"));
    System.out.println(longestDistinct("jjjjjjjjj"));
    System.out.println(longestDistinct("jjjjwertyui"));
    System.out.println();

    System.out.println("Better Approach 1: ");
    System.out.println(longestDistinct1("applesauce"));
    System.out.println(longestDistinct1("jjjjjjjjj"));
    System.out.println(longestDistinct1("jjjjwertyui"));
    System.out.println();

    System.out.println("Better Approach 2: ");
    System.out.println(longestDistinct2("applesauce"));
    System.out.println(longestDistinct2("jjjjjjjjj"));
    System.out.println(longestDistinct2("jjjjwertyui"));
    System.out.println();

    System.out.println("Better Approach 3: ");
    System.out.println(longestDistinct3("applesauce"));
    System.out.println(longestDistinct3("jjjjjjjjj"));
    System.out.println(longestDistinct3("jjjjwertyui"));
    System.out.println();
  }

  /**
   * Naive Approach <br> Time Complexity: O(n<sup>3</sup>) <br> Auxiliary Space: O(1)
   */
  private static int longestDistinct(String str) {
    int res = 0;

    for (int i = 0; i < str.length(); i++) {
      for (int j = i; j < str.length(); j++) {
        if (areDistinct(str, i, j)) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  private static boolean areDistinct(String str, int start, int end) {
    boolean[] visited = new boolean[256];

    for (int i = start; i <= end; i++) {
      if (visited[str.charAt(i)]) {
        return false;
      } else {
        visited[str.charAt(i)] = true;
      }
    }

    return true;
  }

  /**
   * Better Approach 1 <br> Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static int longestDistinct1(String str) {
    int res = 0;

    for (int i = 0; i < str.length(); i++) {
      boolean[] visited = new boolean[256];
      for (int j = i; j < str.length(); j++) {
        if (visited[str.charAt(j)]) {
          break;
        } else {
          res = Math.max(res, j - i + 1);
          visited[str.charAt(j)] = true;
        }
      }
    }

    return res;
  }

  /**
   * Better Approach 2 <br> Time Complexity: O(n) <br> Auxiliary Space: O(1)
   */
  private static int longestDistinct2(String str) {
    int[] prev = new int[256];
    int res = 0;
    int i = 0; // denotes start of current window

    // Initialize the array with -1
    Arrays.fill(prev, -1);

    for (int j = 0; j < str.length(); j++) {
      i = Math.max(i, prev[str.charAt(j)] + 1);
      res = Math.max(res, j - i + 1);
      prev[str.charAt(j)] = j;
    }

    return res;
  }

  // Using HashMap
  private static int longestDistinct3(String input) {
    HashMap<Character, Integer> indexLookup = new HashMap<>();

    int result = 0;
    int index = 0;
    for (int i = 0; i < input.length(); i++) {
      index = Math.max(index, indexLookup.getOrDefault(input.charAt(i), 0));
      result = Math.max(result, i - index);
      indexLookup.put(input.charAt(i), i);
    }

    return result;
  }
}
