package array.problems;

import java.util.HashMap;

public class FruitIntoBaskets {

  public static void main(String[] args) {
//    Integer[] arr = new Integer[]{13, 3, 10, 2, 8, 9, 10, 9, 4, 16, 3, 2, 11, 1, 9, 17, 10};
//    Integer[] arr = new Integer[]{1, 2, 1};
    Integer[] arr = new Integer[]{0, 1, 2, 2};
//    Integer[] arr = new Integer[]{1, 2, 3, 2, 2};

    System.out.println(Solution.totalFruits(arr));
    System.out.println();
    System.out.println(Solution.totalFruits1(arr));
  }

  static class Solution {

    public static int totalFruits1(Integer[] arr) {
      int lastFruit = -1;
      int secondLastFruit = -1;
      int lastFruitCount = 0;
      int currMax = 0;
      int max = 0;

      for (Integer fruit : arr) {
        if (fruit == lastFruit || fruit == secondLastFruit) {
          currMax++;
        } else {
          currMax = lastFruitCount + 1;
        }

        if (fruit == lastFruit) {
          lastFruitCount++;
        } else {
          secondLastFruit = lastFruit;
          lastFruit = fruit;
          lastFruitCount = 1;
        }

        max = Math.max(max, currMax);
      }

      return max;
    }

    // Incorrect
    public static int totalFruits(Integer[] arr) {
      HashMap<Integer, Integer> lookup = new HashMap<>();
      int start = 0;
      int max = 0;
      int currMax = 0;

      for (int i = 0; i < arr.length; i++) {
        lookup.put(arr[i], lookup.getOrDefault(arr[i], 0) + 1);

        if (lookup.size() <= 2) {
          currMax = (i - start + 1);
        } else {
          while (lookup.size() > 2) {
            Integer fruit = arr[start];
            lookup.put(fruit, lookup.get(fruit) - 1);
            if (lookup.get(fruit) == 0) {
              lookup.remove(fruit);
            }

            start++;
          }
        }

        max = Math.max(max, currMax);
      }

      return max;
    }
  }
}
