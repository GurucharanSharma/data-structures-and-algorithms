package recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {

  public static int counter = 2;

  public static void main(String[] args) {
//    int n = 19;
//    int n = 5;
//    int n = 1111;
    int n = 123456789;

    System.out.println(isLucky(n));
    System.out.println();
    System.out.println(isLucky1(n));
    System.out.println();
    System.out.println(isLucky2(n));
  }

  // Approach 1: Naive recursive approach (Does not work for all the test cases)
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

  // Approach 2: Iterative approach
  public static boolean isLucky1(int n) {
    // 	If n is less than or equal to zero, it immediately returns false because
    // 	negative numbers and zero cannot be considered lucky. Lucky numbers are
    // 	always positive integers.
    if (n <= 0) {
      return false;
    }

    int counter = 2; // Initialize the counter

    while (true) {
      // Check if divisible
      if (n % counter == 0) {
        return false;
      }

      // If n is less than counter squared. One of the factors of n must be smaller than Math.sqrt(n). So if counter
      // is already greater than Math.sqrt(n) and no value of counter has yet divided n, there cannot be any other number left
      // now that would divide n. Hence, we can safely return true at this point.
      if (n < counter * counter) {
        return true;
      }

      // Shift the position
      // The expression n / counter gives you the number of positions that are eliminated in this step.
      // After eliminating every counter-th number, the size of the remaining sequence is reduced by n / counter elements.
      // Updates n to reflect the new position of the number being checked after the current elimination step.
      // This simulates the fact that after each elimination, the total number of positions is reduced.
      n = n - (n / counter);
      counter++;
    }
  }

  // Approach 3: Recursive (without using an extra function parameter)
  static boolean isLucky2(int n) {
    // If n is less than counter squared. One of the factors of n must be smaller than Math.sqrt(n). So if counter
    // is already greater than Math.sqrt(n) and no value of counter has yet divided n, there cannot be any other number left
    // now that would divide n. Hence, we can safely return true at this point.
    if (counter * counter > n) {
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
    n = n - (n / counter);

    counter++;
    return isLucky2(n);
  }

  // Approach 4: Recursive approach (with an extra function counter parameter)
  static boolean isLucky3(int n, int counter) {
    // If n is less than counter squared. One of the factors of n must be smaller than Math.sqrt(n). So if counter
    // is already greater than Math.sqrt(n) and no value of counter has yet divided n, there cannot be any other number left
    // now that would divide n. Hence, we can safely return true at this point.
    if (counter * counter > n) {
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
    n = n - (n / counter);

    return isLucky3(n, counter + 1);
  }
}
