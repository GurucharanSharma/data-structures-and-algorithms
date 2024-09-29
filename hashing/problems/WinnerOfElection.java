package hashing.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinnerOfElection {

  public static void main(String[] args) {
    String[] arr = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
//    String[] arr = {"andy", "blake", "clark"};

    System.out.println(Arrays.toString(winner(arr, arr.length)));
    System.out.println();
    System.out.println(Arrays.toString(winner1(arr, arr.length)));
  }

  //Function to return the name of candidate that received maximum votes.
  public static String[] winner(String[] arr, int n) {
    HashMap<String, Integer> freqLookup = new HashMap<>();
    for (String str : arr) {
      freqLookup.put(str, freqLookup.getOrDefault(str, 0) + 1);
    }

    Arrays.sort(arr, (o1, o2) -> {
      if (freqLookup.get(o1).intValue() != freqLookup.get(o2)) {
        return freqLookup.get(o2) - freqLookup.get(o1);
      } else {
        return o1.compareTo(o2);
      }
    });

    return new String[]{arr[0], String.valueOf(freqLookup.get(arr[0]))};
  }

  //Function to return the name of candidate that received maximum votes.
  public static String[] winner1(String[] arr, int n) {
    HashMap<String, Integer> freqLookup = new HashMap<>();
    for (String str : arr) {
      freqLookup.put(str, freqLookup.getOrDefault(str, 0) + 1);
    }

    String[] winner = new String[]{arr[0], String.valueOf(freqLookup.get(arr[0]))};
    for (Map.Entry<String, Integer> entry : freqLookup.entrySet()) {
      if (entry.getValue() > Integer.parseInt(winner[1]) ||
          (entry.getValue() == Integer.parseInt(winner[1]) && entry.getKey().compareTo(winner[0]) < 0)) {
        winner[0] = entry.getKey();
        winner[1] = String.valueOf(entry.getValue());
      }
    }

    return winner;
  }
}
