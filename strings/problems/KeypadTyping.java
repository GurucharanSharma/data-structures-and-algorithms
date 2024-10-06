package strings.problems;

import java.util.Map;

public class KeypadTyping {

  private static final Map<Character, Integer> keyLookup = Map.ofEntries(
      Map.entry('a', 2), Map.entry('b', 2), Map.entry('c', 2),
      Map.entry('d', 3), Map.entry('e', 3), Map.entry('f', 3),
      Map.entry('g', 4), Map.entry('h', 4), Map.entry('i', 4),
      Map.entry('j', 5), Map.entry('k', 5), Map.entry('l', 5),
      Map.entry('m', 6), Map.entry('n', 6), Map.entry('o', 6),
      Map.entry('p', 7), Map.entry('q', 7), Map.entry('r', 7), Map.entry('s', 7),
      Map.entry('t', 8), Map.entry('u', 8), Map.entry('v', 8),
      Map.entry('w', 9), Map.entry('x', 9), Map.entry('y', 9), Map.entry('z', 9)
  );

  public static void main(String[] args) {
//    String input = "geeksforgeeks";
//    String input = "geeksquiz";
    String input = "ph";

    System.out.println(printNumber(input, input.length()));
  }

  //Function to find matching decimal representation of a string as on the keypad.
  public static String printNumber(String s, int n) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      builder.append(keyLookup.get(s.charAt(i)));
    }

    return builder.toString();
  }
}
