package hashing.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortElementsByFrequency {

  public static void main(String[] args) {
//    int[] arr = {5, 5, 4, 6, 4};
//    int[] arr = {2, 5, 9, 9, 9};
    int[] arr = {4, 6, 9, 19, 2, 16, 13, 11, 16, 17, 16, 8, 12, 16, 12, 18}; // 16 16 16 16 12 12 2 4 6 8 9 11 13 17 18 19

//    System.out.println(sortByFreq(arr));
//    System.out.println(sortByFreq1(arr));
    System.out.println(sortByFreq2(arr));
  }

  /**
   * Using Comparator approach
   */
  // Function to sort the array according to frequency of elements.
  private static ArrayList<Integer> sortByFreq(int[] arr) {
    Map<Integer, Integer> lookup = new HashMap<>();
    for (int num : arr) {
      lookup.put(num, lookup.getOrDefault(num, 0) + 1);
    }

    ArrayList<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
    list.sort((o1, o2) -> {
      if (lookup.get(o1).intValue() != lookup.get(o2)) {
        return lookup.get(o2) - lookup.get(o1);
      } else {
        return o1 - o2;
      }
    });

    return list;
  }

  /**
   * Using QuickSort approach
   */
  private static ArrayList<Integer> sortByFreq1(int[] arr) {
    Node[] nodes = new Node[arr.length];
    Map<Integer, Integer> freqLookup = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      nodes[i] = new Node(arr[i], 0);
      freqLookup.put(arr[i], freqLookup.getOrDefault(arr[i], 0) + 1);
    }

    // Updating frequencies/count of each node in nodes array using the freqLookup.
    for (int i = 0; i < arr.length; i++) {
      nodes[i].count = freqLookup.getOrDefault(arr[i], 0);
    }

    System.out.println(Arrays.toString(nodes));
    quickSort(nodes, 0, nodes.length - 1);
    return Arrays.stream(nodes).map(Node::getValue).collect(Collectors.toCollection(ArrayList::new));
  }

  private static void quickSort(Node[] nodes, int start, int end) {
    if (start < end) {
      int pivot = partition(nodes, start, end);
      quickSort(nodes, start, pivot);
      quickSort(nodes, pivot + 1, end);
    }
  }

  // Using hoare partition method for better performance
  private static int partition(Node[] nodes, int start, int end) {
    Node pivot = nodes[start];
    int i = start - 1;
    int j = end + 1;

    while (i < j) {
      do {
        i++;
      } while (nodes[i].count > pivot.count || (nodes[i].count == pivot.count && nodes[i].value < pivot.value));

      do {
        j--;
      } while (nodes[j].count < pivot.count || (nodes[j].count == pivot.count && nodes[j].value > pivot.value));

      if (i < j) {
        swap(nodes, i, j);
      }
    }

    return j;
  }

  private static void swap(Node[] nodes, int i, int j) {
    Node temp = nodes[i];
    nodes[i] = nodes[j];
    nodes[j] = temp;
  }

  private static ArrayList<Integer> sortByFreq2(int[] arr) {
    HashMap<Integer, Integer> lookup = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      lookup.put(arr[i], lookup.getOrDefault(arr[i], 0) + 1);
    }

    quickSortByFreq(arr, 0, arr.length - 1, lookup);

    return new ArrayList<>(Arrays.stream(arr).boxed().toList());
  }

  private static void quickSortByFreq(int[] arr, int start, int end, HashMap<Integer, Integer> lookup) {
    if (start < end) {
      int pivot = partition(arr, start, end, lookup);
      quickSortByFreq(arr, start, pivot - 1, lookup);
      quickSortByFreq(arr, pivot + 1, end, lookup);
    }
  }

  private static int partition(int[] arr, int start, int end, HashMap<Integer, Integer> lookup) {
    int pivot = arr[end];
    int index = start - 1;

    int pF = lookup.getOrDefault(pivot, 0);

    for (int i = start; i <= end; i++) {
      int f1 = lookup.getOrDefault(arr[i], 0);
      if (f1 == pF) {
        if (arr[i] < pivot) {
          index++;
          swap(arr, index, i);
        }
      } else if (f1 > pF) {
        index++;
        swap(arr, index, i);
      }
    }

    swap(arr, index + 1, end);
    return index + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static class Node {

    private int value;
    private int count;

    Node(int value, int count) {
      this.value = value;
      this.count = count;
    }

    public int getValue() {
      return this.value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public int getCount() {
      return this.count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public String toString() {
      return "{" + this.value + ", " + this.count + "}";
    }
  }
}
