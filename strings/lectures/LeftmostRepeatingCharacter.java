package strings.lectures;

import java.util.Arrays;

public class LeftmostRepeatingCharacter {

  private final static int CHAR = 256;

  /**
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static int getLeftmostRepeatingCharacter(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j < str.length(); j++) {
        if (str.charAt(i) == str.charAt(j)) {
          return i;
        }
      }
    }

    return -1;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(1) <br>
   * <b>NOTE:</b> It traverses twice through the string.
   */
  private static int getLeftmostRepeatingCharacter1(String str) {
    int[] count = new int[CHAR];

    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i)]++;
    }

    for (int i = 0; i < str.length(); i++) {
      if (count[str.charAt(i)] > 1) {
        return i;
      }
    }

    return -1;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(1)
   */
  private static int getLeftmostRepeatingCharacter2(String str) {
    int[] fIndex = new int[CHAR];
    Arrays.fill(fIndex, -1);
    int res = Integer.MAX_VALUE;

    for (int i = 0; i < str.length(); i++) {
      int fi = fIndex[str.charAt(i)];
      if (fi == -1) {
        fIndex[str.charAt(i)] = i;
      } else {
        res = Math.min(res, fi);
      }
    }

    return (res == Integer.MAX_VALUE) ? -1 : res;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(1)
   */
  private static int getLeftmostRepeatingCharacter3(String str) {
    boolean[] visited = new boolean[CHAR];
    int res = -1;

    for (int i = str.length() - 1; i >= 0; i--) {
      if (visited[str.charAt(i)]) {
        res = i;
      } else {
        visited[str.charAt(i)] = true;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    testGetLeftmostRepeatingCharacter();
  }

  private static void testGetLeftmostRepeatingCharacter() {
    String str = "cabbad";

    System.out.println("Naive: ");
    System.out.println(getLeftmostRepeatingCharacter(str));

    System.out.println("Optimised - 1: ");
    System.out.println(getLeftmostRepeatingCharacter1(str));

    System.out.println("Optimised - 2: ");
    System.out.println(getLeftmostRepeatingCharacter2(str));

    System.out.println("Optimised - 3: ");
    System.out.println(getLeftmostRepeatingCharacter3(str));
  }
}
