package strings.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumOccuringCharacter {

  public static void main(String[] args) {
//    String str = "testsample";
    String str = "output";

    System.out.println(getMaxOccurringChar(str));
    System.out.println();
    System.out.println(getMaxOccurringChar1(str));
  }

  //Function to find the maximum occurring character in a string.
  public static char getMaxOccurringChar(String line) {
    Map<Character, Integer> freqLookup = new HashMap<>();
    for (int i = 0; i < line.length(); i++) {
      freqLookup.put(line.charAt(i), freqLookup.getOrDefault(line.charAt(i), 0) + 1);
    }

    int result = 0;
    char ch = 0;
    for (Entry<Character, Integer> entry : freqLookup.entrySet()) {
      if (entry.getValue() > result) {
        result = entry.getValue();
        ch = entry.getKey();
      } else if (entry.getValue() == result) {
        if (ch > entry.getKey()) {
          ch = entry.getKey();
        }
      }
    }

    return ch;
  }

  //Function to find the maximum occurring character in a string.
  public static char getMaxOccurringChar1(String line) {
    int[] freqLookup = new int[256];
    for (int i = 0; i < line.length(); i++) {
      freqLookup[line.charAt(i)]++;
    }

    int result = 0;
    char ch = 0;
    for (int i = 0; i < line.length(); i++) {
      if (freqLookup[line.charAt(i)] > result) {
        result = freqLookup[line.charAt(i)];
        ch = line.charAt(i);
      } else if (freqLookup[line.charAt(i)] == result) {
        if (ch > line.charAt(i)) {
          ch = line.charAt(i);
        }
      }
    }

    return ch;
  }
}
