package backtracking.lectures;

public class SudokuProblem {

  public static void main(String[] args) {
    char[][] board = {
        {'9', '5', '7', '_', '1', '3', '_', '8', '4'},
        {'4', '8', '3', '_', '5', '7', '1', '_', '6'},
        {'_', '1', '2', '_', '4', '9', '5', '3', '7'},
        {'1', '7', '_', '3', '_', '4', '9', '_', '2'},
        {'5', '_', '4', '9', '7', '_', '3', '6', '_'},
        {'3', '_', '9', '5', '_', '8', '7', '_', '1'},
        {'8', '4', '5', '7', '9', '_', '6', '1', '3'},
        {'_', '9', '1', '_', '3', '6', '_', '7', '5'},
        {'7', '_', '6', '1', '8', '5', '4', '_', '9'}
    };

    Solution solution = new Solution();
    solution.solveSudoku(board);
  }

  static class Solution {

    public void solveSudoku(char[][] board) {
      solveSudoku(board, board.length);

      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }
    }

    private boolean solveSudoku(char[][] board, int n) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (board[i][j] == '_') {
            for (char ch = '1'; ch <= '9'; ch++) {
              if (isValid(board, i, j, ch)) {
                board[i][j] = ch;

                if (solveSudoku(board, n)) {
                  return true;
                } else {
                  board[i][j] = '_';
                }
              }
            }

            return false;
          }
        }
      }

      return true;
    }

    private boolean isValid(char[][] board, int i, int j, char ch) {
      for (int index = 0; index < 9; index++) {
        if (board[i][index] == ch) {
          return false;
        }

        if (board[index][j] == ch) {
          return false;
        }

        if (board[3 * (i / 3) + (index / 3)][3 * (j / 3) + (index % 3)] == ch) {
          return false;
        }
      }

      return true;
    }
  }
}