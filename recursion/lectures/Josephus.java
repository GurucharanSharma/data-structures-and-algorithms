package recursion.lectures;

import java.util.ArrayList;
import java.util.Arrays;

public class Josephus {

  public static void main(String[] args) {
    int n = 10;
    int k = 3;

    System.out.println(josephus(n, k)); // If indexes being with 0
    System.out.println(josephus(n, k) + 1); // If indexes being with 1

    // Iterative approach
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }

    System.out.println(josephus1(list, (k - 1), 0));
  }

  static int josephus(int n, int k) {
    if (n == 1) {
      return 0;
    }

    // Recursive case: If there are more than one person left (n > 1),
    // the function recursively calls itself with n - 1 people and the same value of k. The returned value
    // represents the position of the last remaining person in the smaller circle. Since we're looking for
    // the position in the original circle of size n, we need to adjust the position by adding k and taking
    // modulo n.
    return (josephus(n - 1, k) + k) % n;
  }

  // Iterative approach using list
  static int josephus1(ArrayList<Integer> list, int k, int index) {
    if (list.size() == 1) {
      return list.get(0);
    }

    // Identify the member to kill. Circle back to the beginning if the next
    // member of out of the bound of the array size.
    index = (index + k) % list.size();

    // Remove the dead member
    list.remove(index);

    return josephus1(list, k, index);
  }

  static int josephus2(int n, int k) {
    k--;
    int[] arr = new int[n];
    // Makes all the 'n' people alive by assigning them value = 1
    Arrays.fill(arr, 1);

    int cnt = 0, cut = 0, num = 1; // Cut = 0 gives the sword to 1st person.
    while (cnt < (n - 1)) { // Loop continues till n-1 person dies.
      while (num <= k) { // Checks next (kth) alive persons.
        cut++;
        cut = cut % n; // Checks and resolves overflow of Index.
        if (arr[cut] == 1) {
          num++; // Updates the number of persons alive.
        }
      }

      num = 1; // refreshes value to 1 for next use.
      arr[cut] = 0; // Kills the person at position of 'cut'
      cnt++; // Updates the no. of killed persons.
      cut++;
      cut = cut % n; // Checks and resolves overflow of Index.
      while (arr[cut] == 0) { // Checks the next alive person the sword is to be given.
        cut++;
        cut = cut % n; // Checks and resolves overflow of Index.
      }
    }
    return cut + 1; // Output is the position of the last man alive(Index + 1);
  }

  static int josephus3(int N, int k) {
    // Initialize variables i and ans with 1 and 0 respectively.
    int i = 1, ans = 0;

    // Run a while loop till i <= N
    while (i <= N) {
      // Update the Value of ans and Increment i by 1
      ans = (ans + k) % i;
      i++;
    }

    // Return required answer
    return ans + 1;
  }
}
