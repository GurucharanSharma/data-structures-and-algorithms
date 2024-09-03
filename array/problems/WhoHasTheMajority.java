package array.problems;

public class WhoHasTheMajority {

  public static void main(String[] args) {
//    int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5};
//    System.out.println(majorityWins(arr, arr.length, 4, 5));

    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(majorityWins(arr, arr.length, 1, 7));
  }

  // Function to find element with more appearances between two elements in an
  // array.
  public static int majorityWins(int[] arr, int n, int x, int y) {
    int countX = 0;
    int countY = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] == x) {
        countX++;
      } else if (arr[i] == y) {
        countY++;
      }
    }

    if (countX > countY) {
      return x;
    } else if (countY > countX) {
      return y;
    } else {
      return Math.min(x, y);
    }
  }
}
