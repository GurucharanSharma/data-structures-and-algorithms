package array.lectures;

public class FrequenciesInASortedArray {

  public static void main(String[] args) {
    int[] array = new int[]{8, 8, 8, 5, 5, 5, 0, 0, 10, 20, 20, 20, 20, 21, 21, 21};
    System.out.println("Approach 1: ");
    printFrequencies(array);

    System.out.println("Approach 2: ");
    printFrequencies1(array);

    System.out.println("Approach 3: ");
    printFrequencies2(array);

    System.out.println("Approach 4: ");
    printFrequencies3(array);
  }

  /**
   * Approach 1
   */
  static void printFrequencies(int[] array) {
    int i = 1;
    int n = array.length;

    while (i < n) {
      int freq = 1;
      while (i < n && array[i] == array[i - 1]) {
        freq++;
        i++;
      }

      System.out.println(array[i - 1] + " : " + freq);
      i++;
    }

    // This condition ensures that if the last element of the array is unique (i.e., it is not the same as the second last element)
    // or if the array has only one element, the frequency of the last element is printed
    if (n == 1 || array[n - 1] != array[n - 2]) {
      System.out.println(array[i - 1] + " : " + 1);
    }
  }

  /**
   * Approach 2
   */
  private static void printFrequencies1(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int count = 1;

      while (i + 1 < arr.length && (arr[i + 1] == arr[i])) {
        count++;
        i++;
      }

      System.out.println(arr[i] + " = " + count);
    }
  }

  /**
   * Approach 3
   */
  private static void printFrequencies2(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int count = 1;

      while (i < arr.length && (arr[i] == arr[i - 1])) {
        count++;
        i++;
      }

      System.out.println(arr[i - 1] + " = " + count);
    }

    // This condition ensures that if the last element of the array is unique (i.e., it is not the same as the second last element)
    // or if the array has only one element, the frequency of the last element is printed
    if (arr.length == 1 || arr[arr.length - 1] != arr[arr.length - 2]) {
      System.out.println(arr[arr.length - 1] + " = " + 1);
    }
  }

  /**
   * Approach 4
   */
  static void printFrequencies3(int[] arr) {
    int count = 1;
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        count++;
      } else {
        System.out.println(arr[i] + " " + count);
        count = 1;
      }
    }

    System.out.println(arr[n - 1] + " " + count);
  }
}
