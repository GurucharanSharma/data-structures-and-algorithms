package stack.lectures;

public class LargestRectangleAreaWithAll1s {
    public static int execute(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int res = LargestRectangularArea.execute(matrix[0]);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
            }

            res = Math.max(res, LargestRectangularArea.execute(matrix[i]));
        }

        return res;
    }
}
