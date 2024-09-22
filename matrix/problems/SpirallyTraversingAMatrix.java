package matrix.problems;

import java.util.ArrayList;

public class SpirallyTraversingAMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    System.out.println(spirallyTraverse(matrix));
  }

  // Function to return a list of integers denoting spiral traversal of matrix.
  static ArrayList<Integer> spirallyTraverse(int[][] matrix) {
    int left = 0;
    int top = 0;
    int right = matrix[0].length - 1;
    int bottom = matrix.length - 1;

    ArrayList<Integer> list = new ArrayList<>();

    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        list.add(matrix[top][i]);
      }

      top++;

      for (int i = top; i <= bottom; i++) {
        list.add(matrix[i][right]);
      }

      right--;

      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          list.add(matrix[bottom][i]);
        }

        bottom--;
      }

      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          list.add(matrix[i][left]);
        }

        left++;
      }
    }

    return list;
  }
}
