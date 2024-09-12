package searching.problems;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 7, 5};
    int s = 12;

    System.out.println(subarraySum(A, A.length, s));
    System.out.println(subarraySum1(A, A.length, s));
    System.out.println(subarraySum2(A, A.length, s));
  }

  //Function to find a continuous sub-array which adds up to a given number.
  private static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
    // Your code here
    ArrayList<Integer> range = new ArrayList<>();
    int start = 0;
    int end = 1;
    int sum = arr[start];

    if (s == 0) {
      range.add(-1);
      return range;
    } else if (arr[0] == s) {
      range.add(1);
      range.add(1);
      return range;
    }

    while (start <= end && start <= n && end <= n) {
      //System.out.println(start + " " + end + " " + sum);
      if (sum == s) {
        range.add(start + 1);
        range.add(end);
        return range;
      } else if (sum < s) {
        sum += arr[end];
        end++;
      } else {
        sum = sum - arr[start];
        start++;
      }
    }

    range.add(-1);
    return range;
  }

  //Function to find a continuous sub-array which adds up to a given number.
  private static ArrayList<Integer> subarraySum1(int[] arr, int n, int s) {
    ArrayList<Integer> range = new ArrayList<>();
    int sum = 0;
    int start = 0;

    if (s == 0) {
      range.add(-1);
      return range;
    }

    for (int i = 0; i < n; i++) {
      //System.out.println(start + " " + i + " " + sum);
      sum = sum + arr[i];
      while (sum > s) {
        sum = sum - arr[start++];
      }

      if (sum == s) {
        range.add(start + 1);
        range.add(i + 1);
        return range;
      }
    }

    range.add(-1);
    return range;
  }

  public static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) {
    int currSum = 0;
    int start = 0;

    for (int i = 0; i < n; i++) {
      currSum += arr[i];

      while (currSum > s && start <= i) {
        currSum = currSum - arr[start++];
      }

      if (currSum == s) {
        return new ArrayList<>(List.of(start + 1, i + 1));
      }
    }

    return new ArrayList<>(List.of(-1));
  }
}
