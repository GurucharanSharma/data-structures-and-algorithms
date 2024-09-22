package matrix.problems;

public class SearchInRowColumnSortedMatrix {

  public static void main(String[] args) {
//    int[][] matrix = {{3, 30, 38}, {36, 43, 60}, {40, 51, 69}};
//    int x = 62;

    int[][] matrix = {{18, 21, 27, 38, 55, 67}};
    int x = 55;

    System.out.println(search(matrix, matrix.length, matrix[0].length, x));
  }

  //Function to search a given number in row-column sorted matrix.
  static boolean search(int[][] matrix, int n, int m, int x) {
    int i = 0;
    int j = m - 1;

    while (i < n && j >= 0) {
      if (matrix[i][j] == x) {
        return true;
      } else if (matrix[i][j] < x) {
        i++;
      } else {
        j--;
      }
    }

    return false;
  }
}
