package stack.problems;

import java.util.Stack;

public class TheCelebrityProblem {

  public static void main(String[] args) {
    int[][] mat = {
        {0, 1, 0},
        {0, 0, 0},
        {0, 1, 0}
    };

//    int[][] mat = {
//        {0, 1},
//        {1, 0}
//    };

    System.out.println(celebrity(mat));
    System.out.println();
    System.out.println(celebrity1(mat));
    System.out.println();
    System.out.println(celebrity2(mat));
  }

  // Function to find if there is a celebrity in the party or not.
  // Naive Approach – Using Adjacency List – O(N^2) Time and O(N) Space
  private static int celebrity(int[][] mat) {
    int[] inDegree = new int[mat.length];
    int[] outDegree = new int[mat.length];

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1) {
          outDegree[i] += 1;
          inDegree[j] += 1;
        }
      }
    }

    for (int i = 0; i < mat.length; i++) {
      if (inDegree[i] == mat.length - 1 && outDegree[i] == 0) {
        return i;
      }
    }

    return -1;
  }

  // Function to find if there is a celebrity in the party or not.
  // Efficient Approach: Using Stack - O(N) Time and O(N) Space
  private static int celebrity1(int[][] mat) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < mat.length; i++) {
      stack.push(i);
    }

    while (stack.size() > 1) {
      int i = stack.pop();
      int j = stack.pop();

      if (mat[i][j] == 1) {
        stack.push(j);  // Assuming j does not know i
      } else {
        stack.push(i);  // Assuming i does not know j
      }
    }

    int celebrity = stack.pop();

    for (int i = 0; i < mat.length; i++) {
      // If any person doesn't know 'C' or 'C' knows any person, return -1
      if (i != celebrity && (mat[i][celebrity] != 1 || mat[celebrity][i] == 1)) {
        return -1;
      }
    }

    return celebrity;
  }

  // Function to find if there is a celebrity in the party or not.
  private static int celebrity2(int[][] mat) {
    int i = 0;
    int j = mat.length - 1;

    while (i < j) {
      if (mat[j][i] == 1) {
        j--;
      } else {
        i++;
      }
    }

    int celebrity = i;
    for (i = 0; i < mat.length; i++) {
      if (i != celebrity && (mat[i][celebrity] != 1 || mat[celebrity][i] == 1)) {
        return -1;
      }
    }

    return celebrity;
  }
}
