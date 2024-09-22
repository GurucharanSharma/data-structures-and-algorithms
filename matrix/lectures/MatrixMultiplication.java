package matrix.lectures;

public class MatrixMultiplication {

  public static void main(String[] args) {
    testMultiply1();
    testMultiply2();
  }

  private static int[][] multiply(int[][] mat1, int[][] mat2) {
    int[][] mat3 = new int[mat1.length][mat2[0].length];

    for (int i = 0; i < mat1.length; i++) {
      for (int j = 0; j < mat2[0].length; j++) {
        mat3[i][j] = 0;
        for (int k = 0; k < mat1[0].length; k++) {
          mat3[i][j] += mat1[i][k] * mat2[k][j];
        }
      }
    }

    return mat3;
  }

  private static void testMultiply1() {
    int[][] mat1 = {{1, 2}, {3, 4}};
    int[][] mat2 = {{1, 2}, {3, 4}};

    int[][] result = multiply(mat1, mat2);

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        System.out.printf("%3s", result[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void testMultiply2() {
    int[][] mat1 = {{5, 6}, {8, 9}};
    int[][] mat2 = {{1, 2}, {4, 5}};

    int[][] result = multiply(mat1, mat2);

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        System.out.printf("%3s", result[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
