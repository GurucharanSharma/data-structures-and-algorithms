package array.lectures;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int[] array = new int[]{10, 10, 10, 10, 10, 10};

    // Print the array
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }

    // Remove duplicates from the array and get the new size
//    int size = removeDuplicates(array);
    int size = removeDuplicates1(array);
    System.out.println();

    // Unique array
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
  }

  // Efficient Approach 1
  static int removeDuplicates(int[] array) {
    int size = 1;

    for (int i = 1; i < array.length; i++) {
      if (array[i] != array[i - 1]) {
        array[size++] = array[i];
      }
    }

    return size;
  }

  // Efficient Approach 2
  static int removeDuplicates1(int[] arr) {
    int n = arr.length;
    int start = 0;

    for (int i = 0; i < n; i++) {
      while (i > 0 && i < n && arr[i] == arr[i - 1]) {
        i++;
      }

      if (i < n) {
        arr[start] = arr[i];
        start++;
      }
    }

    return start;
  }

  // Naive Approach
  private static int removeDuplicates2(int[] arr) {
    int[] temp = new int[arr.length];

    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        temp[index++] = arr[i];
      } else if (arr[i] != arr[i - 1]) {
        temp[index++] = arr[i];
      }
    }

    if (index >= 0) {
      System.arraycopy(temp, 0, arr, 0, index);
    }

    return index;
  }

  // Efficient Approach: Using Hashset
  private static int removeDuplicates3(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    int i = 0;
    for (Integer e : set) {
      arr[i++] = e;
    }

    return set.size();
  }
}
