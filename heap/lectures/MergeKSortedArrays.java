package heap.lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {

  public static void execute(int[][] arr) {
    if (arr.length == 0 || arr[0].length == 0) {
      return;
    }

    ArrayList<Integer> res = new ArrayList<>();

    for (int[] rows : arr) {
      for (int col : rows) {
        res.add(col);
      }
    }

    res.sort(Integer::compare);
    System.out.println(res);
  }

  public static void execute1(int[][] arr) {
    if (arr.length == 0 || arr[0].length == 0) {
      return;
    }

    ArrayList<Integer> res = new ArrayList<>();

    for (int[] row : arr) {
      Integer[] temp = new Integer[res.size()];
      res.toArray(temp);
      res.removeAll(Arrays.asList(temp));

      int j = 0;
      int k = 0;
      while (j < row.length && k < temp.length) {
        if (row[j] <= temp[k]) {
          res.add(row[j++]);
        } else {
          res.add(temp[k++]);
        }
      }

      while (j < row.length) {
        res.add(row[j++]);
      }

      while (k < temp.length) {
        res.add(temp[k++]);
      }
    }

    System.out.println(res);
  }

  public static void execute2(int[][] arr) {
    if (arr.length == 0 || arr[0].length == 0) {
      return;
    }

    List<Integer> res = new ArrayList<>();
    Queue<Triplet> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

    for (int i = 0; i < arr.length; i++) {
      queue.add(new Triplet(arr[i][0], i, 0));
    }

    while (!queue.isEmpty()) {
      Triplet triplet = queue.remove();
      res.add(triplet.value);

      if (triplet.valPos + 1 < arr[triplet.arrayPos].length) {
        queue.add(new Triplet(arr[triplet.arrayPos][triplet.valPos + 1], triplet.arrayPos, triplet.valPos + 1));
      }
    }

    System.out.println(res);
  }

  private static class Triplet {

    int value;
    int arrayPos;
    int valPos;

    public Triplet(int value, int arrayPos, int valPos) {
      this.value = value;
      this.arrayPos = arrayPos;
      this.valPos = valPos;
    }
  }
}
