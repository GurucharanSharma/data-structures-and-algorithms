package matrix.problems;

public class BooleanMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 0},
        {0, 0}
    };
  }

  //Function to modify the matrix such that if a matrix cell matrix[i][j]
  //is 1 then all the cells in its ith row and jth column will become 1.
  void booleanMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          
        }
      }
    }
  }
}
