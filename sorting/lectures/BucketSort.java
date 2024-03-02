package sorting.lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

  public static void main(String[] args) {
    testBucketSort();
  }

  private static void sort(int[] arr, int k) {

    // Finding the max in the array
    int max = arr[0];
    for (int i : arr) {
      max = Math.max(max, i);
    }

    // Incrementing the max by 1, so that the maximum element falls in the last bucket. Else it will fall in
    // (k + 1)th bucket, which does not exist.
    max++;

    // Adding k buckets to the list of buckets
    ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      buckets.add(new ArrayList<>());
    }

    // Adding the elements to the buckets one by one.
    for (int j : arr) {
      int bucket = k * j / max;
      buckets.get(bucket).add(j);
    }

    // Sorting each bucket
    for (int i = 0; i < k; i++) {
      Collections.sort(buckets.get(i));
    }

    int index = 0;
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < buckets.get(i).size(); j++) {
        arr[index++] = buckets.get(i).get(j);
      }
    }
  }

  private static void testBucketSort() {
    int[] arr = {30, 40, 10, 80, 5, 12, 70};
    sort(arr, 4);
    System.out.println(Arrays.toString(arr));
  }
}
