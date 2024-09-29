package hashing.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SortArrayAccordingToAnother {

  public static void main(String[] args) {
    int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    int[] A2 = {2, 1, 8, 3};

//    int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
//    int[] A2 = {99, 22, 444, 56};

    System.out.println(Arrays.toString(sortA1ByA2(A1, A1.length, A2, A2.length)));
    System.out.println(Arrays.toString(sortA1ByA21(A1, A1.length, A2, A2.length)));
  }

  // A1[] : the input array-1
  // N : size of the array A1[]
  // A2[] : the input array-2
  // M : size of the array A2[]
  //Function to sort an array according to the other array.
  public static int[] sortA1ByA2(int[] A1, int N, int[] A2, int M) {
    HashMap<Integer, Integer> freqLookup = new HashMap<>();
    for (int n : A1) {
      freqLookup.put(n, freqLookup.getOrDefault(n, 0) + 1);
    }

    List<Integer> left = new ArrayList<>();
    for (int n : A2) {
      int count = freqLookup.getOrDefault(n, 0);
      while (count > 0) {
        left.add(n);
        count--;
      }

      freqLookup.remove(n);
    }

    List<Integer> right = new ArrayList<>();
    for (Entry<Integer, Integer> entry : freqLookup.entrySet()) {
      int count = freqLookup.getOrDefault(entry.getKey(), 0);
      while (count > 0) {
        right.add(entry.getKey());
        count--;
      }
    }

    Collections.sort(right);

    left.addAll(right);
    return left.stream().mapToInt(Integer::intValue).toArray();
  }

  // A1[] : the input array-1
  // N : size of the array A1[]
  // A2[] : the input array-2
  // M : size of the array A2[]
  //Function to sort an array according to the other array.
  public static int[] sortA1ByA21(int[] A1, int N, int[] A2, int M) {
    HashMap<Integer, Integer> indexLookup = new HashMap<>();
    for (int i = 0; i < M; i++) {
      if (!indexLookup.containsKey(A2[i])) {
        indexLookup.put(A2[i], i + 1);
      }
    }

    return Arrays.stream(A1).boxed()
        .sorted((o1, o2) -> {
          int idx1 = indexLookup.getOrDefault(o1, -1);
          int idx2 = indexLookup.getOrDefault(o2, -1);

          if (idx1 == -1 && idx2 == -1) {
            return o1 - o2;
          } else if (idx1 == -1) {
            return 1;
          } else if (idx2 == -1) {
            return -1;
          } else {
            return idx1 - idx2;
          }
        })
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
