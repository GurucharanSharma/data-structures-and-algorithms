package searching.problems;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {

  public static void main(String[] args) {
//    int[] A = {1, 2, 3, 7, 5};
//    int s = 12;

//    int[] A = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48,
//        127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
//    int s = 468;

//    int[] A = {0};
//    int s = 1;

//    int[] A = {1, 2, 3, 4};
//    int s = 0;

//    int[] A = {1, 4, 5, 6, 0};
//    int s = 0;

    int[] A = {38, 22, 20, 12, 47, 23, 18, 13, 18, 47, 36, 42};
    int s = 174;

    System.out.println(subarraySum(A, A.length, s));
    System.out.println();
    System.out.println(subarraySum1(A, A.length, s));
    System.out.println();
    System.out.println(subarraySum2(A, A.length, s));
  }

  //Function to find a continuous sub-array which adds up to a given number.
  private static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
    int start = 0;
    int end = 0;

    if (s == 0) {
      return new ArrayList<>(List.of(-1));
    } else if (arr[0] == s) {
      return new ArrayList<>(List.of(1, 1));
    }

    int currSum = 0;

    while (start <= end && start <= arr.length && end <= arr.length) {
      if (currSum == s) {
        return new ArrayList<>(List.of(start + 1, end));
      } else if (end < arr.length && currSum < s) {
        currSum += arr[end++];
      } else if (start < arr.length) {
        currSum -= arr[start++];
      } else {
        break;
      }
    }

    return new ArrayList<>(List.of(-1));
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

  public static ArrayList<Integer> subarraySum3(int[] arr, int n, int s) {
    int start = 0;
    int last;
    boolean flag = false;
    int currsum = 0;
    ArrayList<Integer> res = new ArrayList<Integer>();

    // iterating over the array.
    for (int i = 0; i < n; i++) {
      // storing sum upto current element.
      currsum += arr[i];

      // checking if current sum is greater than or equal to given number.
      if (currsum >= s) {
        last = i;
        // we start from starting index till current index and do the
        // excluding part while s(given number) < currsum.
        while (s < currsum && start < last) {
          // subtracting the element from left i.e., arr[start]
          currsum -= arr[start];
          ++start;
        }

        // now if current sum becomes equal to given number, we store
        // the starting and ending index for the subarray.
        if (currsum == s) {
          res.add(start + 1);
          res.add(last + 1);

          // flag is set to true since subarray exists.
          flag = true;
          break;
        }
      }
    }
    // if no subarray is found, we store -1 in result else the found indexes.
    if (!flag) {
      res.add(-1);
    }
    // returning the result.
    return res;
  }
}
