package hashing.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortElementsByFrequency {

  public static void main(String[] args) {
    int[] arr = {5, 5, 4, 6, 4};
//    int[] arr = {2, 5, 9, 9, 9};

    System.out.println(sortByFreq(arr));
  }

  // Function to sort the array according to frequency of elements.
  private static ArrayList<Integer> sortByFreq(int[] arr) {
    Map<Integer, Integer> lookup = new HashMap<>();
    for (int num : arr) {
      lookup.put(num, lookup.getOrDefault(num, 0) + 1);
    }

    Map<Integer, Integer> sortedByValue = lookup.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    ArrayList<Integer> list = new ArrayList<>();
    for (Entry<Integer, Integer> entry : sortedByValue.entrySet()) {
      int i = entry.getValue() - 1;
      while (i >= 0) {
        list.add(entry.getKey());
        i--;
      }
    }

    return list;
  }
}
