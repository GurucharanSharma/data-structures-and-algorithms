package sorting.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

  public static void main(String[] args) {
    int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.intervalIntersection(firstList, secondList)));
    System.out.println();
    System.out.println(Arrays.deepToString(solution.intervalIntersection1(firstList, secondList)));
  }

  static class Solution {

    public int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {
      int i = 0;
      int j = 0;

      List<int[]> intervals = new ArrayList<>();

      while (i < firstList.length && j < secondList.length) {
        if (firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) {
          int start = Math.max(firstList[i][0], secondList[j][0]);
          int end = Math.min(firstList[i][1], secondList[j][1]);

          intervals.add(new int[]{start, end});
        }

        if (firstList[i][1] < secondList[j][1]) {
          i++;
        } else {
          j++;
        }
      }

      return intervals.toArray(int[][]::new);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      int i = 0;
      int j = 0;

      List<List<Integer>> intervals = new ArrayList<>();

      while (i < firstList.length && j < secondList.length) {
        if (firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) {
          int start = Math.max(firstList[i][0], secondList[j][0]);
          int end = Math.min(firstList[i][1], secondList[j][1]);

          intervals.add(List.of(start, end));
        }

        if (firstList[i][1] < secondList[j][1]) {
          i++;
        } else {
          j++;
        }
      }

      return intervals.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
  }
}
