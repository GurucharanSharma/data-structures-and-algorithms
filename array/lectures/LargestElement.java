package array.lectures;

public class LargestElement {

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    largestElement(array);
    System.out.println();
    largestElement1(array);
  }

  static void largestElement(int[] arr) {
    int largest = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > largest) {
        largest = arr[i];
      }
    }

    System.out.println("Largest: " + largest);
  }

  private static void largestElement1(int[] arr) {
    if (arr.length == 0) {
      System.out.println("Empty array");
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(arr[i], max);
    }

    System.out.println(max);
  }
}
