package matrix.lectures;

public class MultidimensionalArrays {

  public static void main(String[] args) {

    int[][] arr = {
        {1, 2, 3, 8, 9},
        {4, 5, 6}
    };

    for (int[] row : arr) {
      for (int element : row) {
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }

}
