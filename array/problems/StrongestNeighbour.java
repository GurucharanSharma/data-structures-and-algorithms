package array.problems;

public class StrongestNeighbour {

  public static void main(String[] args) {
//    int[] arr = {1, 2, 2, 3, 4, 5};
    int[] arr = {5, 5};

    maximumAdjacent(arr.length, arr);
  }

  // Function to find maximum for every adjacent pairs in the array.
  static void maximumAdjacent(int sizeOfArray, int[] arr) {
    for (int i = 1; i < sizeOfArray; i++) {
      System.out.print(Math.max(arr[i], arr[i - 1]) + " ");
    }
  }
}
