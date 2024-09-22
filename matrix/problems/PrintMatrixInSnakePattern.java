package matrix.problems;

import java.util.ArrayList;

public class PrintMatrixInSnakePattern {

  public static void main(String[] args) {
//    int[][] matrix = {
//        {45, 48, 54},
//        {21, 89, 87},
//        {70, 78, 15}
//    };

    int[][] matrix = {
        {1, 2},
        {3, 4}
    };

    ArrayList<Integer> list = snakePattern(matrix);
    System.out.println(list);
  }

  //Function to return list of integers visited in snake pattern in matrix.
  static ArrayList<Integer> snakePattern(int[][] matrix) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < matrix.length; i++) {
      if (i % 2 == 0) {
        for (int j = 0; j < matrix[i].length; j++) {
          list.add(matrix[i][j]);
        }
      } else {
        for (int j = matrix[i].length - 1; j >= 0; j--) {
          list.add(matrix[i][j]);
        }
      }
    }

    return list;
  }
}
