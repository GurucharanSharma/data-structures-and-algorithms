package recursion.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PowerSetUsingRecursion {

  public static void main(String[] args) {
    String str = "abc";

    List<String> subsets = powerSet(str);
    subsets.sort(Comparator.naturalOrder());
    System.out.println(subsets);
  }

  //Function to return the lexicographically sorted power-set of the string.
  private static ArrayList<String> powerSet(String s) {
    ArrayList<String> subsets = new ArrayList<>();
    generatePowerSet(subsets, s, "", 0);
    Collections.sort(subsets);

    return subsets;
  }

  private static void generatePowerSet(ArrayList<String> subsets, String s, String c, int i) {
    if (i == s.length()) {
      subsets.add(c);
      return;
    }

    generatePowerSet(subsets, s, c, i + 1);
    generatePowerSet(subsets, s, c + s.charAt(i), i + 1);
  }
}
