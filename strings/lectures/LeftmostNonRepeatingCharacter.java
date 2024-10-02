package strings.lectures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class LeftmostNonRepeatingCharacter {

  private final static int CHAR = 256;

  public static void main(String[] args) {
    testGetLeftmostNonRepeatingCharacter();
  }

  /**
   * Time Complexity: O(n<sup>2</sup>) <br> Auxiliary Space: O(1)
   */
  private static int getLeftmostNonRepeatingCharacter(String str) {
    for (int i = 0; i < str.length(); i++) {
      boolean flag = false;

      for (int j = 0; j < str.length(); j++) {
        if (i != j && str.charAt(i) == str.charAt(j)) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        return i;
      }
    }

    return -1;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(1) <br>
   * <b>NOTE:</b> It traverses twice through the string.
   */
  private static int getLeftmostNonRepeatingCharacter1(String str) {
    int[] count = new int[CHAR];

    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i)]++;
    }

    for (int i = 0; i < str.length(); i++) {
      if (count[str.charAt(i)] == 1) {
        return i;
      }
    }

    return -1;
  }

  /**
   * Time Complexity: O(n) <br> Auxiliary Space: O(1) <br>
   * <b>NOTE:</b> It traverses only once through the string.
   */
  private static int getLeftmostNonRepeatingCharacter2(String str) {
    int[] fIndex = new int[CHAR];
    Arrays.fill(fIndex, -1);

    for (int i = 0; i < str.length(); i++) {
      if (fIndex[str.charAt(i)] == -1) {
        fIndex[str.charAt(i)] = i;
      } else {
        fIndex[str.charAt(i)] = -2;
      }
    }

    int res = Integer.MAX_VALUE;
    for (int index : fIndex) {
      if (index >= 0) {
        res = Math.min(res, index);
      }
    }

    System.out.println(Arrays.toString(fIndex));

    return res == Integer.MAX_VALUE ? -1 : res;
  }

  // Using HashMap
  // NOTE: It traverses twice through the input string
  private static int getLeftmostNonRepeatingCharacter3(String input) {
    HashMap<Character, Integer> freqLookup = new HashMap<>();
    HashMap<Character, Integer> indexLookup = new HashMap<>();

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      freqLookup.put(ch, freqLookup.getOrDefault(ch, 0) + 1);
      indexLookup.put(ch, indexLookup.getOrDefault(ch, i));
    }

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (freqLookup.containsKey(ch) && freqLookup.get(ch) == 1) {
        return indexLookup.get(ch);
      }
    }

    return -1;
  }

  // Using HashMap
  // NOTE: It traverses only once through the input string
  private static int getLeftmostNonRepeatingCharacter4(String input) {
    HashMap<Character, Integer> freqLookup = new HashMap<>();
    HashMap<Character, Integer> indexLookup = new HashMap<>();

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      freqLookup.put(ch, freqLookup.getOrDefault(ch, 0) + 1);
      indexLookup.put(ch, indexLookup.getOrDefault(ch, i));
    }

    int result = Integer.MAX_VALUE;
    for (Entry<Character, Integer> entry : freqLookup.entrySet()) {
      if (entry.getValue() == 1) {
        result = Math.min(result, indexLookup.get(entry.getKey()));
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private static void testGetLeftmostNonRepeatingCharacter() {
    String str = "geeksforgeeks";

    System.out.println("Naive: ");
    System.out.println(getLeftmostNonRepeatingCharacter(str));

    System.out.println("Optimised - 1: ");
    System.out.println(getLeftmostNonRepeatingCharacter1(str));

    System.out.println("Optimised - 2: ");
    System.out.println(getLeftmostNonRepeatingCharacter2(str));
  }
}
