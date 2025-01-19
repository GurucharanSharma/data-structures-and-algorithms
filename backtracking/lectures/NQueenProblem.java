package backtracking.lectures;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

  public static void main(String[] args) {
    int N = 4;

//    Solution solution = new Solution();
//    List<List<String>> queen = solution.solveNQueens(N);
//    int i = 1;
//    for (List<String> it : queen) {
//      System.out.println("Arrangement " + i);
//      for (String s : it) {
//        System.out.println(s);
//      }
//
//      System.out.println();
//      i += 1;
//    }

    Solution1 solution1 = new Solution1();
    List<List<String>> queen1 = solution1.solveNQueens(N);
    int i = 1;
    for (List<String> it : queen1) {
      System.out.println("Arrangement " + i);
      for (String s : it) {
        System.out.println(s);
      }

      System.out.println();
      i += 1;
    }
  }
}

class Solution1 {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '_';
      }
    }

    int[] leftRow = new int[n];
    int[] upperDiagonal = new int[2 * n - 1];
    int[] lowerDiagonal = new int[2 * n - 1];

    solveNQueens(n, 0, leftRow, upperDiagonal, lowerDiagonal, board, result);

    return result;
  }

  private void solveNQueens(int n, int j, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, char[][] board, List<List<String>> result) {
    if (j == n) {
      result.add(construct(board, n));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (leftRow[i] == 0 && lowerDiagonal[i + j] == 0 && upperDiagonal[n - 1 + j - i] == 0) {
        board[i][j] = 'Q';
        leftRow[i] = 1;
        lowerDiagonal[i + j] = 1;
        upperDiagonal[n - 1 + j - i] = 1;
        solveNQueens(n, j + 1, leftRow, upperDiagonal, lowerDiagonal, board, result);
        board[i][j] = '_';
        leftRow[i] = 0;
        lowerDiagonal[i + j] = 0;
        upperDiagonal[n - 1 + j - i] = 0;
      }
    }
  }

  private List<String> construct(char[][] board, int n) {
    List<String> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < n; j++) {
        builder.append(board[i][j]).append(" ");
      }

      list.add(builder.toString().trim());
    }

    return list;
  }
}

class Solution {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '_';
      }
    }

    solveNQueens(n, 0, board, result);

    return result;
  }

  private void solveNQueens(int n, int j, char[][] board, List<List<String>> result) {
    if (j == n) {
      result.add(construct(board, n));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (isSafe(board, i, j, n)) {
        board[i][j] = 'Q';
        solveNQueens(n, j + 1, board, result);
        board[i][j] = '_';
      }
    }
  }

  private List<String> construct(char[][] board, int n) {
    List<String> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < n; j++) {
        builder.append(board[i][j]).append(" ");
      }

      list.add(builder.toString().trim());
    }

    return list;
  }

  private boolean isSafe(char[][] board, int i, int j, int n) {
    int row = i;
    int col = j;

    while (row >= 0 && col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }

      row--;
      col--;
    }

    row = i;
    col = j;
    while (col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }

      col--;
    }

    col = j;
    while (row < n && col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }

      row++;
      col--;
    }

    return true;
  }
}