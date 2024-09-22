package matrix.lectures;

public class SearchInRowWiseAndColumnWiseSortedMatrix {

  public static void main(String[] args) {

//    int[][] arr = {
//        {1, 2, 3, 4, 5},
//        {6, 7, 8, 9, 10},
//        {11, 12, 13, 14, 15},
//        {16, 17, 18, 19, 20},
//        {21, 22, 23, 24, 25}
//    };

//    search(arr, 13);
//    search(arr, 113);

    int[][] arr = {{18, 21, 27, 38, 55, 67}};

    search(arr, 55);
  }

  private static void search(int[][] arr, int X) {
    int i = 0;
    int j = arr[0].length - 1;

    while (i < arr.length && j >= 0) {
      if (arr[i][j] == X) {
        System.out.println("i: " + i + " | j: " + j);
        return;
      } else if (arr[i][j] > X) {
        j--;
      } else {
        i++;
      }
    }

    System.out.println("Not found");
  }
}
