package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {

  public static int counter = 2;

  public static void main(String[] args) {
    int n = 5;

    System.out.println(isLucky(n));
    System.out.println();
    System.out.println(isLucky1(n));
    System.out.println();
    System.out.println(isLucky2(n));
  }

  /**
   * Approach 1
   */
  // Complete the function
  // n: Input n
  // Return True if the given number is a lucky number else return False
  public static boolean isLucky(int n) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }

    for (int i = 2; i <= list.size(); i++) {
      if (isDeleted(list, n, i, i - 1)) {
        return false;
      }
    }

    return true;
  }

  private static boolean isDeleted(List<Integer> list, int n, int count, int curr) {
    if (curr > n || curr >= list.size()) {
      return false;
    }

    if (list.get(curr) == n) {
      return true;
    }

    boolean status = isDeleted(list, n, count, curr + count);
    list.remove(curr);

    return status;
  }

  /**
   * Approach 2
   */
  public static boolean isLucky1(int n) {
    if (n <= 0) {
      return false;
    }

    int counter = 2; // Initialize the counter

    while (true) {
      // Check if divisible
      if (n % counter == 0) {
        return false;
      }

      // If n is less than counter squared
      if (n < counter) {
        return true;
      }

      // Shift the position
      n = n - (n / counter);
      counter++;
    }
  }

  /**
   * Approach 3: Recursive
   */
  static boolean isLucky2(int n) {
    if (counter > n) {
      return true;
    }
    if (n % counter == 0) {
      return false;
    }

    /*
    calculate next position of input no.
    Variable "next_position" is just for
    readability of the program we can
    remove it and update in "n" only
    */
    int next_position = n - (n / counter);

    counter++;
    return isLucky2(next_position);
  }
}
